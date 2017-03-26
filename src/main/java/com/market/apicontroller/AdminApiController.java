package com.market.apicontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Product;

@Controller
@RequestMapping("/api/admin")
public class AdminApiController {
	
	@RequestMapping(value = "/addProduct",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String addProduct(@RequestParam("name")String name,
			@RequestParam("nature")String nature,
			@RequestParam("price")String price,
			@RequestParam("stock")String stock) {
		/*String json = JSON.toJSONString(product);*/
		String str = name + nature + price + stock;
		System.out.println(str);
		return str;
	}
	
}
