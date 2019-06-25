package com.jhtacybercampus.web.controller.teacher.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.NoticeFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeFileDao;
@WebServlet("/teacher/notice/detail")
public class DetailController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeDao nd = new OracleNoticeDao();
		NoticeFileDao ndf = new OracleNoticeFileDao();
	
		req.setAttribute("notice", nd.get(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("prev", nd.getPrev(Integer.parseInt(req.getParameter("id"))));
		req.setAttribute("next", nd.getNext(Integer.parseInt(req.getParameter("id"))));
		try {
			req.setAttribute("noticeFile", ndf.getListByNoticeId(Integer.parseInt(req.getParameter("id"))));
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
		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
	}

}
