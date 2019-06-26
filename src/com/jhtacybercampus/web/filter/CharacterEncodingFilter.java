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
		   filterName="CharacterEncodingFilter")
public class CharacterEncodingFilter implements Filter{

	private String encoding = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {//필터 초기화 작업
		//init메소드에 전달되는 FilterConfig는 필터의 초기화 파라미터를 읽어올 때 사용
		String encoding = filterConfig.getInitParameter("encoding");//getInitParameter(String name)-> 설정 파일의 <init-param>에서 지정한 초기화 파라미터의 값을 읽어온다.
		// 존재하지 않는 경우 null 리턴

		if(encoding != null && !encoding.equals(""))
			this.encoding = encoding;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {//필터 기능을 수행
		System.out.println("캐릭터필터");
		request.setCharacterEncoding(encoding);
		//System.out.println("필터 사전 실행");


		//체인을 이용해서 체인의 다음 필터로 처리를 전달할 수 있다.(체인의 다음 필터 처리)
		chain.doFilter(request, response);

		//System.out.println("필터 사후 실행");
	}

}

