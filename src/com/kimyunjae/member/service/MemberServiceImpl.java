package com.kimyunjae.member.service;

import java.util.List;

import com.kimyunjae.member.dao.MemberDao;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.member.vo.MemberFile;

public class MemberServiceImpl implements MemberService {
	MemberDao dao = new MemberDao();
	
	@Override
	public boolean signup(Member vo) {
		// TODO Auto-generated method stub
		return dao.signup(vo);
	}

	@Override
	public Member login(Member vo) {
		// TODO Auto-generated method stub
		return dao.login(vo);
	}

	@Override
	public Member getMember(String email) {
		// TODO Auto-generated method stub
		return dao.getMember(email);
	}

	@Override
	public List<Member> getmembers() {
		// TODO Auto-generated method stub
		return dao.getmembers();
	}

	@Override
	public boolean modify(Member vo) {
		// TODO Auto-generated method stub
		return dao.modify(vo);
	}

	@Override
	public boolean remove(String email) {
		// TODO Auto-generated method stub
		return dao.remove(email);
	}

	@Override
	public MemberFile getMemberFileByEmail(String email) {
		return dao.getMemberFileByEmail(email);
	}

	

}
