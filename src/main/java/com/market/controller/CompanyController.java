package com.market.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.market.domain.Company;
import com.market.service.ICompanyService;
import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;
	
	@RequestMapping(value = "/clean",produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	public void clean(HttpSession session) {
		session.invalidate();
	}
	
	@RequestMapping(value = "/getCompany",produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	@ResponseBody
	public String getCompany(
			@RequestParam("name") String name,
			@RequestParam("password") String password) {
		Company company = companyService.getCompany(name, password);
		return JSON.toJSONString(company);
	}
	
	@RequestMapping(value = "/dashboard")
	public String dashboard(Model model,
			HttpSession session) {
		model.addAttribute("companyId", session.getAttribute(SessionKeyUtil.LoginCompanyID));
		model.addAttribute("companyName", session.getAttribute(SessionKeyUtil.LoginCompanyName));
		return "company/dashboard";
	}
	
	@RequestMapping(value = "/login_redirect")
	public String login_redirect(String returnUrl) {
		System.out.println("进入 login_redirect()");
		return "redirect:/company/login?returnUrl=" + returnUrl;
	}
	
	@RequestMapping(value = "/login")
	public String login(String returnUrl,
			Model model) {
		model.addAttribute("returnUrl",returnUrl);
		return "company/login";
	}
	
	
	
}
