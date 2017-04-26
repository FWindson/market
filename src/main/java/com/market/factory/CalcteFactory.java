package com.market.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.market.service.ICalculateService;
import com.market.service.impl.DiscountCalcService;
import com.market.service.impl.PromoCodeCalcService;

public class CalcteFactory {
	@Autowired
	@Qualifier("calculateService")
	private static ICalculateService discountCalcService;
	@Autowired
	@Qualifier("promoCodeCalcService")
	private static ICalculateService promoCodeCalcService;
	/**
	 * 
	 * @param type折扣类型
	 * @return
	 */
	public static  ICalculateService das(int type){
		 if(type==1){
			
			 return promoCodeCalcService;   //优惠码方式
		 }else if(type==2){
			return  discountCalcService;    //折扣方式
		 }
		 return null; 
	}
}
