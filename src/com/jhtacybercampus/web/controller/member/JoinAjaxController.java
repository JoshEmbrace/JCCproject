package com.jhtacybercampus.web.controller.member;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;

@WebServlet("/member/join-check")
public class JoinAjaxController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userid = req.getParameter("id");
		OracleMemberDao md = new OracleMemberDao();
		int result=0;
		try {
			result = md.exist(userid);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PrintWriter out = resp.getWriter();
		String json = "{\"exist\":"+result+"}";
		out.write(json);
	}
}
