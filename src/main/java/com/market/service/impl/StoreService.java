package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CustomerMapper;
import com.market.dao.DiscountCodeConfigurationDetailMapper;
import com.market.dao.DiscountCodeConfigurationMapper;
import com.market.dao.GoodsImageRelationMapper;
import com.market.dao.GoodsMapper;
import com.market.dao.ImageMapper;
import com.market.domain.Customer;
import com.market.domain.DiscountCodeConfiguration;
import com.market.domain.DiscountCodeConfigurationDetail;
import com.market.domain.Goods;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.service.IStoreService;

@Service("storeService")
public class StoreService implements IStoreService {
	
	@Autowired
	private GoodsMapper goodsMapper;
	
	@Autowired
	private ImageMapper imageMapper;	
	
	@Autowired
	private GoodsImageRelationMapper goodsImageRelationMapper;
	
	@Autowired 
	private CustomerMapper customerMapper;
	

	
	@Override
	public List<Goods> getAllGoods() {	
		 List<Goods> listgoods=goodsMapper.selectAll();
		return listgoods;
	}




	@Override
	public GoodsImageRelation getGoodsImageRelationById(String goodsId) {
		return goodsImageRelationMapper.selectByGoodsId(goodsId);
	}




	@Override
	public Image getImge(String id) {
		return imageMapper.selectByPrimaryKey(id);
	}




	@Override
	public Goods getGoods(String id) {
		return goodsMapper.selectByPrimaryKey(id);
		
	}




	@Override
	public Customer getCustomer(String userId) {
		return customerMapper.selectByUserId(userId);
	}



}
