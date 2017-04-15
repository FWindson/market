package com.market.apicontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Goods;
import com.market.service.impl.GoodsService;

@Controller
@RequestMapping("api/goods")
public class GoodsApiController {
	@Autowired
	private GoodsService goodsService;

	@RequestMapping(value = "/getAll", produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	@ResponseBody()
	public String getAll(){
		List<Goods> list = goodsService.getAll();
		String json = JSON.toJSONString(list);
		return json;
	}
	
}
