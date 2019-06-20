package com.jhtacybercampus.web.controller.freeboard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;


@WebServlet("/freeboard/list")
public class ListController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDao fbDao  = new OracleFreeBoardDao();
		int page = 1;                                                                     
		if (request.getParameter("p") != null && !request.getParameter("p").equals(""))
			page = Integer.parseInt(request.getParameter("p"));
		
		
		try {
			request.setAttribute("list", fbDao.getList(page));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		request.getRequestDispatcher("/WEB-INF/view/freeboard/list.jsp").forward(request, response);
	}



}
