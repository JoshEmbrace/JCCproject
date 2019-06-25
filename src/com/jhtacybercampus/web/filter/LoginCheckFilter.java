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

		// �ڽİ�ü�� ����ȯ �Ѵ���

		System.out.println("�α�������");

	
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		String uri = httpRequest.getRequestURI();

		// ���� ��ü�� ���´�.

		HttpSession session = httpRequest.getSession();

		// �α��� �ߴ��� �ƴ����� ���� ����
		boolean isLogin = false; // �α���x

		if (session != null) {

			// ���ǿ��� id ��� Ű���� �о�� ����.
			Member user = (Member) session.getAttribute("user");

			// ���� id ���� null �� �ƴ϶�� �α����� �����̴�.
			if (user != null)
				isLogin = true;
			
//			switch(user.getGrade()) {
//			case 1:{
//				if(uri.contains("/teacher")||uri.contains("/manager"))
//					System.out.println("�߸��� ����");
//				break;
//			}
//			case 2:
//				if(uri.contains("/student")||uri.contains("/manager"))
//					System.out.println("�߸��� ����");
//				break;
//			case 3:
//				if(uri.contains("/student")||uri.contains("/teacher"))
//					System.out.println("�߸��� ����");
//				break;
//			default:
//				break;
//			}

		}

		if (isLogin) {
			// �α��� �� ��쿡�� ��û�� �۾��� ����Ѵ�.
			chain.doFilter(request, response);

		} else {

			// �α��� ���� ���� ���

			// ServletResponse ��ü�� �ڽ� ��ü�� ����ȯ �Ѵ���

			HttpServletResponse httpResponse = (HttpServletResponse) response;

			// �ȳ������� Ȥ�� login �������� ���� �̵���Ų��.
			
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
