package com.market.apicontroller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Product;
import com.market.service.IProductService;
import com.market.utils.SessionKeyUtil;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/api/admin")
public class AdminApiController {
	
	@Autowired
	@Qualifier("productService")
	IProductService productService;
	
	@RequestMapping(value = "/addProduct",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String addProduct(@RequestParam("name")String name,
			@RequestParam("nature")short nature,
			@RequestParam("price")double price,
			@RequestParam("stock")int stock,
			HttpSession session) {
		ResponseModel responseModel;
		/*String json = JSON.toJSONString(product);*/
		/*String admin = session.getAttribute(SessionKeyUtil.LoginAdministratorName).toString();*/
		String admin = "Windson";
		Product product = productService.addProduct(name, nature, price, stock, admin);
		if (product != null) {
			responseModel = ResponseModel.buildSuccess(product);
		}
		else {
			responseModel = ResponseModel.buildFailed("出现异常");
		}
		String json = JSON.toJSONString(responseModel);
		System.out.println(json);
		return json;
	}
	
}
