package com.market.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.market.domain.BasicData;
import com.market.domain.Goods;
import com.market.domain.Product;
import com.market.service.IGoodsService;
import com.market.service.IProductService;
import com.market.utils.BasicDataUtil;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	@Qualifier("productService")
	IProductService productService;
	
	@Autowired
	@Qualifier("goodsService")
	IGoodsService goodsService;
	
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("adminName", "Windson");
		return "admin/index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("adminName", "Windson");
		return "admin/dashboard";
	}
	
	/**
	 * 商品列表
	 * @param model
	 * @return
	 */
	@RequestMapping("/goods_list")
	public String goodsList(Model model) {
		model.addAttribute("adminName", "Windson");
		return "admin/goods_list";
	}
	
	/**
	 * 添加商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/goods_add")
	public String goodsAdd(Model model) {
		model.addAttribute("adminName", "Windson");
		List<Product> listProduct = productService.getAll();
		List<BasicData> listStatusData = BasicDataUtil.getBasicDataByDomain(BasicDataUtil.GoodsDomain_Status);
		model.addAttribute("products", listProduct);
		model.addAttribute("goodsStatus", listStatusData);
		return "admin/goods_add";
	}
	
	/**
	 * 编辑商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/goods_edit")
	public String goodsEdit(String goodsId,
			Model model) {
		List<Product> listProduct = productService.getAll();
		List<BasicData> listStatusData = BasicDataUtil.getBasicDataByDomain(BasicDataUtil.GoodsDomain_Status);
		model.addAttribute("products", listProduct);
		model.addAttribute("goodsStatus", listStatusData);
		model.addAttribute("goodsId",goodsId);
		return "admin/goods_edit";
	}
	
	/**
	 * 产品列表
	 * @return
	 */
	@RequestMapping("/product_list")
	public String productList() {
		return "admin/product_list";
	}
	
	/**
	 * 添加产品
	 * @return
	 */
	@RequestMapping("/product_add")
	public String productAdd(ModelMap modelMap){
		List<BasicData> productNatures = BasicDataUtil.getBasicDataByDomain(BasicDataUtil.ProductDomain_Nature);
		modelMap.addAttribute("productNature", productNatures);
		//TODO:System.out
		System.out.println(JSON.toJSONString(productNatures));
		return "admin/product_add";
	}
	
	/**
	 * 编辑产品
	 * @return
	 */
	@RequestMapping("/product_edit")
	public String productEdit(String uuid
			,Model model){
		// 产品
		Product product = productService.get(uuid);
		model.addAttribute("product", product);
		// 产品属性
		List<BasicData> productNatures = BasicDataUtil.getBasicDataByDomain(BasicDataUtil.ProductDomain_Nature);
		//TODO:System.out
		System.out.println(JSON.toJSONString(productNatures));
		model.addAttribute("productNature", productNatures);
		return "admin/product_edit";
	}
	
	
	
}
