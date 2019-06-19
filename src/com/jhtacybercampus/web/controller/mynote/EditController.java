package com.jhtacybercampus.web.controller.mynote;

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

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.dao.MynoteFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteFileDao;
import com.jhtacybercampus.web.entity.Mynote;
import com.jhtacybercampus.web.entity.MynoteFile;

@WebServlet("/mynote/edit")
@MultipartConfig(
		location="C:\\temp",
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 5,
	    maxRequestSize = 1024 * 1024 * 5 * 5
	)
public class EditController extends HttpServlet {

	// 수정 후 수정된 내용 저장하기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String sid = request.getParameter("id");
		
		Integer id = Integer.parseInt(sid);
		String content = request.getParameter("content");
		
		Part filePart = request.getPart("file");
	      System.out.println(filePart);
	      
	      String urlPath = "/upload";
		  String path = request.getServletContext().getRealPath(urlPath);
		  System.out.println(path);
	      
		  String fileName = filePart.getSubmittedFileName();
		  
		  String filePath = path+File.separator+fileName; 
		  System.out.println(filePath);
	      
		  File pathFile = new File(path);
			if(!pathFile.exists())
				pathFile.mkdirs();
			
			InputStream fis = filePart.getInputStream();
			OutputStream fos = new FileOutputStream("C:\\temp\\"+fileName);
			
			byte[] buf = new byte[1024];
			int size=0;
			while((size=fis.read(buf))!=-1) {
				fos.write(buf, 0, size);
			}
			
			fis.close();
			fos.close();
		
		
		
		//System.out.println("id:" + sid + ",content:" + content);
	//선생님 풀이
		MynoteDao mynoteDao = new OracleMynoteDao();
		MynoteFileDao mynoteFileDao = new OracleMynoteFileDao();
		MynoteFile mynoteFile = new MynoteFile();
		
		
		mynoteFile.setMynoteId(id);
		mynoteFile.setName(fileName);
		
		
		
		Mynote mynote = new Mynote();
		mynote.setId(id);
		mynote.setContent(content);
		
		

		int result = 0;
		try {
			result = mynoteDao.update(mynote);
			mynoteFileDao.insert(mynoteFile);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("자" + result);

//request.getRequestDispatcher("../WEB-INF/view/mynote/list.jsp").forward(request, response);

		if (result != 1)
			response.sendRedirect("error");
		else
			response.sendRedirect("list");

	}

	// 수정 페이지로 넘어갈 때 기존에 작성됐던 글 가져오기
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// hello?cnt3 ->3?
		// hello? -> ""
		// hello -> null

		MynoteDao mynoteDao = new OracleMynoteDao();
		MynoteFileDao mynoteFileDao = new OracleMynoteFileDao();
		
		Integer id = Integer.parseInt(request.getParameter("id"));

		try {
			request.setAttribute("mynote", mynoteDao.get(id));
			request.setAttribute("files", mynoteFileDao.getListByMynoteId(id));
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getRequestDispatcher("../WEB-INF/view/mynote/edit.jsp").forward(request, response);

	}

}