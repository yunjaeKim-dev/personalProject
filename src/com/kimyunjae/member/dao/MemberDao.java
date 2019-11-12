package com.kimyunjae.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.kimyunjae.member.vo.Member;
import com.kimyunjae.member.vo.MemberFile;
import com.kimyunjae.util.common.DBConn;

public class MemberDao {
	public boolean signup(Member vo) {
		boolean retVal = false;
		Member member = new Member();
		String sql = "INSERT INTO MEMBER(EMAIL, PWD, NAME, NICKNAME, BIRTHDATE, PHONE) \r\n" + 
				"VALUES(?,?,?,?,?,?)";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int idx = 1;
			pstmt.setString(idx++, vo.getEmail());
			pstmt.setString(idx++, vo.getPwd());
			pstmt.setString(idx++, vo.getName());
			pstmt.setString(idx++, vo.getNickname());
			pstmt.setString(idx++, vo.getBirthdate());
			pstmt.setString(idx++, vo.getPhone());
			retVal = pstmt.executeUpdate() != 0;
			pstmt.close();

			sql = "INSERT INTO ATTACH_FILE VALUES(ATTACH_FILE_SEQ.NEXTVAL, ?,?,?,?,?,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			int idx2 = 1;
			MemberFile file = vo.getFile();
			pstmt.setString(idx2++, vo.getEmail());
			pstmt.setString(idx2++, file.getOriginname());
			pstmt.setString(idx2++, file.getFilename());
			pstmt.setString(idx2++, file.getMimetype());
			pstmt.setString(idx2++, file.getFilepath());
			pstmt.setInt(idx2++, file.getFilesize());
			retVal = pstmt.executeUpdate() != 0;
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public Member login(Member vo) {
		Member member = null;
		String sql = "SELECT EMAIL, PWD, NAME,NICKNAME, BIRTHDATE, PHONE, ADMIN FROM MEMBER WHERE EMAIL = ? AND PWD = ?";
		
		try {
			PreparedStatement pstmt = DBConn.getConnection().prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			pstmt.setString(2, vo.getPwd());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx= 1;
				member = new Member();
				member.setEmail(rs.getString(idx++));
				member.setPwd(rs.getString(idx++));
				member.setName(rs.getString(idx++));
				member.setNickname(rs.getString(idx++));
				member.setBirthdate(rs.getString(idx++));
				member.setPhone(rs.getString(idx++));
				member.setAdmin(rs.getBoolean(idx++));
				member.setFile(getMemberFileByEmail(vo.getEmail()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public Member getMember(String email) {
		Member member = null;
		String sql = "SELECT EMAIL, PWD, NAME, NICKNAME, TO_CHAR(BIRTHDATE,'YYYY-MM-DD'), PHONE, ADMIN FROM MEMBER WHERE EMAIL = ?";
		try {
			PreparedStatement pstmt = DBConn.getConnection().prepareStatement(sql);
			pstmt.setString(1, email);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx= 1;
				member = new Member();
				member.setEmail(rs.getString(idx++));
				member.setPwd(rs.getString(idx++));
				member.setName(rs.getString(idx++));
				member.setNickname(rs.getString(idx++));
				member.setBirthdate(rs.getString(idx++));
				member.setPhone(rs.getString(idx++));
				member.setAdmin(rs.getBoolean(idx++));
				System.out.println(getMemberFileByEmail(email));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<Member> getmembers() {
		Member member = null;
		List<Member> list = new ArrayList<>();
		String sql = "SELECT EMAIL, PWD, NAME, NICKNAME, TO_CHAR(BIRTHDATE,'YYYY-MM-DD'), PHONE, ADMIN FROM MEMBER";
		try {
			PreparedStatement pstmt = DBConn.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx= 1;
				member = new Member();
				member.setEmail(rs.getString(idx++));
				member.setPwd(rs.getString(idx++));
				member.setName(rs.getString(idx++));
				member.setNickname(rs.getString(idx++));
				member.setBirthdate(rs.getString(idx++));
				member.setPhone(rs.getString(idx++));
				member.setAdmin(rs.getBoolean(idx++));
				list.add(member);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean modify(Member vo) {
		boolean retVal = false;
		String sql = "UPDATE MEMBER SET PWD = ?, NICKNAME = ?, PHONE=? WHERE EMAIL=?";
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, vo.getPwd());
			pstmt.setString(idx++, vo.getNickname());
			pstmt.setString(idx++, vo.getPhone());
			pstmt.setString(idx++, vo.getEmail());
			
			retVal = pstmt.executeUpdate() != 0; 
			pstmt.close();
			
			MemberFile file = new MemberFile();
			file = vo.getFile();
			sql = "UPDATE ATTACH_FILE SET ORIGINNAME = ?, FILENAME = ?, MIMETYPE = ? , FILEPATH = ?, FILESIZE = ?, REGDATE = SYSDATE \r\n"
					+ "WHERE EMAIL = ?";
			pstmt = conn.prepareStatement(sql);
			int idx2 = 1;
			pstmt.setString(idx2++, file.getOriginname());
			pstmt.setString(idx2++, file.getFilename());
			pstmt.setString(idx2++, file.getMimetype());
			pstmt.setString(idx2++, file.getFilepath());
			pstmt.setInt(idx2++, file.getFilesize());
			pstmt.setString(idx2++, vo.getEmail());
			retVal = pstmt.executeUpdate() != 0;
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;

	}

	public boolean remove(String email) {
		boolean retVal = false;
		String sql = "DELETE FROM MEMBER WHERE EMAIL = ?";
		try {
			PreparedStatement pstmt = DBConn.getConnection().prepareStatement(sql);
			pstmt.setString(1, email);
			retVal = pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public MemberFile getMemberFileByEmail(String email) {
		MemberFile file = new MemberFile();
		String sql = "SELECT FILENO, EMAIL, ORIGINNAME, FILENAME, MIMETYPE, FILEPATH, FILESIZE, TO_CHAR(REGDATE, 'YYYY-MM-DD') \r\n"
				+ "FROM ATTACH_FILE \r\n"
				+ "WHERE EMAIL = ? \r\n";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				file.setFileno(rs.getInt(idx++));
				file.setEmail(rs.getString(idx++));
				file.setOriginname(rs.getString(idx++));
				file.setFilename(rs.getString(idx++));
				file.setMimetype(rs.getString(idx++));
				file.setFilepath(rs.getString(idx++));
				file.setFilesize(rs.getInt(idx++));
				file.setDate(rs.getString(idx++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return file;
	}

}
