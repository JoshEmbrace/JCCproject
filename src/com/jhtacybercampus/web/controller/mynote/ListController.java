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



@WebServlet("/mynote/list")
public class ListController extends HttpServlet{
    @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      MynoteDao mynoteDao  = new OracleMynoteDao();
      Mynote mynote = new Mynote();
       try {
    	   request.setAttribute("list",  mynoteDao.getList());
    	   request.setAttribute("id", mynote.getId());
    	   
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
       request.getRequestDispatcher("../WEB-INF/view/mynote/list.jsp").forward(request, response);

   }
   
   
}