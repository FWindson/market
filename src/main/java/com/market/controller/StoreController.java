package com.market.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Goods;
import com.market.domain.GoodsImageRelation;
import com.market.domain.Image;
import com.market.service.IStoreService;
import com.market.vo.GoodsModel;

@Controller
@RequestMapping(value = "/store")
public class StoreController {

	@Autowired
	@Qualifier("storeService")
	private IStoreService storeService;
	
	private final static Log logger = LogFactory.getLog(StoreController.class);

	@RequestMapping(value = "/list")
	public String list(String id, Model model) {		
		Goods goods = storeService.getGoods(id);
	    GoodsModel goodsModel;
	    GoodsImageRelation goodsImageRelation=storeService.getGoodsImageRelationById(goods.getId());
	     Image image=storeService.getImge(goodsImageRelation.getImageId());
	    goodsModel =new GoodsModel(goods,image);
	    model.addAttribute("name", goods.getName());
	    model.addAttribute("descirption", goods.getDescription());
	    model.addAttribute("path", image.getRelativePath());
	    model.addAttribute("price", goods.getPrice());
		return "weChatStore/goodsDetail";
	}

	@RequestMapping(value = "/goods")
	public String goods() {
		return "weChatStore/goods";
	}

}
