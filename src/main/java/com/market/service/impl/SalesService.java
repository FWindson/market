package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.CustomerMapper;
import com.market.dao.SalesMapper;
import com.market.domain.Customer;
import com.market.domain.Sales;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Service
public class SalesService {
	
	@Autowired
	private SalesMapper salesMapper;
	@Autowired
	private CustomerMapper customerMapper;

	public PageDataModel getSales(String companyId,int pageIndex,int pageSize,String keyword){
		List<Sales> list = salesMapper.selectByCompany(companyId, pageIndex, pageSize, keyword);
		int count = salesMapper.selectCountByCompany(companyId, keyword);
		PageDataModel pageDataModel = PageDataModel.buildSuccess(count, list);
		return pageDataModel;
	}
	
	public ResponseModel getSalesDetail(String salesId){
		ResponseModel responseModel;
		try {
			Sales sales = salesMapper.selectByPrimaryKey(salesId);
			if (sales != null) {
				responseModel = ResponseModel.buildSuccess(sales);
			}
			else{
				responseModel = ResponseModel.buildFailed("未找到该销售员");
			}
		} catch (Exception e) {
			//TODO:logger
			responseModel = ResponseModel.buildFailed(e.getMessage());
		}
		return responseModel;
	}
	
}
