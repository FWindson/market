package com.market.service;

import com.market.domain.Product;

public interface IProductService {

	Product addProduct(String name,Short nature,double price,int stock,String admin);
	
}
