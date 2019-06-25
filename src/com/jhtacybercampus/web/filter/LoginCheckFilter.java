package com.jhtacybercampus.web.filter;

import java.io.IOException;

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

		System.out.println("������ �α�������");

	
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

		}

		if (isLogin) {
			// �α��� �� ��쿡�� ��û�� �۾��� ����Ѵ�.
			chain.doFilter(request, response);

		} else {

			// �α��� ���� ���� ���

			// ServletResponse ��ü�� �ڽ� ��ü�� ����ȯ �Ѵ���

			HttpServletResponse httpResponse = (HttpServletResponse) response;

			// �ȳ������� Ȥ�� login �������� ���� �̵���Ų��.

			// httpRequest.getRequestDispatcher("../WEB-INF/view/member/login.jsp").forward(request,
			// response);
			
			//httpResponse.sendRedirect("../member/login");
			if(uri.equals("/semi-JCC/member/login"))
				chain.doFilter(request, response);
			else
				httpResponse.sendRedirect("../member/login");

		}
	}
	@Override

	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
