package com.market.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.dao.GoodsMapper;
import com.market.dao.GoodsProductRelationMapper;
import com.market.domain.Goods;
import com.market.domain.GoodsProductRelation;
import com.market.requestmodel.GoodsForm;
import com.market.requestmodel.GoodsFormProduct;
import com.market.service.IGoodsService;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Service("goodsService")
public class GoodsService implements IGoodsService{

	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private GoodsProductRelationMapper goodsProductRelationMapper;

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
	
}
