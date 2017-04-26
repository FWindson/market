package com.market.apicontroller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Goods;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.service.ICalculateService;
import com.market.service.IStoreService;
import com.market.utils.BasicDataUtil;
import com.market.utils.LoggerUtil;
import com.market.vo.GoodsModel;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/api/store")
public class StoreApiController {
	
	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	@Autowired
	@Qualifier("promoCodeCalcService")
	private ICalculateService promoCodeCalcService;
	
	@RequestMapping(value = "getAllGoods",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String getAllGoods(HttpSession session) {		
		List<Goods> goodsList = storeService.getAllGoods();
	    List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
	    for(Goods goods:goodsList){
	    	GoodsModel goodsModel;
	    	GoodsImageRelation goodsImageRelation=storeService.getGoodsImageRelationById(goods.getId());
	    	Image image=storeService.getImge(goodsImageRelation.getImageId());
	    	goodsModel =new GoodsModel(goods,image);
	    	goodsModelList.add(goodsModel);
	    }
		String json = JSON.toJSONString(goodsModelList);
		LoggerUtil.getLogger(this).info("======== responseModel ========= : " + json);
		return json;
	}
	
	@RequestMapping(value = "addOrder",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String addOrder(HttpSession session) {		
		List<Goods> goodsList = storeService.getAllGoods();
	    List<GoodsModel> goodsModelList=new ArrayList<GoodsModel>();
	    for(Goods goods:goodsList){
	    	GoodsModel goodsModel;
	    	GoodsImageRelation goodsImageRelation=storeService.getGoodsImageRelationById(goods.getId());
	    	Image image=storeService.getImge(goodsImageRelation.getImageId());
	    	goodsModel =new GoodsModel(goods,image);
	    	goodsModelList.add(goodsModel);
	    }
		String json = JSON.toJSONString(goodsModelList);
		LoggerUtil.getLogger(this).info("======== responseModel ========= : " + json);
		return json;
	}
	
	@RequestMapping(value = "discount",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String discount(@RequestParam("discountCode") String discountCode,@RequestParam("goodsId") String goodsId,@RequestParam("price") double price,@RequestParam("count") double count,HttpSession session) {		
	String userId=BasicDataUtil.getCustomerUserID(session);
	ResponseModel responseModel;
	    if(discountCode==null){
	    	return "";
	    }
	    double simPrice=promoCodeCalcService.calculate(discountCode, userId, goodsId,price,count);
	    if(simPrice>0){
	    	 responseModel = ResponseModel.buildSuccess(simPrice);
	    }else{
	    	 responseModel = ResponseModel.buildFailed("该折扣码不正确，或折扣码超过使用上限，或该折扣码已过期。");
	    }	  
	    String json = JSON.toJSONString(responseModel);
		return 	json;
	}
	

}
