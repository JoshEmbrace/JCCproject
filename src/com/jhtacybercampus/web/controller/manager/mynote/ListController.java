package com.jhtacybercampus.web.controller.manager.mynote;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.MynoteDao;
import com.jhtacybercampus.web.dao.MynoteFileDao;

import com.jhtacybercampus.web.dao.oracle.OracleMynoteDao;
import com.jhtacybercampus.web.dao.oracle.OracleMynoteFileDao;
import com.jhtacybercampus.web.entity.MynoteFile;
import com.jhtacybercampus.web.entity.MynoteView;




@WebServlet("/manager/mynote/list")
public class ListController extends HttpServlet{
	 @Override
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      
	    	int page = 1;
	    	String p_ = request.getParameter("p");
	    	//Integer id = Integer.parseInt(request.getParameter("id"));
	    	System.out.println(p_);
	    	
	      if(p_!=null && !p_.equals("")) {
	    	  page = Integer.parseInt(request.getParameter("p"));
	      }
	      
	      
	      MynoteDao mynoteDao  = new OracleMynoteDao();
	      MynoteFileDao mynotefileDao = new OracleMynoteFileDao();
	      
	      
	      
	      List<MynoteView> list;
		try {
			list = mynoteDao.getList(page);
			for(MynoteView a : list) {
		    	  String mynoteFile = "mynoteFile"+a.getId();
		    	  System.out.println(mynoteFile);
		    	  List<MynoteFile> files = mynotefileDao.getListByMynoteId(a.getId());
		    	  request.setAttribute(mynoteFile, files);
		      }
		      request.setAttribute("list", list);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	      
	      
	      
	    
	       
	       request.getRequestDispatcher("../..//WEB-INF/view/manager/mynote/list.jsp").forward(request, response);

	   }
	
	
	
	
	
	
//	@Override
//   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      
//    	
//      MynoteDao mynoteDao  = new OracleMynoteDao();
//      MynoteFileDao mynoteFileDao = new OracleMynoteFileDao();
//
//      
//      if(request.getParameter("id") == null) {
//      try {
//    	System.out.println(mynoteDao.getList().get(1).getId());
//   	   request.setAttribute("list", mynoteDao.getList()); 
//   	   //request.setAttribute("mynoteFiles", mynoteFileDao.getListByMynoteId(id));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//      request.getRequestDispatcher("/WEB-INF/view/mynote/list.jsp").forward(request, response);
//      }
//      else
//      {
//    	  Integer id = Integer.parseInt(request.getParameter("id"));
//    	  
//      try {
//    	   request.setAttribute("list", mynoteDao.getList()); 
//    	   //request.setAttribute("mynoteFiles", mynoteFileDao.getListByMynoteId(id));
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//       request.getRequestDispatcher("/WEB-INF/view/mynote/list.jsp").forward(request, response);
//
//   }
//}
//    
    
   
   
}