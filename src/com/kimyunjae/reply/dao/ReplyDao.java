package com.kimyunjae.reply.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kimyunjae.board.vo.Criteria;
import com.kimyunjae.reply.vo.Reply;
import com.kimyunjae.util.common.BeanPropertySetter;
import com.kimyunjae.util.common.DBConn;

public class ReplyDao {
	public boolean add(Reply vo,int boardno) {
		boolean retVal = false;
		String sql = "INSERT INTO REPLY (REPLYNO, BOARDNO, WRITER, CONTENT) VALUES(REPLY_SEQ.NEXTVAL, ?, ?, ?)";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setInt(idx++, boardno);
			pstmt.setString(idx++, vo.getWriter());
			pstmt.setString(idx++, vo.getContent());
			retVal = pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public int getCount(String category, String keyword) {
		return 0;
	}

	public List<Reply> getReplys(int boardno) {
		List<Reply> list = new ArrayList<>();
		String sql = "SELECT REPLYNO,\r\n" + 
				"    (SELECT NICKNAME FROM MEMBER M WHERE M.EMAIL = R.WRITER) WRITERNAME, \r\n" + 
				" CONTENT , TO_CHAR(REGDATE, 'YYYY-MM-DD'),WRITER,REMOVAL \r\n" + 
				"FROM REPLY R\r\n" + 
				"WHERE BOARDNO = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply reply = new Reply();
				int idx = 1;
				reply.setReplyno(rs.getInt(idx++));
				reply.setWritername(rs.getString(idx++));
				reply.setContent(rs.getString(idx++));
				reply.setRegdate(rs.getString(idx++));
				reply.setWriter(rs.getString(idx++));
				reply.setRemoval(rs.getBoolean(idx++));
				list.add(reply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}


	public boolean modify(Reply vo) {
		return false;
	}

	public boolean remove(int replyno) {
		boolean retVal = false;
		String sql = "UPDATE REPLY SET REMOVAL = 1, CONTENT = NULL WHERE REPLYNO = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, replyno);
			retVal = pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

}
