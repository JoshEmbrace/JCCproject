package com.jhtacybercampus.web.controller.student.freeboard;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;

@WebServlet("/student/freeboard/del")
public class DelController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FreeBoardDao fbDao  = new OracleFreeBoardDao();

		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			fbDao.delete(id);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


		response.sendRedirect("list");


	}
}
