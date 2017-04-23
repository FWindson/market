package com.market.service;

import java.util.List;

import com.market.domain.Customer;
import com.market.domain.Order;
import com.market.domain.OrderDetail;
import com.market.domain.Sales;

public interface ICustomerService {

	
	public List<Customer> getAllCustomer();
	
	public Sales getSalesById(String id);
	
	public List<Order> getOrderByCustomerId(String customerId);
	
	public OrderDetail getOrderDetailByOrderId(String orderId);
}
