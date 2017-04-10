package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.GoodsProductRelationMapper;
import com.market.vo.ProductOfGoodsEditModel;

@Service
public class GoodsProductRelationService {

	@Autowired
	private GoodsProductRelationMapper goodsProductRelationMapper;
	
	public List<ProductOfGoodsEditModel> getProductsOfGoods(String goodsId){
		return goodsProductRelationMapper.selectProudctsByGoodsId(goodsId);
	}
	
}
