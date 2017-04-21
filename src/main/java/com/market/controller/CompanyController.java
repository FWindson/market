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
import com.market.domain.SalesApply;
import com.market.service.ICompanyService;
import com.market.service.impl.SalesApplyService;
import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;
	
	@Autowired
	private SalesApplyService salesApplyService;

	@RequestMapping(value = "/clean", produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	public void clean(HttpSession session) {
		session.invalidate();
	}

	/**
	 * 获取登录ID
	 * @param session
	 * @return
	 */
	private String getLoginUserID(HttpSession session){
		Object administratorId = session.getAttribute(SessionKeyUtil.LoginCompanyID);
		if (administratorId != null) 
			return administratorId.toString();
		else //TODO:改为""
			return "Windson";
	}
	/**
	 * 获取登录名
	 * @param session
	 * @return
	 */
	private String getLoginUserName(HttpSession session){
		Object administratorName = session.getAttribute(SessionKeyUtil.LoginCompanyName);
		if (administratorName != null) 
			return administratorName.toString();
		else //TODO:改为""
			return "Windson有限公司";
	}
	
	@RequestMapping(value = "/getCompany", produces = "text/json;charset=UTF8", method = RequestMethod.GET)
	@ResponseBody
	public String getCompany(@RequestParam("name") String name, @RequestParam("password") String password) {
		Company company = companyService.getCompany(name, password);
		return JSON.toJSONString(company);
	}

	@RequestMapping(value = "/index")
	public String dashboard(Model model, HttpSession session) {
		model.addAttribute("companyId", session.getAttribute(SessionKeyUtil.LoginCompanyID));
		model.addAttribute("companyName", session.getAttribute(SessionKeyUtil.LoginCompanyName));
		LoggerUtil.getLogger(this).debug(session.getAttribute(SessionKeyUtil.LoginCompanyName).toString());
		System.out.println(LoggerUtil.getLogger(this).getClass().toString());
		return "company/index";
	}

	@RequestMapping(value = "/login_redirect")
	public String login_redirect(String returnUrl) {
		return "redirect:/company/login?returnUrl=" + returnUrl;
	}

	@RequestMapping(value = "/login")
	public String login(String returnUrl, Model model) {
		model.addAttribute("returnUrl", returnUrl);
		return "company/login";
	}

	/**
	 * 销售员申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "/salesApplys")
	public String salesApplys(HttpSession session) {
		return "company/salesApplys";
	}
	
	/**
	 * 佣金收入列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/commisions")
	public String commisions() {
		return "company/commisions";
	}

	/**
	 * 佣金收入详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/commisionDetails")
	public String commisionDetails() {
		return "company/commisionDetails";
	}

	/**
	 * 公司员工列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sales")
	public String sales() {
		return "company/sales";
	}
	
	/**
	 * 公司员工详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/sales_detail")
	public String salesDetail(String salesId,
			Model model) {
		model.addAttribute("salesId",salesId);
		return "company/sales_detail";
	}

	/**
	 * 公司员工收入列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/salesIncomes")
	public String salesIncomes() {
		return "company/salesIncomes";
	}

	/**
	 * 公司员工收入详情
	 * 
	 * @return
	 */
	@RequestMapping(value = "/salesIncomeDetail")
	public String salesIncomeDetail() {
		return "company/salesIncomeDetail";
	}

	/**
	 * 公司客户列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customers")
	public String customers() {
		return "company/customers";
	}

	/**
	 * 公司客户订单列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/customerOrders")
	public String customerOrders() {
		return "company/customerOrders";
	}

	/**
	 * 佣金提现列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "/commisionApplys")
	public String commisionApplys() {
		return "company/commisionApplys";
	}

	/**
	 * 佣金提现申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "/commisionApply")
	public String commisionApply() {
		return "company/commisionApply";
	}

}
