package com.jhtacybercampus.web.controller.member;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Member;

@WebServlet("/member/mypage")
public class MypageController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/member/mypage.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result=0;
		String user_id = req.getParameter("id");
		String user_pwd = req.getParameter("password");
		
		System.out.println(user_id);
		System.out.println(user_pwd);
		
		OracleMemberDao md = new OracleMemberDao();
		
		Member member = new Member();
		member.setUser_id(user_id);
		member.setUser_pwd(user_pwd);
		
		try {
			result = md.update(member);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		
		if(result != 1)
			resp.sendRedirect("error");
		else
			resp.sendRedirect("../notice/list");
	}
}
