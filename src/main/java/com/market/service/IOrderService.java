package com.market.service;

import java.util.List;

import com.market.domain.Order;
import com.market.domain.OrderDetail;

public interface IOrderService {

	public List<Order>  getOrderByCustomerId(String customerId);
	
	public OrderDetail getOrderDetailByOrderId(String orderId);
	
}
