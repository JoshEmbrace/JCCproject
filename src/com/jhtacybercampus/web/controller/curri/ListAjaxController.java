package com.jhtacybercampus.web.controller.curri;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.CurriDao;
import com.jhtacybercampus.web.dao.oracle.OracleCurriDao;
import com.jhtacybercampus.web.entity.Curri;

@WebServlet("/curri/list-ajax")
public class ListAjaxController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int page = 2;
		String p = request.getParameter("p");
		if (p != null && !p.equals(""))
			page = Integer.parseInt(p);

		CurriDao cd = new OracleCurriDao();
		List<Curri> list = null;

		try {
			
			list = cd.getList(page);
			
		} catch (ClassNotFoundException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/txt:charset=utf-8");// MIME json content type
		PrintWriter out = response.getWriter();

		/*
		  문자열 더하기는 수행속도에 별로 안좋음 String json = "["; for(NoticeView a:list) { String col
		  = "{"+ "\"id\":"+a.getId()+","+ "\"title\":"+a.getTitle()+","+
		  "\"content\":"+a.getContent()+","+ "\"writerId\":"+a.getWriterId()+","+
		  "\"regDate\":"+a.getRegDate()+","+ "\"hit\":"+a.getHit()+","+
		  "\"commentCount\":"+a.getCommentCount()+ "}"; json += col; } json += "]";
		  out.write(json);
		 */
		StringBuilder json = new StringBuilder();
		json.append("[");
		

		
		for (int i = 0; i < list.size(); i++) {
			Curri n = list.get(i);

			json.append("{");
			json.append(String.format("\"id\":%d,", n.getId()));
			json.append(String.format("\"title\":\"%s\",", n.getTitle()));
			String content = n.getContent().replaceAll("\\s", "");
			json.append(String.format("\"content\":\"%s\",", content));
			json.append(String.format("\"regDate\":\"%s\"", n.getReg_date()));
			json.append("}");

			if (i != list.size() - 1)
				json.append(",");
		}

		json.append("]");

		out.write(json.toString());
		
	}
	
}
