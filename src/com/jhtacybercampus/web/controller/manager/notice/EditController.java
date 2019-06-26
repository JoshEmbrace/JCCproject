package com.jhtacybercampus.web.controller.manager.notice;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.NoticeFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeFileDao;
import com.jhtacybercampus.web.entity.Notice;
@MultipartConfig(
location = "C:\\Users\\Á¤ÁöÇý\\git\\JCCproject\\WebContent\\upload",
fileSizeThreshold = 1024 * 1024,
maxFileSize = 1024 * 1024 * 5, 
		maxRequestSize = 1024 * 1024 * 5 * 5 
)
@WebServlet("/manager/notice/edit")
public class EditController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Integer id = Integer.parseInt(req.getParameter("id"));

		NoticeDao nd = new OracleNoticeDao();
//		NoticeFileDao ndf = new OracleNoticeFileDao();
		try {
			nd.update(new Notice(id, title, content, "", "", "", 0, "ÀåÇý¸®"));
			req.setAttribute("notice", nd.get(id));
//			req.setAttribute("noticeFile", ndf.getListByNoticeId(id));
//			System.out.println(ndf.getListByNoticeId(id));
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
		req.getRequestDispatcher("../../WEB-INF/view/manager/notice/detail.jsp").forward(req, resp);
//		resp.sendRedirect("detail?id=" + id);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		NoticeDao nd = new OracleNoticeDao();
		NoticeFileDao ndf = new OracleNoticeFileDao();
		req.setAttribute("notice", nd.get(Integer.parseInt(req.getParameter("id"))));
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
		req.getRequestDispatcher("../../WEB-INF/view/manager/notice/edit.jsp").forward(req, resp);
	}
}
