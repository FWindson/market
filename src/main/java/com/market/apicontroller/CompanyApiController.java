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
import com.market.domain.Company;
import com.market.service.ICompanyService;
import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;
import com.market.vo.ResponseModel;

@Controller
@RequestMapping("/api/company")
public class CompanyApiController {

	@Autowired
	@Qualifier("companyService")
	private ICompanyService companyService;
	
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
	
}
