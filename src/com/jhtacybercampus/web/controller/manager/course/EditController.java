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
import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Course;
import com.jhtacybercampus.web.entity.CourseView;

@WebServlet("/manager/course/edit")
public class EditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		OracleCourseDao courseDao = new OracleCourseDao();
		OracleMemberDao memberDao = new OracleMemberDao();
		OracleGrantCourseDao grantCourseDao = new OracleGrantCourseDao();
		
		try {
			req.setAttribute("course",courseDao.get(id));
			req.setAttribute("teachers", memberDao.getTeacher());
			req.setAttribute("managers", memberDao.getManager());
			req.setAttribute("students", grantCourseDao.getList(id));
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
		int teacher_id = Integer.parseInt(req.getParameter("teacher"));
		int manager_id = Integer.parseInt(req.getParameter("manager"));
		String openDate = req.getParameter("openDate");
		String endDate = req.getParameter("endDate");
		
		Course course = new Course();
		course.setId(id);
		course.setName(name);
		course.setTeacher_id(teacher_id);
		course.setManager_id(manager_id);
		course.setOpen_date(openDate);
		course.setEnd_date(endDate);
		
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
