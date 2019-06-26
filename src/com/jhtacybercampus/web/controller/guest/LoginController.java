package com.jhtacybercampus.web.controller.guest;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.jhtacybercampus.web.dao.MemberDao;
import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Member;




@WebServlet("/login")
public class LoginController extends HttpServlet{
  
  @Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	  	String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		
		Member member= null;
	
		MemberDao memberDao = new OracleMemberDao();
		try {
		member = memberDao.get(user_id);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//2. 회원이 존재하지 않는다면
		//로그인페이지로 다시 복귀..대신 오류 알림
		if(member == null) 
			resp.sendRedirect("login?error=1");
		
		//3. 회원이 존재하면서 비번이 일치하지 않는다면
		//로그인페이지로 다시 복귀..대신 오류 알림
		
		else if(!member.getUser_pwd().equals(user_pwd))
			resp.sendRedirect("login?error=1");
		else {
			HttpSession session = req.getSession();
			session.setAttribute("user", member);
			//session.setAttribute("user", member);
			
			String returnURL = req.getParameter("return-url");
			
			if(returnURL != null) 
				resp.sendRedirect(returnURL);
			else
				resp.sendRedirect("index");
		
		
		}
	}
   
}