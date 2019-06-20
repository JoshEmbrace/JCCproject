package com.jhtacybercampus.web.controller.freeboard;

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

import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.FreeboardFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeboardFileDao;
import com.jhtacybercampus.web.entity.FreeBoard;
import com.jhtacybercampus.web.entity.FreeboardFile;


@WebServlet("/freeboard/edit")
@MultipartConfig(
		location="C:\\temp",
		fileSizeThreshold = 1024 * 1024,
		maxFileSize = 1024 * 1024 * 5,
		maxRequestSize = 1024 * 1024 * 5 * 5
		)
public class EditController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//req.setCharacterEncoding("UTF-8");// 입력 한글깨짐 방지, 필터에다가 사전에 실행.
		request.setCharacterEncoding("UTF-8");
		//Integer id = Integer.parseInt(request.getParameter("id"));
		String sid = request.getParameter("id");
		Integer id = Integer.parseInt(sid);
		
		String title = request.getParameter("title");
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
			
		
		FreeBoardDao fbDao = new OracleFreeBoardDao();
		FreeboardFileDao fbFileDao = new OracleFreeboardFileDao();
		FreeboardFile fbFile = new FreeboardFile();
		
		fbFile.setFreeboardId(id);
		fbFile.setName(fileName);

		
		try {
			fbDao.update(new FreeBoard(id, title, content));
			request.setAttribute("notice",fbDao.get(id));
			fbFileDao.insert(fbFile);
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
		FreeboardFileDao fbFileDao = new OracleFreeboardFileDao();
		Integer id = Integer.parseInt(request.getParameter("id"));
		try {
			request.setAttribute("freeboard",fbDao.get(Integer.parseInt(request.getParameter("id"))));
			request.setAttribute("files", fbFileDao.getListByFreeboardId(id));
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
