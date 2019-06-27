package com.jhtacybercampus.web.controller.teacher.freeboard;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.FreeboardFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeboardFileDao;
import com.jhtacybercampus.web.entity.FreeBoard;
import com.jhtacybercampus.web.entity.FreeboardFile;


@WebServlet("/teacher/freeboard/reg")

@MultipartConfig(location = "C:\\Users\\YIJIN\\git\\JCCproject\\WebContent\\upload", 
fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5?占쏙옙?占쏙옙怨ㅼ삕
maxRequestSize = 1024 * 1024 * 5 * 5 // 5?占쏙옙?占쏙옙怨ㅼ삕 5?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙
		)

public class RegController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FreeBoardDao fbDao = new OracleFreeBoardDao();
		FreeBoard fb = new FreeBoard();
		FreeboardFileDao freeboardFileDao = new OracleFreeboardFileDao();

		String title = request.getParameter("title");
		String content = request.getParameter("content");

		Integer writer_id = Integer.parseInt(request.getParameter("writer_id"));
		
		fb.setTitle(title);
		fb.setContent(content);
		fb.setWriter_id(writer_id);

		//D:\html5-1902
		Part filePart = request.getPart("file");

		//1.?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙營먨뜝占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙占�?
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);

		//2. ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙紐뚯삕 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙
		String fileName = filePart.getSubmittedFileName();

		//3. ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙占�?
		String filePath = path+File.separator+fileName; //File.separator-> "\\"

		//4. ?占쏙옙?占쏙옙?占쏙옙野у뜝占�? ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙
		File pathFile = new File(path);
		if(!pathFile.exists())//?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙 ?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙
			pathFile.mkdirs();//?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙?占쏙옙

		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream("C:\\Users\\YIJIN\\git\\JCCproject\\WebContent\\upload"+fileName);

		byte[] buf = new byte[1024];
		int size=0;
		while((size=fis.read(buf))!=-1) {
			fos.write(buf, 0, size);
		}

		fis.close();
		fos.close();

		int result=0;


		try {
			result= fbDao.insert(fb);

			int freeboardId = fbDao.getLastId();

			FreeboardFile freeboardFile = new FreeboardFile();
			freeboardFile.setName(fileName);
			freeboardFile.setFreeboardId(freeboardId);
			freeboardFileDao.insert(freeboardFile);

			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		System.out.println(title);

		if(result !=1)
			response.sendRedirect("error");
		else
			response.sendRedirect("list");

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("../../WEB-INF/view/teacher/freeboard/reg.jsp").forward(request, response);
	}

}
