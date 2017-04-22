package com.market.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.market.domain.Customer;
import com.market.domain.Goods;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.factory.SerialNumberFactory;
import com.market.service.ICalculateService;
import com.market.service.IStoreService;
import com.market.utils.BasicDataUtil;
import com.market.utils.SessionKeyUtil;
import com.market.vo.GoodsModel;

@Controller
@RequestMapping(value = "/store")
public class StoreController {

	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	@Autowired
	@Qualifier("promoCodeCalcService")
	private ICalculateService promoCodeCalcService;
	private final static Log logger = LogFactory.getLog(StoreController.class);

	@RequestMapping(value = "/goodsDetail")
	public String goodsDetail(String id, String companyId, String salesId, Model model) {
		Goods goods = storeService.getGoods(id);
		GoodsModel goodsModel;
		GoodsImageRelation goodsImageRelation = storeService.getGoodsImageRelationById(goods.getId());
		Image image = storeService.getImge(goodsImageRelation.getImageId());
		goodsModel = new GoodsModel(goods, image);
		model.addAttribute("name", goods.getName());
		model.addAttribute("descirption", goods.getDescription());
		model.addAttribute("path", image.getRelativePath());
		model.addAttribute("price", goods.getPrice());
		model.addAttribute("id", goods.getId());
		model.addAttribute("companyId", companyId);
		model.addAttribute("salesId", salesId);
		return "weChatStore/goodsDetail";
	}

	@RequestMapping(value = "/orderConfirm")
	public String orderConfirm(String companyId, String salesId, double sumPrice, String goodsId, String count,String discountCode,
			Model model,HttpSession session) {
		Goods goods = storeService.getGoods(goodsId);
		GoodsImageRelation goodsImageRelation = storeService.getGoodsImageRelationById(goods.getId());
		Image image = storeService.getImge(goodsImageRelation.getImageId());
		String orderNo=SerialNumberFactory.getSequence();
		Customer custome=storeService.getCustomer(BasicDataUtil.getCustomerUserID(session));
		model.addAttribute("name", goods.getName());
		model.addAttribute("descirption", goods.getDescription());
		model.addAttribute("path", image.getRelativePath());
		model.addAttribute("price", goods.getPrice());
		model.addAttribute("id", goods.getId());
		model.addAttribute("companyId", companyId);
		model.addAttribute("salesId", salesId);
		model.addAttribute("count", count);
		model.addAttribute("sumPrice", sumPrice);
		model.addAttribute("orderNo", orderNo);
		model.addAttribute("customerName", custome.getName());
		model.addAttribute("discountCode", discountCode);
		return "weChatStore/orderConfirm";
	}

	@RequestMapping(value = "/goods")
	public String goods(String companyId, String salesId, Model model) {
		model.addAttribute("companyId", companyId);
		model.addAttribute("salesId", salesId);
		return "weChatStore/goods";
	}

	@RequestMapping(value = "/placeOrder")
	public String goodsDetail(String companyId, String salesId, String discountCode, String goodsId, double count,HttpSession session) {
		Goods goods = storeService.getGoods(goodsId);
		String userId=BasicDataUtil.getCustomerUserID(session);
		double simPrice=promoCodeCalcService.calculate(discountCode, userId, goodsId,goods.getPrice(),count);
		
		return "weChatStore/goodsDetail";
	}
	

}
