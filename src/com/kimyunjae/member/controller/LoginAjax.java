package com.kimyunjae.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.basket.service.BasketServiceImpl;
import com.kimyunjae.member.service.MemberServiceImpl;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.member.vo.MemberFile;
import com.kimyunjae.util.common.BeanPropertySetter;
@WebServlet("/loginAjax")
public class LoginAjax extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member bean = new Member();
		BeanPropertySetter.setProps(req, bean);
		Member member = new MemberServiceImpl().login(bean);
		System.out.println(member);
//		System.out.println(bean);
//		System.out.println(member);
		MemberFile file = new MemberFile();
		if(member!= null && member.getFile() != null ) {
			file = member.getFile();
		}
		if(member != null) {
			// 로그인 성공
			req.getSession(true).setAttribute("file", file);
			req.getSession(true).setAttribute("user", member);
			req.getSession(true).setAttribute("basket", new BasketServiceImpl().getBasketList(member.getEmail()));
			resp.getWriter().print(1);
		}
	}
}




