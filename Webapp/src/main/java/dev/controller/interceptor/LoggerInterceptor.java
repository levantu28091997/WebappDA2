package dev.controller.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import dev.DAO.AdminUserDAO;
public class LoggerInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	AdminUserDAO adminuserDAO;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object email = request.getSession().getAttribute("LOGIN_EMAIL");
		Object password = request.getSession().getAttribute("LOGIN_PASS");
		if (email != null && password != null) {
			if (adminuserDAO.checkAuth(email.toString(), password.toString())) {
				return true;
			}
		}

		// redirect to login page
		response.sendRedirect(request.getContextPath() + "/auth");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}
}
