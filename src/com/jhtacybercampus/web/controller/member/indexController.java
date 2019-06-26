package com.jhtacybercampus.web.controller.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jhtacybercampus.web.entity.Member;

@WebServlet("/member/index")
public class indexController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpServletRequest httpRequest = (HttpServletRequest) req;

		HttpSession session = httpRequest.getSession();

		if (session.getAttribute("user") != null) {
			System.out.println("user null¿Ã æ∆¥“∂ß");
			Member user = (Member) session.getAttribute("user");

			int grade = 0;

			if (user != null)
				grade = user.getGrade();

			switch (grade) {
			case 1:
				resp.sendRedirect("../student/index");
				break;
			case 2:
				resp.sendRedirect("../teacher/index");
				break;
			case 3:
				resp.sendRedirect("../manager/index");
				break;
			default:
				resp.sendRedirect("/semi-JCC/index");

			}
		}else
			resp.sendRedirect("/semi-JCC/index");

	}

}