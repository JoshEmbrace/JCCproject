package com.jhtacybercampus.web.controller.curri;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.CurriDao;
import com.jhtacybercampus.web.dao.oracle.OracleCurriDao;

@WebServlet("/curri/del")
public class DelController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CurriDao curriDao = new OracleCurriDao();
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			curriDao.delete(id);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("list");
		
	}
	
}
