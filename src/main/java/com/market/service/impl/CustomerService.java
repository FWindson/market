package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CustomerMapper;
import com.market.dao.OrderDetailMapper;
import com.market.dao.OrderMapper;
import com.market.dao.SalesMapper;
import com.market.domain.Customer;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.domain.Sales;
import com.market.service.ICustomerService;
@Service("customerService")
public class CustomerService implements ICustomerService {


	
	@Autowired
	private CustomerMapper customerMapper;
	
	@Autowired
	private SalesMapper salesMapper;
	
	@Autowired OrderMapper orderMapper;
	
	@Autowired
    private OrderDetailMapper orderDetailMapper;
	
	@Override
	public List<Customer> getAllCustomer() {
		List<Customer>  list=customerMapper.selectAll();
		return list;
	}


	@Override
	public Sales getSalesById(String id) {
		Sales sales=salesMapper.selectByPrimaryKey(id);
		return sales;
	}
	
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
