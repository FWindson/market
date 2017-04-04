package com.market.dao.provider;

import org.apache.ibatis.jdbc.SQL;

import com.market.domain.Product;
import com.market.utils.TableConstUtil;

public class ProductMapperProvider {
	
//	public String insertProduct(Product product){
//		return new SQL(){
//			{
//				INSERT_INTO(TableConstUtil.Table_Product);
//				if(product.getName() != null && !product.getName().equals("")){
//					VALUES("name", "#{name}");
//				}
//				if(product.getNature() != null && !product.getNature().equals("")){
//					VALUES("remark", "#{remark}");
//				}
//				if(product.getPrice() != null){
//					VALUES("remark", "#{remark}");
//				}
//			}
//		}.toString();
//	}
	
}
