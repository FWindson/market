package com.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.BasicData;
import com.market.service.IBasicDatatService;

@Controller
@RequestMapping("/goods")
public class GoodsController {

	@Autowired
	@Qualifier("basicDataService")
	private IBasicDatatService basicDataService;
	
	@RequestMapping(value = "/basicData",produces = "text/json;charset=utf8")
	@ResponseBody
	public String basicData() {
		List<BasicData> listBasicData = basicDataService.getBasicDatas();
		String json = JSON.toJSONString(listBasicData);
		System.out.println(json);
		return json;
	}
}
