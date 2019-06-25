package com.jhtacybercampus.web.controller.manager.course;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleCourseDao;

@WebServlet("/manager/course/list")
public class ListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp)
			throws ServletException, IOException {
		OracleCourseDao courseDao = new OracleCourseDao();

		int page = 1;
		if (req.getParameter("p") != null && !req.getParameter("p").equals(""))
			page = Integer.parseInt(req.getParameter("p"));

		try {
			req.setAttribute("list", courseDao.getList(page));
			// req.setAttribute("test", "test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		req.getRequestDispatcher("../WEB-INF/view/course/list.jsp").forward(req, resp);
	}

}
