package com.market.service;

import com.market.domain.CommisionRecord;
import com.market.domain.Goods;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.domain.OrderInfluence;

public interface ICalcCommissionService {

	public Order addOrder(String code,double totalPrice,String customerId);
	
	public OrderDetail addOrderDetail(Goods good,String imageId,String orderId,int quantity,double totalPrice);
	
	public OrderInfluence addOrderInfluence(String orderId,short influenceType,double influenceValue);
	
	public CommisionRecord addCommisionRecord();
	
	//public CommissionConfiguration addCommissionConfiguration();
	
}
