package com.jhtacybercampus.web.controller.student;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;

@WebServlet("/student/index")
public class IndexController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MynoteDao mynoteDao  = new OracleMynoteDao();
		NoticeDao nd = new OracleNoticeDao();
		try {
			req.setAttribute("mynote", mynoteDao.getList());
			req.setAttribute("notice", nd.getList());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("../WEB-INF/view/student/index.jsp").forward(req, resp);
	}
}
