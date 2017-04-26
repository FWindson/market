package com.market.service;

import java.util.List;

import com.market.domain.Customer;
import com.market.domain.DiscountCodeConfiguration;
import com.market.domain.DiscountCodeConfigurationDetail;
import com.market.domain.Goods;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;

public interface IStoreService {
	
	
	/**
	 * 获取所有商品
	 * @return
	 */
	public List<Goods> getAllGoods();
	
	/**
	 *获取商品图片关联信息
	 * @param goodsId
	 * @return
	 */
	public GoodsImageRelation getGoodsImageRelationById(String goodsId);
	
	/**
	 *  获取商品图片信息
	 * @param id
	 * @return
	 */
	public Image getImge(String id);
	/**
	 * 获取商品信息
	 * @param id
	 * @return
	 */
	public Goods getGoods(String id);
	/**
	 * 获取客户信息
	 * @param customerId
	 * @return
	 */
	public Customer getCustomer(String customerId);
	

}
