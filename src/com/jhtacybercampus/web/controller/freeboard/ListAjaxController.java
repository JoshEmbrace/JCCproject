package com.jhtacybercampus.web.controller.freeboard;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.FreeBoardDao;
import com.jhtacybercampus.web.dao.oracle.OracleFreeBoardDao;
import com.jhtacybercampus.web.entity.FreeBoard;



@WebServlet("/freeboard/list-ajax")
public class ListAjaxController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 1;
		String p_ = request.getParameter("p");
		if(p_ != null && !p_.equals(""))
			page = Integer.parseInt(p_);

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
		((ServletResponse) request).setContentType("text/txt;charset=utf-8");//MIME json content type
		PrintWriter out = ((ServletResponse) request).getWriter();
		StringBuilder json = new StringBuilder();
		json.append("[");

		/*
		 * <td class="num">${n.id}</td> 
		 * <td class="title"><a href="detail?id=${n.id}">${n.title}</td>
			<td class="writer">${n.writer_id}</td> 
			<td class="date">${n.reg_date}</td> </tr>
		 */

		for(int i=0; i<list.size(); i++) {
			FreeBoard a= list.get(i);
			json.append("{");
			json.append(String.format("\"id\" : %d," ,a.getId()));
			json.append(String.format("\"title\" : \"%s\"," ,a.getTitle()));
			json.append(String.format("\"writerId\" : %d,"  ,a.getWriter_id()));
			json.append(String.format("\"regDate\" : \"%s\"," ,a.getReg_date()));
			json.append("}");

			if(i != list.size()-1) {

				json.append(",");

			}

		}
		json.append("]");


		out.write(json.toString());
	}
}
