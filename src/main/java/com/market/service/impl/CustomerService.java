package com.market.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CustomerMapper;
import com.market.dao.SalesMapper;
import com.market.domain.Customer;
import com.market.domain.Sales;
import com.market.java.extendsion.LinqArrayList;
import com.market.vo.CustomerViewModel;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;
	@Autowired
	private SalesMapper salesMapper;
	
	public PageDataModel getCustomers(String salesId,int pageIndex,int pageSize,String keyword,String orderby){
		List<Customer> list = customerMapper.selectMany(salesId, pageIndex, pageSize, keyword, orderby);
		int count = customerMapper.selectManyCount(salesId, keyword);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, list);
		return pageDataModel;
	}

	public PageDataModel getCustomerViewModels(String salesId,int pageIndex,int pageSize,String keyword,String orderby) {
		List<CustomerViewModel> listViewModel = new ArrayList<CustomerViewModel>();
		List<Customer> listCustomer = customerMapper.selectMany(salesId, pageIndex, pageSize, keyword, orderby);
		int count = customerMapper.selectManyCount(salesId, keyword);
		LinqArrayList<Customer> linqList = new LinqArrayList<>(listCustomer);
		List<String> listSalesIds = linqList.select(c -> c.getSalesId());
		LinqArrayList<Sales> listSales = new LinqArrayList<Sales>(salesMapper.selectInPrimaryKeys(listSalesIds));
		for (Customer customer : listCustomer) {
			CustomerViewModel customerViewModel = new CustomerViewModel();
			customerViewModel.setId(customer.getId());
			customerViewModel.setName(customer.getName());
			customerViewModel.setSalesId(customer.getSalesId());
			Sales sales = listSales.find(s -> s.getId().equals(customer.getSalesId()));
			if(sales != null) {
				customerViewModel.setSalesName(sales.getName());
				customerViewModel.setSetSalesTime(customer.getSetSalesTime());
			}
			customerViewModel.setUserId(customer.getUserId());
			customerViewModel.setCreateTime(customer.getCreateTime());
			listViewModel.add(customerViewModel);
		}
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, listViewModel);
		return pageDataModel;
	}
	
	public ResponseModel getCustomerModel(String customerId) {
		Customer customer = customerMapper.selectByPrimaryKey(customerId);
		Sales sales = salesMapper.selectByPrimaryKey(customer.getSalesId());
		CustomerViewModel customerViewModel = new CustomerViewModel();
		customerViewModel.setId(customer.getId());
		customerViewModel.setName(customer.getName());
		customerViewModel.setSalesId(customer.getSalesId());
		if(sales != null) {
			customerViewModel.setSalesName(sales.getName());
		}
		customerViewModel.setUserId(customer.getUserId());
		customerViewModel.setCreateTime(customer.getCreateTime());
		ResponseModel responseModel = ResponseModel.buildSuccess(customerViewModel);
		return responseModel;
	}
	
	
}
