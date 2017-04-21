package com.market.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;

public class CompanyLoginInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		String url = request.getRequestURI();
		if (url.indexOf("company/login") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		String companyName = (String) session.getAttribute(SessionKeyUtil.LoginCompanyName);
		LoggerUtil.getLogger(this).info("======== Session Name ======== ： {}", companyName);

		if (companyName != null) {
			return true;
		}

		request.getRequestDispatcher("/company/login_redirect?returnUrl=" + url).forward(request, response);

		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
