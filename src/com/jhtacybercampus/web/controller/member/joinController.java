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
	// getParameter()�� �̿��� �Ѱ��� �Ķ���� ���� ���� �� �ִ�.
    // �Ķ���� ���� ������ name= �� �����ص� ���� ������ ���� ���ڷ� �����ؾ� �ȴ�.
    String id = req.getParameter("id");
    String password = req.getParameter("password");
    String name = req.getParameter("name");
    
    // ������ ��� �Ķ���� �̸��� �Ѵ� gender�� �����ϹǷ� �迭�� �޾ƾ� �ȴ�.
    //�����κ� ���� �ذ�
    //int[] gender = Integer.parseInt(req.getParameterValues("gender"));
    String birthyy = req.getParameter("birth_yy");
    
    // ������ ��� <select>�� �Ǿ� �ִµ� �Ķ���� ���� ���� �� �迭���·� �Ѱ� �޴´�.
    String[] birthmm = req.getParameterValues("birth_mm");
    String birthdd = req.getParameter("birth_dd");
    String email1 = req.getParameter("email_1");
    
    // �̸����� ��� <select>�� �Ǿ� �ִµ� �Ķ���� ���� ���� �� �迭���·� �Ѱ� �޴´�.
    String[] email2 = req.getParameterValues("email_2");
    String phone = req.getParameter("phone");
    String address = req.getParameter("address");

    OracleMemberDao memberDao = new OracleMemberDao();
    
    Member member = new Member();
    member.setUser_id(id);
    member.setUser_pwd(password);
    member.setName(name);
   //�����κ� ���� �ذ��ؾߵ�
    // member.setGender(gender);
    //���� �κе� �𸣰����ФФ� ��,��,���� ��� ����Ǵ°��ϱ�?
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
		resp.sendRedirect("");//ȸ������ �����ϸ� ����������� ���� ���� ������.
}

@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	req.getRequestDispatcher("/WEB-INF/view/member/joinForm.jsp").forward(req, resp);
	}
}
