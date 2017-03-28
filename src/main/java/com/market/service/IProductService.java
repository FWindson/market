package com.market.service;

import java.util.List;

import com.market.domain.Product;

public interface IProductService {

	Product addProduct(String name, Short nature, double price, int stock, String admin);

	List<Product> getList(int pageIndex, int pageSize, String orderby, String keyword);

	List<Product> getAll();

	Product get(String uuid);
	
	int update(String id,String name,double price,short nature,int stock,String admin);
	
	int updateIsDeleted(String id);
}
