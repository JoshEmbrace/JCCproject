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
import com.jhtacybercampus.web.entity.FreeBoard;


@WebServlet("/freeboard/reg")
public class RegController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDao fbDao = new OracleFreeBoardDao();
		FreeBoard fb = new FreeBoard();

		String title = request.getParameter("title");
		String content = request.getParameter("content");
//		String file_path = request.getParameter("file_path");
//		String file_name = request.getParameter("file_name");
		String writer_id = request.getParameter("writer_id");


		fb.setTitle(title);
		fb.setContent(content);
		fb.setWriter_id(writer_id);

		int result=0;


		try {
			result= fbDao.insert(fb);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(title);

		if(result !=1)
			response.sendRedirect("error");
		else
			response.sendRedirect("/freeboard/list");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/view/freeboard/reg.jsp").forward(request, response);
	}

}
