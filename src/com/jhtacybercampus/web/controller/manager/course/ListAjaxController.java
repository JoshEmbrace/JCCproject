package com.jhtacybercampus.web.controller.manager.course;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleCourseDao;
import com.jhtacybercampus.web.entity.CourseView;


@WebServlet("/manager/course/list-ajax")
public class ListAjaxController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		OracleCourseDao courseDao = new OracleCourseDao();
		List<CourseView> list = null;
		
		int page = 1;
		if (req.getParameter("p") != null && !req.getParameter("p").equals(""))
			page = Integer.parseInt(req.getParameter("p"));
		
		try {
			list = courseDao.getList(page);
			//req.setAttribute("test", "test");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/txt;charset=utf-8"); // MIME type json ������ Ÿ��
		PrintWriter out = resp.getWriter();
		
		
		StringBuilder json = new StringBuilder();
		json.append("[");
		

		for(int i=0;i<list.size();i++) {
			CourseView cv = list.get(i);
			
			json.append("{");
			json.append(String.format("\"id\":%d,", cv.getId()));
			json.append(String.format("\"name\":\"%s\",", cv.getName()));
			json.append(String.format("\"teacher\":\"%s\",", cv.getTeacher()));
			json.append(String.format("\"manager\":\"%s\",", cv.getManager()));
			json.append(String.format("\"openDate\":\"%s\",", cv.getOpenDate()));
			json.append(String.format("\"endDate\":\"%s\",", cv.getEndDate()));
			json.append(String.format("\"total\":%d,", cv.getTotal()));
			json.append(String.format("\"writerId\":\"%s\"", cv.getWriterId()));
			json.append("}");
			
			if(i<list.size()-1)
				json.append(",");	
		}
	
		
		json.append("]");
		
		out.write(json.toString());
	}
}
