package com.kimyunjae.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.member.service.MemberServiceImpl;
import com.kimyunjae.member.vo.Member;


@WebServlet("/removeMember")
public class Remove extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("member/remove.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member member = (Member)(req.getSession().getAttribute("user"));
		if(member != null && member.getEmail().equals(req.getParameter("email")) || member.isAdmin()) {
			new MemberServiceImpl().remove(member.getEmail());
			System.out.println("회원 탈퇴 성공");
			req.getSession().invalidate();
		}
		resp.sendRedirect("index");
	}
	
}
