package com.jhtacybercampus.web.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;
@WebServlet("/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeDao nd = new OracleNoticeDao();
	
		req.setAttribute("notice", nd.get(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("prev", nd.getPrev(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("next", nd.getNext(Integer.parseInt(req.getParameter("id"))));
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
	}

}
