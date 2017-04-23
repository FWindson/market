package com.market.service;

import com.market.domain.DiscountCodeConfiguration;
import com.market.domain.DiscountCodeConfigurationDetail;

/**
 * 折扣接口
 * @author bin
 *
 */
public interface ICalculateService {
	


	double calculate(String code,String userId,String goodsId,double price,double count);

	double calculate();
	
	DiscountCodeConfigurationDetail getDiscountCodeConfigurationDetail(String discount_code_id);

	DiscountCodeConfiguration getDiscountCodeConfiguration(String code, String to_user);

}
