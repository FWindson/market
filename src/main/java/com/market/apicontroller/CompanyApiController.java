package com.market.apicontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.market.domain.Company;
import com.market.domain.SalesApply;
import com.market.service.ICompanyService;
import com.market.service.impl.CommisionService;
import com.market.service.impl.CustomerService;
import com.market.service.impl.SalesApplyService;
import com.market.service.impl.SalesService;
import com.market.utils.BasicDataUtil;
import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;
import com.market.vo.PageDataModel;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/api/company")
public class CompanyApiController {

	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;
	@Autowired
	private SalesApplyService salesApplyService;
	@Autowired
	private SalesService salesService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CommisionService commisionService;
	
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
			return "1f6d3c36-8722-413b-8462-848e43c3a457";
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
	
	@RequestMapping(value = "login",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String login(@RequestParam("name") String name,
			@RequestParam("password") String password,
			HttpSession session) {
		ResponseModel responseModel;
		Company company = companyService.getCompany(name,password);
		if (company != null) {
			session.setAttribute(SessionKeyUtil.LoginCompanyID, company.getId());
			session.setAttribute(SessionKeyUtil.LoginCompanyName, company.getName());
			responseModel = ResponseModel.buildSuccess(company);
		}
		else {
			responseModel = ResponseModel.buildFailed("公司名或密码不正确");
		}
		String json = JSON.toJSONString(responseModel);
		LoggerUtil.getLogger(this).info("======== responseModel ========= : " + json);
		return json;
	}
	
	/**
	 * 销售员申请
	 * 
	 * @return
	 */
	@RequestMapping(value = "getSalesApplys",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String getSalesApplys(int pageIndex,
			int pageSize,
			String keyword,
			HttpSession session) {
		PageDataModel pageDataModel = salesApplyService.getSalesApplysByCompany(getLoginUserID(session),pageIndex,pageSize,keyword);
		String json = JSON.toJSONString(pageDataModel);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 销售员列表
	 * 
	 * @return
	 */
	@RequestMapping(value = "getSales",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String getSales(int pageIndex,
			int pageSize,
			String keyword,
			HttpSession session) {
		PageDataModel pageDataModel = salesService.getSales(getLoginUserID(session), pageIndex, pageSize, keyword);
		String json = JSON.toJSONString(pageDataModel);
		System.out.println(json);
		return json;
	}
	
	/**
	 * 销售员详情
	 * @param salesId
	 * @return
	 */
	@RequestMapping(value = "getSalesDetail",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String getSalesDetail(String salesId) {
		ResponseModel responseModel = salesService.getSalesDetail(salesId);
		String json = JSON.toJSONString(responseModel);
		return json;
	}

	/**
	 * 获取销售员客户
	 * @param salesId
	 * @param pageIndex
	 * @param pageSize
	 * @param keyword
	 * @return
	 */
	@RequestMapping(value = "getSalesCustomers",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String getSalesCustomers(String salesId,int pageIndex,int pageSize,String keyword){
		PageDataModel dataModel = customerService.getCustomersBySales(salesId, pageIndex, pageSize, keyword); 
		String json = JSON.toJSONString(dataModel);
		return json;
	}
	
	@RequestMapping(value = "getCommisionRecords",produces = "text/json;charset=UTF8",method = RequestMethod.POST)
	@ResponseBody()
	public String getCommisionRecords(int applicantType,
			String applicantId,
			int pageIndex,
			int pageSize,
			String orderby,
			HttpSession session) {
		if (applicantId == null || applicantId.equals("")) {
			applicantId = getLoginUserID(session);
		}
		PageDataModel pageDataModel = commisionService.getCommisionRecordModels(applicantType, applicantId, pageIndex, pageSize,orderby);
		String json = JSON.toJSONString(pageDataModel);
		return json;
	}
	
}
