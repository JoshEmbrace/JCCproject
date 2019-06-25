package com.jhtacybercampus.web.controller.teacher.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;
@WebServlet("/teacher/notice/list")
public class ListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 1;
		String p_ = req.getParameter("p");
		if(p_!=null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		NoticeDao nd = new OracleNoticeDao();
		try {
			req.setAttribute("list", nd.getList(page));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("/WEB-INF/view/notice/list.jsp").forward(req, resp);
	}

}








