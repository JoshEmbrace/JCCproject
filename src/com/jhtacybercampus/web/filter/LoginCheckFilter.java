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

@WebFilter(filterName = "LoginCheckFilter")
public class LoginCheckFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy");
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		// 자식객체로 형변환 한다음

		System.out.println("로그인필터");

	
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();

		// 세션 객체를 얻어온다.

		HttpSession session = httpRequest.getSession();

		// 로그인 했는지 아닌지에 대한 여부
		boolean isLogin = false; // 로그인x

		if (session != null) {

			// 세션에서 id 라는 키값을 읽어와 본다.
			Member user = (Member) session.getAttribute("user");

			// 만일 id 값이 null 이 아니라면 로그인한 상태이다.
			if (user != null)
				isLogin = true;
			
//			switch(user.getGrade()) {
//			case 1:{
//				if(uri.contains("/teacher")||uri.contains("/manager"))
//					System.out.println("잘못된 접근");
//				break;
//			}
//			case 2:
//				if(uri.contains("/student")||uri.contains("/manager"))
//					System.out.println("잘못된 접근");
//				break;
//			case 3:
//				if(uri.contains("/student")||uri.contains("/teacher"))
//					System.out.println("잘못된 접근");
//				break;
//			default:
//				break;
//			}

		}

		if (isLogin) {
			// 로그인 된 경우에는 요청된 작업을 계속한다.
			chain.doFilter(request, response);

		} else {

			// 로그인 하지 않은 경우

			// ServletResponse 객체를 자식 객체로 형변환 한다음

			HttpServletResponse httpResponse = (HttpServletResponse) response;

			// 안내페이지 혹은 login 페이지로 강제 이동시킨다.
			
//			Set<String> urls = new HashSet<>();
//			urls.add("/member");
			
			
			
			if(uri.contains("/member"))
				chain.doFilter(request, response);
			else
				httpResponse.sendRedirect("/semi-JCC/member/login");

		}
	}
	@Override

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
