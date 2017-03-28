package com.market.service.impl;

import java.util.Date;
import java.util.List;
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

	@Override
	public List<Product> getList(int pageIndex, int pageSize, String orderby, String keyword) {
		List<Product> listProduct = productMapper.selectMany(pageIndex, pageSize, orderby, keyword);
		return listProduct;
	}

	@Override
	public List<Product> getAll() {
		List<Product> listProduct = productMapper.selectAll();
		return listProduct;
	}
	
	@Override
	public Product get(String uuid){
		Product product = productMapper.selectByPrimaryKey(uuid);
		return product;
	}

	@Override
	public int update(String id,String name,double price,short nature,int stock,String admin) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setPrice(price);
		product.setNature(nature);
		product.setStock(stock);
		product.setUpdateTime(new Date());
		product.setUpdateBy(admin);
		return productMapper.updateByPrimaryKey(product);
	}
	
	@Override
	public int updateIsDeleted(String id){
		return productMapper.updateIsDeleted(id);
	}
	
}
