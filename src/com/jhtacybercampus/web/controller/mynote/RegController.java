package com.jhtacybercampus.web.controller.mynote;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteDao;
import com.jhtacybercampus.web.entity.Mynote;


@WebServlet("/mynote/reg")
public class RegController extends HttpServlet {

   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
	   //내용,파일,아이디
	  
      String file_name = request.getParameter("file_name");
      String file_path = request.getParameter("file_path");
     
      String content = request.getParameter("content");
      
      MynoteDao mynoteDao = new OracleMynoteDao();
      Mynote mynote = new Mynote();
      
      mynote.setContent(content);
      mynote.setFile_name(file_name);
      mynote.setFile_path(file_path);
    
      
      
      int result = 0;
      
      try {
         result = mynoteDao.insert(mynote);
      } catch (ClassNotFoundException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
//      
//      if(result != 1)
//         response.sendRedirect("../mynote/error");
//      else
      	
         response.sendRedirect("list");
       
      
   }
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.getRequestDispatcher("/WEB-INF/view/mynote/reg.jsp").forward(request, response);
   }
   
}