package com.jhtacybercampus.web.controller.member;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Member;
@WebServlet("/member/join")
public class joinController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// getParameter()占쏙옙 占싱울옙占쏙옙 占싼곤옙占쏙옙 占식띰옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙 占쌍댐옙.
    // 占식띰옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 name= 占쏙옙 占쏙옙占쏙옙占쌔듸옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쌘뤄옙 占쏙옙占쏙옙占쌔억옙 占싫댐옙.
	
	String id = req.getParameter("id");
    String password = req.getParameter("password");
    String name = req.getParameter("name");
    int gender = Integer.parseInt(req.getParameter("gender"));

    String birthday = req.getParameter("birthday");
    String email1 = req.getParameter("email_1");
    //String email2 = req.getParameter("email_2");
    
    
    //String phone = req.getParameter("phone");
    //String address = req.getParameter("address");

    OracleMemberDao memberDao = new OracleMemberDao();
    
    Member member = new Member();
    member.setUser_id(id);
    member.setUser_pwd(password);
    member.setName(name);
    member.setEmail(email1);
    //member.setHp(phone);
    member.setGender(gender);
    member.setBirthday(birthday);
    
   //占쏙옙占쏙옙占싸븝옙 占쏙옙占쏙옙 占쌔곤옙占쌔야듸옙
    // member.setGender(gender);
    //占쏙옙占쏙옙 占싸분듸옙 占쏜르곤옙占쏙옙占싻ㅠㅿ옙 占쏙옙,占쏙옙,占쏙옙占쏙옙 占쏘떻占쏙옙 占쏙옙占쏙옙풔째占쏙옙歐占�?
//    member.setBirthday(birthyy);
    
    int result = 0;
    
    try {
		result = memberDao.insert(member);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
    if (result != 1)
		resp.sendRedirect("error");
	else
		resp.sendRedirect("login");//회占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占싹몌옙 占쏙옙占쏙옙占쏙옙占쏙옙占쏙옙占� 占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙.
}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("../WEB-INF/view/member/joinForm.jsp").forward(req, resp);
	}
}
