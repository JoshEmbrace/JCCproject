package com.jhtacybercampus.web.controller.student.mynote;

import java.io.IOException;
import java.io.PrintWriter;
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
import com.jhtacybercampus.web.entity.Mynote;
import com.jhtacybercampus.web.entity.MynoteFile;
import com.jhtacybercampus.web.entity.MynoteView;


@WebServlet("/student/mynote/list-ajax")
public class ListAjaxController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int page = 2;
		String p_ = req.getParameter("p");
		if(p_!=null && !p_.equals(""))
			page = Integer.parseInt(p_);
		
		MynoteDao nd = new OracleMynoteDao();
		MynoteFileDao fd = new OracleMynoteFileDao();
		List<MynoteView> list = null;
		List<MynoteFile> fileList = null;
		
		try {
			list=nd.getList(page);
			
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");//MIME json content type
		PrintWriter out = resp.getWriter();
		
		StringBuilder json = new StringBuilder();
		json.append("[");
		for(int i=0; i<list.size(); i++) {
			MynoteView n = list.get(i);
			try {
				fileList = fd.getListByMynoteId(n.getId());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			json.append("{");
			json.append(String.format("\"id\" : %d,", n.getId()));
			json.append(String.format("\"content\" : \"%s\",", n.getContent()));
			json.append(String.format("\"regDate\" : \"%s\"", n.getReg_date()));
			
			if(fileList.size()>=1)
				json.append(",");
			
			
			for(int j=0;j<fileList.size();j++) {
				json.append(String.format("\"filename%d\" : \"%s\"", j+1,fileList.get(j).getName()));
				if(j!=(fileList.size())-1)
					json.append(",");
			}
			json.append("}");
			
			if(i!=(list.size())-1)
				json.append(",");
		}
		json.append("]");
		
		out.write(json.toString());
	}

}








