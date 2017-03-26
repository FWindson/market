package com.market.service;

import com.market.domain.Product;

public interface IProductService {

	Product addProduct(String name,String nature,double price,short stock);
	
}
