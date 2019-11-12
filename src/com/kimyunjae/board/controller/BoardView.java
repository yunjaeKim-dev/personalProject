package com.kimyunjae.board.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.board.service.BoardServiceImpl;
import com.kimyunjae.reply.service.ReplyServiceImpl;
import com.kimyunjae.reply.vo.Reply;
import com.kimyunjae.util.common.BeanPropertySetter;

@WebServlet("/boardView")
public class BoardView extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		req.setAttribute("board", new BoardServiceImpl().getBoard(boardno));
		
		ReplyServiceImpl service = new ReplyServiceImpl();
		List<Reply> reply = new ArrayList<>();
		reply = service.getReplys(boardno);
		BeanPropertySetter.setProps(req, reply);
		req.setAttribute("reply", reply);
		req.getRequestDispatcher("board/view.jsp").forward(req, resp);
		
	}
	
}
