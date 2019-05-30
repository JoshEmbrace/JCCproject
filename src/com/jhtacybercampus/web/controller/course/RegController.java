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

@WebServlet("/course/reg")
public class RegController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		OracleMemberDao memberDao = new OracleMemberDao();
		
		try {
			req.setAttribute("teacher",memberDao.getTeacher());
			req.setAttribute("manager",memberDao.getManager());
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

		SimpleDateFormat date = new SimpleDateFormat("yy-mm-dd");
		String name = req.getParameter("name");
		int total = Integer.parseInt(req.getParameter("total"));
		String teacher = req.getParameter("teacher");
		String manager = req.getParameter("manager");
		
		String openDate=req.getParameter("openDate");
		String endDate=req.getParameter("endDate");
//		try {
//			openDate = ((java.sql.Date)date.parse(req.getParameter("openDate")));
//			endDate = ((java.sql.Date)date.parse(req.getParameter("endDate")));
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		Course course = new Course(
					0,name,teacher,manager,
					openDate,endDate,"a",total
				);
		
		
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