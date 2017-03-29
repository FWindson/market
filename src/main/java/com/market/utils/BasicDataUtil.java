package com.market.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.market.domain.BasicData;
import com.market.service.IBasicDatatService;
import com.market.service.impl.BasicDataService;

public class BasicDataUtil {
	
	/**
	 * 商品状态-初始化
	 */
	public final static int GoodsStatus_Init = 1;
	/**
	 * 商品状态-即将上市
	 */
	public final static int GoodsStatus_CommingSoon = 1;
	/**
	 * 商品状态-上架
	 */
	public final static int GoodsStatus_Shelve = 1;
	/**
	 * 商品状态-下架
	 */
	public final static int GoodsStatus_OffShelve = 1;
	
	/**
	 * 产品性质
	 */
	public final static String ProductDomain_Nature = "product_nature";	
	/**
	 * 商品状态
	 */
	public final static String GoodsDomain_Status = "goods_status";
	
	/**
	 * 基础数据列表（内存里）
	 */
	private static List<BasicData> basicDatas;
	/*private static List<BasicData> basicDatas = new BasicDataService().getBasicDatas();*/
	
	/**
	 * 获取基础数据列表
	 * @return
	 */
	public static List<BasicData> getBasicDatas() {
		if (basicDatas == null) {
			IBasicDatatService basicDatatService = (IBasicDatatService)SpringContextUtil.getBeanByClass(BasicDataService.class);
			basicDatas = basicDatatService.getBasicDatas();
		}
		return basicDatas;
	}
	
	/**
	 * 根据获取基础数据
	 * @param domain 领域
	 * @return
	 */
	public static List<BasicData> getBasicDataByDomain(String domain) {
		if (basicDatas == null) {
			IBasicDatatService basicDatatService = (IBasicDatatService)SpringContextUtil.getBeanByClass(BasicDataService.class);
			basicDatas = basicDatatService.getBasicDatas();
		}
		List<BasicData> listByDomain = new ArrayList<BasicData>();
		for (BasicData basicData : basicDatas) {
			if (basicData.getDomain().equals(domain)) {
				listByDomain.add(basicData);
			}
		}
		return listByDomain;
	}
}
