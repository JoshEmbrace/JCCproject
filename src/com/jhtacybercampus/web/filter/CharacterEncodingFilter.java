package com.jhtacybercampus.web.filter;
import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jhtacybercampus.web.entity.Member;


// /*


@WebFilter(
	urlPatterns="/*",	
	filterName="CharacterEncodingFilter"
		)
public class CharacterEncodingFilter implements Filter{

	private String encoding = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {//���� �ʱ�ȭ �۾�
		//init�޼ҵ忡 ���޵Ǵ� FilterConfig�� ������ �ʱ�ȭ �Ķ���͸� �о�� �� ���
		String encoding = filterConfig.getInitParameter("encoding");//getInitParameter(String name)-> ���� ������ <init-param>���� ������ �ʱ�ȭ �Ķ������ ���� �о�´�.
		// �������� �ʴ� ��� null ����

		if(encoding != null && !encoding.equals(""))
			this.encoding = encoding;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {//���� ����� ����
		System.out.println("ĳ��������");
		request.setCharacterEncoding(encoding);
		//System.out.println("���� ���� ����");


		//ü���� �̿��ؼ� ü���� ���� ���ͷ� ó���� ������ �� �ִ�.(ü���� ���� ���� ó��)
		chain.doFilter(request, response);

		//System.out.println("���� ���� ����");
	}

}

