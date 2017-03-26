package com.market.service.impl;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.ProductMapper;
import com.market.domain.Product;
import com.market.service.IProductService;
import com.market.utils.PrimaryKeyUtil;

@Service("productService")
public class ProductService implements IProductService {

	@Autowired
	ProductMapper productMapper;
	
	@Override
	public Product addProduct(String name, Short nature, double price, int stock,String admin) {
		Product product = new Product();
		try {
			product.setId(PrimaryKeyUtil.buildUUID());
			product.setName(name);
			product.setNature(nature);
			product.setPrice(price);
			product.setStock(stock);
			product.setCreateTime(new Date());
			product.setCreateBy(admin);
			product.setIsDeleted(false);
			productMapper.insert(product);
		} catch (Exception e) {
			product = null;
		}
		return product;
	}

}
