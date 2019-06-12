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


@WebServlet("/mynote/edit")
public class EditController extends HttpServlet{

	//수정 후 수정된 내용 저장하기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Integer id = Integer.parseInt(request.getParameter("id"));
		String content = request.getParameter("content");
	
System.out.println("id:"+id+",content:"+content);
//선생님 풀이
MynoteDao mynoteDao  = new OracleMynoteDao();
		
Mynote mynote = new Mynote();
mynote.setId(id);
mynote.setContent(content);
		
int result=0;
try {
	result = mynoteDao.update(mynote);
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println("자"+result);


//request.getRequestDispatcher("../WEB-INF/view/mynote/list.jsp").forward(request, response);

if(result !=1)
	response.sendRedirect("error");
else
	response.sendRedirect("list");
		
	}		
	
		
	//수정 페이지로 넘어갈 때 기존에 작성됐던 글 가져오기
    @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //hello?cnt3 ->3?
    //hello? -> ""
    //hello -> null
    	
    	
      MynoteDao mynoteDao  = new OracleMynoteDao();
      
      Integer id = Integer.parseInt(request.getParameter("id"));
  
       try {
		request.setAttribute("mynote",  mynoteDao.get(id));
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