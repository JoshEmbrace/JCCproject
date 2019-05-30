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
import com.jhtacybercampus.web.entity.Course;

@WebServlet("/course/del")
public class DelController extends HttpServlet{

	 @Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		 OracleCourseDao noticeDao = new OracleCourseDao();
			int id = Integer.parseInt(req.getParameter("id"));
			
			try {
				noticeDao.delete(id);
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