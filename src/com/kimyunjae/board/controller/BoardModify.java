package com.kimyunjae.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.board.service.BoardServiceImpl;
import com.kimyunjae.board.vo.BoardVo;
import com.kimyunjae.util.common.BeanPropertySetter;

@WebServlet("/boardModify")
public class BoardModify extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		req.setAttribute("board", new BoardServiceImpl().getBoard(boardno));
		req.getRequestDispatcher("board/modify.jsp").forward(req, resp);;
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardVo board = new BoardVo();
		BeanPropertySetter.setProps(req, board);
		new BoardServiceImpl().modify(board);
		resp.sendRedirect("boardView?boardno="+board.getBoardno());
	}
	
}
