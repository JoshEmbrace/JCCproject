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


@WebServlet("/freeboard/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		FreeBoardDao fbDao  = new OracleFreeBoardDao();


		//		String id = req.getParameter("id");
		//		int a = Integer.parseInt(id);
		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			request.setAttribute("notice", fbDao.get(id));
			request.setAttribute("prev", fbDao.getPrev(id));
			request.setAttribute("next", fbDao.getNext(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		request.getRequestDispatcher("/WEB-INF/view/freeboard/detail.jsp").forward(request, response);
	}

}
