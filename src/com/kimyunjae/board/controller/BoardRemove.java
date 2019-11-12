package com.kimyunjae.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.board.service.BoardServiceImpl;


@WebServlet("/boardRemove")
public class BoardRemove extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		new BoardServiceImpl().remove(boardno);
		resp.sendRedirect("boardList");
		
	}
	
}
