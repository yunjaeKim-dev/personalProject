package com.kimyunjae.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.board.service.BoardServiceImpl;
import com.kimyunjae.board.vo.BoardVo;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.util.common.BeanPropertySetter;

@WebServlet("/boardWrite")
public class BoardWrite extends HttpServlet{

	@Override
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("board/write.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardVo vo = new BoardVo();
		Member m = (Member)(req.getSession().getAttribute("user"));
		BeanPropertySetter.setProps(req, vo);
		vo.setWriter(m.getEmail());
		System.out.println(vo.isSecret());
		new BoardServiceImpl().add(vo);
		String category = null;
		if(req.getParameter("category") != null) {
			category = "?category=" + req.getParameter("category");
		}
		resp.sendRedirect("boardList"+category);
	
	}
	
	
}
