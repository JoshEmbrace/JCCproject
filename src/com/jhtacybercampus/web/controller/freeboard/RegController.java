package com.jhtacybercampus.web.controller.freeboard;

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


@WebServlet("/freeboard/reg")

@MultipartConfig(location = "C:\\workspace\\JCCproject\\WebContent\\upload", fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, // 5메가
maxRequestSize = 1024 * 1024 * 5 * 5 // 5메가 5개까지
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

		//1.업로드 경로를 얻기
		String urlPath = "/upload";
		String path = request.getServletContext().getRealPath(urlPath);

		//2. 업로드된 파일명 얻기s
		String fileName = filePart.getSubmittedFileName();

		//3. 경로구분자
		String filePath = path+File.separator+fileName; //File.separator-> "\\"

		//4. 경로가 없다는 오류 문제
		File pathFile = new File(path);
		if(!pathFile.exists())//존재하지 않으면
			pathFile.mkdirs();//생성해주세요

		//5. 동일한 파일명에 경로에 이미 존재하는 문제 aa.jpg->aa(1).jpg
		//				File ? = new File(?);
		//				
		//				if(?존재한다면) {
		//					꼬리(확장자)를 잘라낸 이름을 얻고 그 마지막에 소괄호()가 있는지 확인하고 있으면 번호를 알아내고 1증가된 값을 얻어서 fileName=?;
		//				}

		InputStream fis = filePart.getInputStream();
		FileOutputStream fos = new FileOutputStream("D:\\temp\\"+fileName);

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
		request.getRequestDispatcher("/WEB-INF/view/freeboard/reg.jsp").forward(request, response);
	}

}
