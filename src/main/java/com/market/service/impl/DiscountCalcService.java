package com.market.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.dao.DiscountCodeConfigurationDetailMapper;
import com.market.dao.DiscountCodeConfigurationMapper;
import com.market.domain.DiscountCodeConfiguration;
import com.market.domain.DiscountCodeConfigurationDetail;
import com.market.service.ICalculateService;
@Service("discountCalcService")
public class DiscountCalcService implements ICalculateService {

	@Autowired 
	private DiscountCodeConfigurationMapper discountCodeConfigurationMapper;
	
	@Autowired 
	private DiscountCodeConfigurationDetailMapper discountCodeConfigurationDetailMapper;
	@Override
	public double calculate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double calculate(String code, String userId,String goodsId,double price,double count) {
		double sumprice=price*count;
		DiscountCodeConfiguration dscountCodeConfiguration=getDiscountCodeConfiguration(code,userId);
		if(dscountCodeConfiguration!=null){
			DiscountCodeConfigurationDetail discountCodeConfigurationDetail=getDiscountCodeConfigurationDetail(dscountCodeConfiguration.getId());
		    if(discountCodeConfigurationDetail!=null){
		    	return sumprice-discountCodeConfigurationDetail.getDiscountValue(); //直接在原价上折扣
		    }
		    }
          return sumprice;	
	}


	/**
	 * 获取用户折扣
	 * @param code
	 * @param customer
	 * @return
	 */
	@Override
	public DiscountCodeConfiguration getDiscountCodeConfiguration(String code,String to_user) {
		return discountCodeConfigurationMapper.selectByDiscountCodeAndUserId(code, to_user);
	}
	/**
	 * 获取用户折扣详情
	 * @param discount_code_id
	 * @return
	 */
	@Override
	public DiscountCodeConfigurationDetail getDiscountCodeConfigurationDetail(String discount_code_id) {
		return discountCodeConfigurationDetailMapper.selectBydiscountCodeId(discount_code_id);
	}

}
