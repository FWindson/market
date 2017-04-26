package com.market.apicontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.market.service.impl.GoodsService;
import com.market.vo.PageDataModel;

@Controller
@RequestMapping("/api/sales")
public class SalesApiController {

	@Autowired
	private GoodsService goodsService;
	
	@RequestMapping(value = "/getGoodsShelf", method = RequestMethod.POST)
	@ResponseBody()
	public PageDataModel getGoodsShelf(Integer pageIndex,Integer pageSize,String keyword,String orderby) {
		PageDataModel dataModel = goodsService.getGoodsShelf(pageIndex, pageSize, keyword, orderby);
		return dataModel;
	}
	
}
