package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@RequestMapping(value = "/allCustomer")
	public String getCustomerList() {
		return "customer/customer_list";
	}
	
	@RequestMapping(value = "/getOrders")
	public String getOrders() {
		return "customer/customer_order_list";
	}
}
