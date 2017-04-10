package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CustomerMapper;
import com.market.domain.Customer;
import com.market.vo.PageDataModel;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerMapper customerMapper;

	public PageDataModel getCustomersBySales(String salesId,int pageIndex,int pageSize,String keyword){
		List<Customer> list = customerMapper.selectBySales(salesId, pageIndex, pageSize, keyword, "");
		int count = customerMapper.selectCountBySales(salesId, keyword);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, list);
		return pageDataModel;
	}
	
}
