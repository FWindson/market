package com.market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.market.domain.Company;
import com.market.service.ICompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;
	
	@RequestMapping(value = "getCompany",produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	@ResponseBody
	public String getCompany(
			@RequestParam("name") String name,
			@RequestParam("password") String password) {
		Company company = companyService.getCompany(name, password);
		return JSON.toJSONString(company);
	}
	
	@RequestMapping(value = "getAll",produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	@ResponseBody
	public String getAll() {
		List<Company> list = companyService.getAll();
		return JSON.toJSONString(list);
	}
	
	@RequestMapping(value = "/home")
	public String home() {
		return "company_home";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "company_login";
	}
	
	@RequestMapping(value = "/login_submit",method = RequestMethod.POST)
	public ModelAndView loginSubmit(@RequestParam("userName") String userName,
			@RequestParam("password") String password,
			HttpSession session,
			ModelAndView modelAndView) {
		session.setAttribute("userName", userName);
		return modelAndView;
	}
	
}
