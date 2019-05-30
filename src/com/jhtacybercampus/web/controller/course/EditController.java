package com.jhtacybercampus.web.controller.course;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleCourseDao;
import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Course;

@WebServlet("/course/edit")
public class EditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		OracleCourseDao courseDao = new OracleCourseDao();
		OracleMemberDao memberDao = new OracleMemberDao();
		
		try {
			req.setAttribute("course",courseDao.get(id));
			req.setAttribute("teacher", memberDao.getTeacher());
			req.setAttribute("manager", memberDao.getManager());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		req.getRequestDispatcher("../WEB-INF/view/course/edit.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OracleCourseDao courseDao = new OracleCourseDao();
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String teacher = req.getParameter("teacher");
		String manager = req.getParameter("manager");
		String openDate = req.getParameter("openDate");
		String endDate = req.getParameter("endDate");
		
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setTeacher(teacher);
		course.setManager(manager);
		course.setOpenDate(openDate);
		course.setEndDate(endDate);
		
		try {
			courseDao.update(course);
			req.setAttribute("course",courseDao.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		req.getRequestDispatcher("../WEB-INF/view/course/detail.jsp").forward(req, resp);
	}
}
