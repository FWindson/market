package com.market.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.SalesMapper;
import com.market.domain.Sales;
import com.market.service.ISalesService;

@Service("salesService")
public class SalesService implements ISalesService {
	
	@Autowired
	SalesMapper salesmpper;
	public List<Sales> getAllSales(String companyId){
		List<Sales> list=salesmpper.selectSalesByCompanyId(companyId);
		return list;
	}

}
