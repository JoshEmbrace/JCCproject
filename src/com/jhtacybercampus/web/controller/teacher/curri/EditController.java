package com.jhtacybercampus.web.controller.teacher.curri;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.CurriDao;
import com.jhtacybercampus.web.dao.oracle.OracleCurriDao;
import com.jhtacybercampus.web.entity.Curri;

@WebServlet("/teacher/curri/edit")
public class EditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CurriDao curriDao = new OracleCurriDao();
		Integer id = Integer.parseInt(request.getParameter("id"));
		
		try {
			request.setAttribute("curri", curriDao.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../../WEB-INF/view/teacher/curri/edit.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		CurriDao curriDao = new OracleCurriDao();
		
		try {
			curriDao.update(new Curri(id, title, content, "占쌘울옙占�", null, null, null));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("../../WEB-INF/view/teacher/curri/list.jsp").forward(request, response);
		
	}
	
}
