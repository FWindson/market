package com.market.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.dao.SalesMapper;
import com.market.domain.Sales;
import com.market.service.impl.SalesService;

@Controller
@RequestMapping("/sales")
public class SalesController {
	
	@Autowired
	private SalesMapper salesMapper;
	
	
	private Sales getSalesAccount() {
		//TODO：改为：微信wechatId->数据库userId->数据库sales
		Sales sales = salesMapper.selectByPrimaryKey("2aa1d034-216e-4a0c-b57a-81426cfc30d0");
		return sales;
	}
	
	/**
	 * 个人中心
	 * @return
	 */
	@RequestMapping("/center")
	public String center() {
		return "sales/center";
	}
	
	/**
	 * 我的客户
	 * @return
	 */
	@RequestMapping("/customers")
	public String customers() {
		return "sales/customers";
	}
	
	/**
	 * 客户订单
	 * @return
	 */
	@RequestMapping("/customer_orders")
	public String customerOrders() {
		return "sales/customer_orders";
	}
	
	/**
	 * 收入明细
	 * @return
	 */
	@RequestMapping("/incomes")
	public String incomes() {
		return "sales/incomes";
	}
	
	/**
	 * 货架-销售员可卖商品
	 * @return
	 */
	@RequestMapping("/goods_shelf")
	public String goodsShelf() {
		return "sales/goods_shelf";
	}
	
	/**
	 * 我的账户
	 * @return
	 */
	@RequestMapping("/my_account")
	public String myAccount(){
		return "sales/my_account";
	}
	
	
	
}
