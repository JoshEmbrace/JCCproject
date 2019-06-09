package com.jhtacybercampus.web.controller.course;

import java.io.IOException;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleCourseDao;
import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Course;
import com.jhtacybercampus.web.entity.CourseView;

@WebServlet("/course/reg")
public class RegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		OracleMemberDao memberDao = new OracleMemberDao();
		
		try {
			req.setAttribute("teachers",memberDao.getTeacher());
			req.setAttribute("managers",memberDao.getManager());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("../WEB-INF/view/course/reg.jsp").forward(req, resp);
		//resp.sendRedirect("../WEB-INF/view/course/reg.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		OracleCourseDao courseDao = new OracleCourseDao();

		String name = req.getParameter("name");
		int total = Integer.parseInt(req.getParameter("total"));
		int teacher_id = Integer.parseInt(req.getParameter("teacher"));
		int manager_id = Integer.parseInt(req.getParameter("manager"));
		
		String open_date=req.getParameter("openDate");
		String end_date=req.getParameter("endDate");

		Course course = new Course();
		course.setName(name);
		course.setTeacher_id(teacher_id);
		course.setManager_id(manager_id);
		course.setTotal(total);
		course.setOpen_date(open_date);
		course.setEnd_date(end_date);
			
		
		try {
			courseDao.insert(course);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.sendRedirect("list");
	}
}