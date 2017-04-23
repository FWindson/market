package com.market.service;

import java.util.List;

import com.market.domain.Sales;

public interface ISalesService {

	
	public List<Sales> getAllSales(String companyId);
}
