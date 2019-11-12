package com.kimyunjae.member.service;

import java.util.List;

import com.kimyunjae.member.vo.Member;
import com.kimyunjae.member.vo.MemberFile;

public interface MemberService {
	boolean signup(Member vo);
	Member login(Member vo);
	Member getMember(String email);
	List<Member> getmembers();
	boolean modify(Member vo);
	boolean remove(String email);
	MemberFile getMemberFileByEmail(String email);
}
