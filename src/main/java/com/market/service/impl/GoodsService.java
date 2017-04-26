package com.market.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.GoodsImageRelationMapper;
import com.market.dao.GoodsMapper;
import com.market.dao.GoodsProductRelationMapper;
import com.market.dao.ImageMapper;
import com.market.domain.Goods;
import com.market.domain.GoodsImageRelation;
import com.market.domain.GoodsProductRelation;
import com.market.domain.Image;
import com.market.java.extendsion.LinqArrayList;
import com.market.requestmodel.GoodsForm;
import com.market.requestmodel.GoodsFormProduct;
import com.market.service.IGoodsService;
import com.market.utils.LoggerUtil;
import com.market.vo.GoodsEditModel;
import com.market.vo.GoodsOfSalesGoodsShelfVO;
import com.market.vo.PageDataModel;
import com.market.vo.ProductOfGoodsEditModel;
import com.market.vo.ResponseModel;

@Service("goodsService")
public class GoodsService implements IGoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsProductRelationMapper goodsProductRelationMapper;
	@Autowired
	private GoodsImageRelationMapper goodsImageRelationMapper;
	@Autowired
	private ImageMapper imageMapper;
	

	@Transactional
	public int addGoods(GoodsForm goodsForm,String admin) {
		int influence = 0;
		Goods goods = new Goods();
		goods.setId(UUID.randomUUID().toString());
		goods.setName(goodsForm.getName());
		goods.setPrice(goodsForm.getPrice());
		goods.setMarketPrice(goodsForm.getMarketPrice());
		goods.setStatus(goodsForm.getStatus());
		goods.setStock(goodsForm.getStock());
		goods.setIntro(goodsForm.getIntro());
		goods.setDescription(goodsForm.getDescription());
		goods.setCreateTime(new Date());
		goods.setCreateBy(admin);
		goods.setIsDeleted(false);
		influence += goodsMapper.insert(goods);
		List<GoodsProductRelation> listRelation = new ArrayList<GoodsProductRelation>();
		for (GoodsFormProduct productForm : goodsForm.getProducts()) {
			GoodsProductRelation relation = new GoodsProductRelation();
			relation.setId(UUID.randomUUID().toString());
			relation.setGoodsId(goods.getId());
			relation.setProductId(productForm.getId());
			relation.setQuantity(productForm.getQuantity());
			relation.setCreateTime(new Date());
			relation.setIsDeleted(false);
			listRelation.add(relation);
		}
		influence += goodsProductRelationMapper.insert(listRelation);
		return influence;
	}

	@Override
	public PageDataModel getList(int pageIndex,int pageSize,String keyword,String orderby) {
		List<Goods> listGoods = goodsMapper.selectMany(pageIndex,pageSize,keyword,orderby); 
		int goodsTotal = goodsMapper.selectManyCount(keyword);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(goodsTotal, listGoods);
		return pageDataModel;
	}

	@Override
	public List<Goods> getAll() {
		return goodsMapper.selectAll();
	}

	@Override
	public Goods getSingle(String id) {
		Goods goods = goodsMapper.selectByPrimaryKey(id);
		if(goods.getIsDeleted() == true) {
			goods = null;
		}
		return goods;
	}

	@Transactional
	@Override
	public int updateGoods(GoodsForm goodsForm, String admin) {
		int influence = 0;
		Goods goods = goodsMapper.selectByPrimaryKey(goodsForm.getId());
		goods.setName(goodsForm.getName());
		goods.setPrice(goodsForm.getPrice());
		goods.setMarketPrice(goodsForm.getMarketPrice());
		goods.setStatus(goodsForm.getStatus());
		goods.setStock(goodsForm.getStock());
		goods.setIntro(goodsForm.getIntro());
		goods.setDescription(goodsForm.getDescription());
		goods.setCreateTime(new Date());
		goods.setCreateBy(admin);
		goods.setIsDeleted(false);
		influence += goodsMapper.updateByPrimaryKey(goods);
		List<GoodsProductRelation> listRelationExisted = goodsProductRelationMapper.selectByGoodsId(goods.getId());
		goodsProductRelationMapper.deleteRelation(listRelationExisted);
		List<GoodsProductRelation> listRelation = new ArrayList<GoodsProductRelation>();
		for (GoodsFormProduct productForm : goodsForm.getProducts()) {
			GoodsProductRelation relation = new GoodsProductRelation();
			relation.setId(UUID.randomUUID().toString());
			relation.setGoodsId(goods.getId());
			relation.setProductId(productForm.getId());
			relation.setQuantity(productForm.getQuantity());
			relation.setCreateTime(new Date());
			relation.setIsDeleted(false);
			listRelation.add(relation);
		}
		influence += goodsProductRelationMapper.insert(listRelation);
		return influence;
	}

	@Override
	public ResponseModel getGoodsEditModel(String goodsId) {
		GoodsEditModel goodEditModel = new GoodsEditModel();
		// 商品
		Goods goods = this.getSingle(goodsId);
		// 包含产品
		List<ProductOfGoodsEditModel> products = goodsProductRelationMapper.selectProudctsByGoodsId(goodsId);
		List<GoodsImageRelation> listGoodsImageRelation =  goodsImageRelationMapper.selectMany(goodsId, "");
		// 商品图片
		List<Image> listImage = new ArrayList<Image>();
		for(GoodsImageRelation relation : listGoodsImageRelation) {
			Image image = imageMapper.selectByPrimaryKey(relation.getImageId());
			listImage.add(image);
		}
		goodEditModel.goods = goods;
		goodEditModel.products = products;
		goodEditModel.images = listImage;
		ResponseModel responseModel = ResponseModel.buildSuccess(goodEditModel);
		return responseModel;
	}

	@Override
	public ResponseModel deleteGoods(String goodsId, String admin) {
		ResponseModel responseModel = null;
		try {
			Goods goods = goodsMapper.selectByPrimaryKey(goodsId);
			goods.setIsDeleted(true);
			goods.setUpdateTime(new Date());
			goods.setUpdateBy(admin);
			goodsMapper.updateByPrimaryKey(goods);
			responseModel = ResponseModel.buildSuccess();
		} catch (Exception e) {
			LoggerUtil.getLogger(this).error("删除商品失败",e);
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}
	
	@Override
	public PageDataModel getGoodsShelf(Integer pageIndex,Integer pageSize,String keyword,String orderby) {
		List<GoodsOfSalesGoodsShelfVO> list = new ArrayList<GoodsOfSalesGoodsShelfVO>();
		List<Goods> listGoods = goodsMapper.selectMany(pageIndex, pageSize, keyword, orderby);
		int count = goodsMapper.selectManyCount(keyword);
		for(Goods goods : listGoods) {
			GoodsOfSalesGoodsShelfVO vo = new GoodsOfSalesGoodsShelfVO();
			vo.id = goods.getId();
			vo.name = goods.getName();
			vo.price = goods.getPrice();
			vo.createTime = goods.getCreateTime();
			List<GoodsImageRelation> listGoodsImageRelation = goodsImageRelationMapper.selectMany(goods.getId(), "");
			if (listGoodsImageRelation.size() > 0) {
				Image image = imageMapper.selectByPrimaryKey(listGoodsImageRelation.get(0).getImageId());
				vo.imageUrl = image.getRelativePath();
			}
			list.add(vo);
		}
		PageDataModel dataModel = PageDataModel.buildSuccess(count, list);
		return dataModel;
	}
	
}
