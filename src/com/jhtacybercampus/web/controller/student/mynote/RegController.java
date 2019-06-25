package com.jhtacybercampus.web.controller.student.mynote;

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


@WebServlet("/student/mynote/reg")
@MultipartConfig(
	location = "C:\\temp", 
	fileSizeThreshold = 1024 * 1024, 
	maxFileSize = 1024 * 1024 * 5, 
	maxRequestSize = 1024 * 1024 * 5 * 5 
	)
public class RegController extends HttpServlet {
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   //����,����,���̵�
	   
	  Integer id = Integer.parseInt(request.getParameter("writerid"));
      String content = request.getParameter("content");
      Part filePart = request.getPart("file");
      //String fileName = request.getParameter("filename"); 
      
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
		

    		MynoteDao mynoteDao = new OracleMynoteDao();
    		MynoteFileDao mynoteFileDao = new OracleMynoteFileDao();
    		
    		Mynote mynote = new Mynote();
    		mynote.setContent(content);
    	    mynote.setWriter_id(id);
    	    
     
    	      
    	int result=0;
    		
    	try {
    			// Enterprise Java Bean EJB
    	     result = mynoteDao.insert(mynote);
    	     //int mynoteId = mynoteDao.getLastId();
    	      
    	      MynoteFile mynoteFile = new MynoteFile();
    	     
    	      mynoteFile.setName(fileName);
    	      mynoteFile.setMynoteId(mynoteDao.getLastId());
    	
    	      mynoteFileDao.insert(mynoteFile);
    	      
    	      
    	} catch (ClassNotFoundException | SQLException e) {
    	      e.printStackTrace();
    	}
    	   
    	      
    	if(result !=1)
    	   response.sendRedirect("error");
    	else
    	  //response.sendRedirect("list?id="+id);
    		response.sendRedirect("list");
    	}

    	
    

   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("../../WEB-INF/view/student/mynote/list.jsp").forward(request, response);
   }
   
}