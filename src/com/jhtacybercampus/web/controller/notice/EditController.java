package com.jhtacybercampus.web.controller.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;
import com.jhtacybercampus.web.entity.Notice;

@WebServlet("/notice/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));

		NoticeDao nd = new OracleNoticeDao();
		
		try {
			nd.update(new Notice(id, title, content, "", "", "", 0, "ÀåÇý¸®"));
			req.setAttribute("notice", nd.get(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Notice notice = new Notice();
//		notice.setId(id);
//		notice.setTitle(title);
//		notice.setContent(content);
//	
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
		//resp.sendRedirect("detail?id=" + id);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeDao nd = new OracleNoticeDao();
		req.setAttribute("notice", nd.get(Integer.parseInt(req.getParameter("id"))));
		req.getRequestDispatcher("/WEB-INF/view/notice/edit.jsp").forward(req, resp);
	}
}
