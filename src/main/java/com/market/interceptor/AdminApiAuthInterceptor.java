package com.market.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.market.utils.LoggerUtil;
import com.market.utils.SessionKeyUtil;
import com.market.vo.ResponseModel;

/**
 * 后台管理接口权限验证
 * @author asus
 *
 */
public class AdminApiAuthInterceptor implements HandlerInterceptor  {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean flag = true;
		if (handler instanceof HandlerMethod) { 
			AdminApiAuth auth = ((HandlerMethod) handler).getMethod().getAnnotation(AdminApiAuth.class);  
			if(auth != null) {
				HttpSession session = request.getSession();
				Object loginAdministratorId = session.getAttribute(SessionKeyUtil.LoginAdministratorID);
				if (loginAdministratorId == null) {
					response.setStatus(HttpStatus.FORBIDDEN.value());  
		            response.setContentType("text/html; charset=UTF-8");  
		            PrintWriter out=response.getWriter();  
		            ResponseModel model = ResponseModel.buildFailed("请先登录");
		            out.write(JSON.toJSONString(model));
		            out.flush();  
		            out.close();  
		            flag = false;  
				}
			}
		}
		return flag;
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
