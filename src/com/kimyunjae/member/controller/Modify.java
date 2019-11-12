package com.kimyunjae.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kimyunjae.member.service.MemberServiceImpl;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.member.vo.MemberFile;
import com.kimyunjae.util.common.BeanPropertySetter;
import com.kimyunjae.util.common.FileUtils;
import com.oreilly.servlet.MultipartRequest;

@WebServlet("/modify")
public class Modify extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Member sessionMember = (Member)(req.getSession().getAttribute("user"));
		if(sessionMember != null) {
			Member member = new MemberServiceImpl().getMember(sessionMember.getEmail());
			req.setAttribute("member", member);
			req.getRequestDispatcher("member/regist.jsp").forward(req, resp);
		} else {
			resp.sendRedirect("index");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
Member member = new Member();
		
		String path = getServletContext().getRealPath("upload");
//		System.out.println(path);
		int limit = 20 * 1024 * 1024;
		String upPath = FileUtils.createUploadFolder(path);
//		System.out.println(upPath);
		MultipartRequest multi = new MultipartRequest(req, path + File.separator + upPath, limit, "utf-8");
//		System.out.println("path + File.separator + upPath :: " + path + File.separator + upPath);
//		System.out.println("multi ::" + multi);
//		System.out.println("req.getContentType() :: " + req.getContentType());
		
		BeanPropertySetter.setProps(multi, member);
//		System.out.println("member :: " + member);
//		System.out.println("multi :: " + multi);
		
		String param = "file";
//		System.out.println("param :: " + param);
		
		String fileName = multi.getFilesystemName(param);
//		System.out.println("fileName :: " + fileName);
		
		MemberFile file = new MemberFile();
		if(fileName != null) {
			file.setOriginname(multi.getOriginalFileName(param));
			file.setFilename(fileName);
			file.setMimetype(multi.getContentType(param));
			file.setFilepath(upPath);
			file.setFilesize((int)multi.getFile(param).length());
		}
//		System.out.println("file :: " + file);
		member.setFile(file);
//		System.out.println("member :: " + member);
		FileUtils.createUploadFolder(path);
		new MemberServiceImpl().modify(member);
		resp.sendRedirect("index");
		
		
//		BeanPropertySetter.setProps(req, member);
//		if(new MemberServiceImpl().modify(member)) {
//			req.getSession().setAttribute("user", member);
//			System.out.println("회원 정보 수정 성공");
//			resp.sendRedirect("index");
//		} else {
//			req.setAttribute("error", "회원 정보 수정 에러");
//			System.out.println("회원 정보 수정 실패");
//			req.getRequestDispatcher("member/register.jsp").forward(req, resp);
//		}
	}
	
}
