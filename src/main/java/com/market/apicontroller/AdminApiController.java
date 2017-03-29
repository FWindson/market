package com.market.apicontroller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestHandler;
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
		//TODO:修改为登录名
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
	
	@RequestMapping(value = "/updateProduct",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String updateProduct(
			@RequestParam("id")String id,
			@RequestParam("name")String name,
			@RequestParam("nature")short nature,
			@RequestParam("price")double price,
			@RequestParam("stock")int stock,
			HttpSession session) {
		ResponseModel responseModel = ResponseModel.buildFailed("修改失败");;
		//TODO:修改为登录名
		String admin = "Windson";
		int influence = productService.update(id,name, price, nature ,stock, admin);
		if (influence > 0) {
			responseModel = ResponseModel.buildSuccess();
		}
		String json = JSON.toJSONString(responseModel);
		System.out.println(json);
		return json;
	}
	
	@RequestMapping(value = "/products",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String products(@RequestParam(required = false) Integer start, 
			@RequestParam(required = false) Integer length) {
		List<Product> list = productService.getAll();
		ResponseModel response = ResponseModel.buildSuccess(list);
		String json = JSON.toJSONString(response);
		return json;
	}
	
	@RequestMapping(value = "/deleteProduct",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String deleteProduct(String uuid){
		ResponseModel responseModel = ResponseModel.buildFailed("删除失败");
		int influence = productService.updateIsDeleted(uuid);
		if (influence > 0) {
			responseModel = ResponseModel.buildSuccess();
		}
		return JSON.toJSONString(responseModel);
	}
	
	@RequestMapping(value = "/addGoods",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String addGoods(String name,
			double price,
			short status,
			String intro,
			String description,
			List<Product> products){
		
		return JSON.toJSONString(products);
	}
	
}
