package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.OrderDetailMapper;
import com.market.dao.OrderMapper;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.service.IOrderService;

@Service("orderService")
public class OrderService implements IOrderService {

	@Autowired
    private OrderMapper orderMapper;
	
	@Autowired
    private OrderDetailMapper orderDetailMapper;
	
	@Override
	public List<Order> getOrderByCustomerId(String customerId) {
		List<Order> orders =orderMapper.selectOrderByCustomerId(customerId);
		return orders;
	}

	@Override
	public OrderDetail getOrderDetailByOrderId(String orderId) {
		OrderDetail orderDetail=orderDetailMapper.selectOrderDetailByOrderId(orderId);
		return orderDetail;
	}
	
	

}
