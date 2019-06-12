package com.jhtacybercampus.web.controller.mynote;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.dao.MynoteFileDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteFileDao;
import com.jhtacybercampus.web.entity.Mynote;



@WebServlet("/mynote/list")
public class ListController extends HttpServlet{
    @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      MynoteDao mynoteDao  = new OracleMynoteDao();
      MynoteFileDao mynoteFileDao = new OracleMynoteFileDao();

      //Integer id = Integer.parseInt(request.getParameter("id"));
       try {
    	   request.setAttribute("list", mynoteDao.getList()); 
    	   //request.setAttribute("mynoteFiles", mynoteFileDao.getListByMynoteId(id));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
       request.getRequestDispatcher("/WEB-INF/view/mynote/list.jsp").forward(request, response);

   }
    
    
   
   
}