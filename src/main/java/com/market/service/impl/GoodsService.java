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
	public List<Goods> getList(int pageIndex,int pageSize,String keyword,String orderby) {
		return goodsMapper.selectMany(pageIndex-1,pageSize,keyword,orderby);
	}

	@Override
	public List<Goods> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
