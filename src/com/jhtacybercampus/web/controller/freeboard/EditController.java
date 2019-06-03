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

@WebServlet("/freeboard/edit")
public class EditController extends HttpServlet {
 
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");// 입력 한글깨짐 방지, 필터에다가 사전에 실행.
				Integer id = Integer.parseInt(request.getParameter("id"));
				String title = request.getParameter("title");
				String content = request.getParameter("content");
				
				FreeBoardDao fbDao = new OracleFreeBoardDao();
			
				try {
					fbDao.update(new FreeBoard(id, title, content));
					request.setAttribute("notice",fbDao.get(id));
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				request.getRequestDispatcher("/WEB-INF/view/freeboard/detail.jsp").forward(request, response);
			}
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDao fbDao = new OracleFreeBoardDao();
		try {
			request.setAttribute("notice",fbDao.get(Integer.parseInt(request.getParameter("id"))));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/view/freeboard/edit.jsp").forward(request, response);
	}
}
