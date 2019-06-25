package com.jhtacybercampus.web.controller.manager.course;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleCourseDao;
import com.jhtacybercampus.web.dao.oracle.OracleGrantCourseDao;

@WebServlet("/manager/course/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		OracleCourseDao courseDao = new OracleCourseDao();
		OracleGrantCourseDao grantCourseDao = new OracleGrantCourseDao();
		
		try {
			req.setAttribute("course",courseDao.get(id));
			req.setAttribute("students", grantCourseDao.getList(id));
			req.setAttribute("count", grantCourseDao.getCount(id));
			//req.setAttribute("test", "test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("../../WEB-INF/view/manager/course/detail.jsp").forward(req, resp);
	}
}
