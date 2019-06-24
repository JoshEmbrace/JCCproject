package com.jhtacybercampus.web.controller.member;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jhtacybercampus.web.dao.oracle.OracleMemberDao;
import com.jhtacybercampus.web.entity.Member;

public class joinController extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// getParameter()를 이용해 넘겨진 파라미터 값을 얻어올 수 있다.
    // 파라미터 값을 얻을때 name= 에 지정해둔 값과 동일한 값을 인자로 지정해야 된다.
    String id = req.getParameter("id");
    String password = req.getParameter("password");
    String name = req.getParameter("name");
    
    // 성별의 경우 파라미터 이름이 둘다 gender로 동일하므로 배열로 받아야 된다.
    //젠더부분 같이 해결
    //int[] gender = Integer.parseInt(req.getParameterValues("gender"));
    String birthyy = req.getParameter("birth_yy");
    
    // 생일의 경우 <select>로 되어 있는데 파라미터 값을 받을 시 배열형태로 넘겨 받는다.
    String[] birthmm = req.getParameterValues("birth_mm");
    String birthdd = req.getParameter("birth_dd");
    String email1 = req.getParameter("email_1");
    
    // 이메일의 경우 <select>로 되어 있는데 파라미터 값을 받을 시 배열형태로 넘겨 받는다.
    String[] email2 = req.getParameterValues("email_2");
    String phone = req.getParameter("phone");
    String address = req.getParameter("address");

    OracleMemberDao memberDao = new OracleMemberDao();
    
    Member member = new Member();
    member.setUser_id(id);
    member.setUser_pwd(password);
    member.setName(name);
   //젠더부분 같이 해결해야됨
    // member.setGender(gender);
    //생일 부분도 모르겠음ㅠㅠㅠ 년,월,일이 어떻게 저장되는것일까?
//    member.setBirthday(birthyy);
    member.setEmail(email1+email2);
    member.setHp(phone);
    
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
		resp.sendRedirect("");//회원가입 성공하면 어느페이지로 갈지 아직 안정함.
}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp").forward(req, resp);
	}
}
