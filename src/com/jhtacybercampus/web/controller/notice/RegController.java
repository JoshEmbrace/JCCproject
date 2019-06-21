package com.jhtacybercampus.web.controller.notice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jhtacybercampus.web.dao.NoticeDao;
import com.jhtacybercampus.web.dao.oracle.OracleNoticeDao;
import com.jhtacybercampus.web.entity.Notice;

@WebServlet("/notice/reg")
@MultipartConfig(
		location="C:\\temp",
	    fileSizeThreshold = 1024*1024,
	    maxFileSize = 1024*1024*5, //5메가
	    maxRequestSize = 1024*1024*5*5 // 5메가 5개까지
	)
public class RegController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		Part filePart = req.getPart("file");
		System.out.println(filePart);
		
		//업로드 경로를 얻기
		String urlPath = "/upload";
		String path = req.getServletContext().getRealPath(urlPath);
		System.out.println(path);
		
		//업로드된 파일명 얻기
		String fileName = filePart.getSubmittedFileName();
		//경로 구분자
		String filePath = path+File.separator+fileName; 
		System.out.println(filePath);
		
		//경로가 없다는 오류문제
		 File pathFile = new File(path);
			if(!pathFile.exists())//존재하지 않으면
				pathFile.mkdirs();//생성해주세요
		
		InputStream fis = filePart.getInputStream();
		OutputStream fos = new FileOutputStream("C:\\temp\\"+fileName);
		
		byte[] buf = new byte[1024];
		int size = 0;
		
		while((size=fis.read(buf)) != -1)
			fos.write(buf, 0, size);
		
		fis.close();
		fos.close();
		
		NoticeDao nd = new OracleNoticeDao();
		
	
			
				try {

					nd.insert(new Notice(0, title, content, "", "", "", 0, "장혜리"));
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
//		req.getRequestDispatcher("/WEB-INF/view/notice/detail.jsp").forward(req, resp);
//				resp.sendRedirect("detail?id=" + id);

				resp.sendRedirect("list");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/notice/reg.jsp").forward(req, resp);
	}
}
