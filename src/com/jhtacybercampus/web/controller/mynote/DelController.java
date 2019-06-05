
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


//메소드가없으면 405?
@WebServlet("/mynote/del")
public class DelController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
    
    Integer id = Integer.parseInt(request.getParameter("id"));
    MynoteDao mynoteDao  = new OracleMynoteDao();

    try {
		mynoteDao.delete(id);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    response.sendRedirect("../mynote/list");
   
 }
}