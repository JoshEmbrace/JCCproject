package com.jhtacybercampus.web.controller.manager.freeboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;
import com.jhtacybercampus.web.entity.FreeBoard;



@WebServlet("/manager/freeboard/list-ajax")
public class ListAjaxController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 1;
		
		String p = request.getParameter("p");
		if(p != null && !p.equals(""))
			page = Integer.parseInt(p);

		FreeBoardDao fbDao = new OracleFreeBoardDao();
		List<FreeBoard> list = null;

		try {
			list=fbDao.getList(page);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		StringBuilder json = new StringBuilder();
		json.append("[");


		for(int i=0; i<list.size(); i++) {
			FreeBoard a= list.get(i);
			json.append("{");
			json.append(String.format("\"id\": %d," ,a.getId()));
			json.append(String.format("\"title\": \"%s\"," ,a.getTitle()));
			json.append(String.format("\"writer_id\": %d,"  ,a.getWriter_id()));
			json.append(String.format("\"reg_date\": \"%s\"" ,a.getReg_date()));
			json.append("}");

			if(i != (list.size())-1) {

				json.append(",");

			}

		}
		json.append("]");


		out.write(json.toString());
	}
}
