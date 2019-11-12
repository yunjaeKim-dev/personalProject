package com.kimyunjae.reply.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.board.vo.BoardVo;
import com.kimyunjae.reply.service.ReplyServiceImpl;
import com.kimyunjae.reply.vo.Reply;
import com.kimyunjae.util.common.BeanPropertySetter;


@WebServlet("/replyWrite")
public class ReplyWrite extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int boardno = Integer.parseInt(req.getParameter("boardno"));
		Reply reply = new Reply();
		BeanPropertySetter.setProps(req, reply);
		new ReplyServiceImpl().add(reply, boardno);
//		req.getRequestDispatcher("boardView?boardno="+boardno).forward(req, resp);
		resp.sendRedirect("boardView?boardno="+boardno);
		

	}

}
