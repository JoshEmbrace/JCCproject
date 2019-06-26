package com.jhtacybercampus.web.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jhtacybercampus.web.entity.Member;

@WebFilter(
		
		filterName = "LoginCheckFilter"
)
public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		System.out.println("login check");
	
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		String uri = httpRequest.getRequestURI();
		Member user = null;
		int grade = 0;

		HttpSession session = httpRequest.getSession();

		boolean isLogin = false; 

		if (session != null) {

			user = (Member) session.getAttribute("user");

			if (user != null)
				isLogin = true;
			
			
		}

		if (isLogin) {
			
			grade = user.getGrade();
			
			switch(grade) {
			case 1:
				if(uri.contains("/manager") || uri.contains("/teacher"))
					httpResponse.sendRedirect("/semi-JCC/student/index");
				break;
			case 2:
				if(uri.contains("/student") || uri.contains("/manager"))
					httpResponse.sendRedirect("/semi-JCC/teacher/index");
				break;
			case 3:
				if(uri.contains("/student") || uri.contains("/teacher"))
					httpResponse.sendRedirect("/semi-JCC/manager/index");
				break;
			default:
				httpResponse.sendRedirect("/semi-JCC/index");
					
			}
			
			chain.doFilter(request, response);

		} else {


			
//			Set<String> urls = new HashSet<>();
//			urls.add("/member");
			
			
			
			if(uri.contains("/member") && !uri.contains("mypage"))
				chain.doFilter(request, response);
			else
				httpResponse.sendRedirect("/semi-JCC/member/login");

		}
	}
	@Override

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
