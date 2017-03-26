package com.market.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

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
		return "admin/goods_add";
	}
	
	/**
	 * 编辑商品
	 * @param model
	 * @return
	 */
	@RequestMapping("/goods_edit")
	public String goodsEdit(Model model) {
		model.addAttribute("adminName", "Windson");
		return "admin/goods_edit";
	}
}
