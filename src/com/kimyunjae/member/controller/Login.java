package com.kimyunjae.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.member.service.MemberServiceImpl;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.util.common.BeanPropertySetter;
@WebServlet("/login")
public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("index").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member bean = new Member();
		BeanPropertySetter.setProps(req, bean);
		Member member = new MemberServiceImpl().login(bean);
		if(member == null) {
			req.setAttribute("error", "로그인 실패");
			System.out.println("로그인 실패");
			resp.sendRedirect("login");
		}else {
			req.getSession(true).setAttribute("user", member);
			resp.sendRedirect("index");
			
		}
	}
}
