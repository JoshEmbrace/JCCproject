package com.jhtacybercampus.web.controller.curri;

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

@WebServlet("/curri/list")
public class ListController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OracleCurriDao curriDao = new OracleCurriDao();
		
		try {
			request.setAttribute("list", curriDao.getList());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/view/curri/list.jsp").forward(request, response);
		
	}
	
}
