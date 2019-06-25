package com.jhtacybercampus.web.controller.teacher.curri;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.CurriDao;
import com.jhtacybercampus.web.dao.oracle.OracleCurriDao;
import com.jhtacybercampus.web.entity.Curri;

@WebServlet("/teacher/curri/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		CurriDao curriDao = new OracleCurriDao();
		Curri curri = new Curri();
		curri.setTitle(title);
		curri.setContent(content);

		
		int result = 0;
		
		try {
			result = curriDao.insert(curri);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		if(result != 1)
//			response.sendRedirect("error");
//		else
			response.sendRedirect("list");
		
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/view/curri/reg.jsp").forward(request, response);
		
	}
	
}
