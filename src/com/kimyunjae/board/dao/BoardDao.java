package com.kimyunjae.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.ResolutionSyntax;

import com.kimyunjae.board.vo.BoardVo;
import com.kimyunjae.board.vo.Criteria;
import com.kimyunjae.util.common.DBConn;

public class BoardDao {
	public boolean add(BoardVo vo) {
		boolean retVal = false;
		String sql = "INSERT INTO BOARD(BOARDNO , TITLE, CONTENT, WRITER, CATEGORY, REGDATE, secret) VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?,SYSDATE, ?)";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setString(idx++, vo.getTitle());
			pstmt.setString(idx++, vo.getContent());
			pstmt.setString(idx++, vo.getWriter());
			pstmt.setString(idx++, vo.getCategory());
			pstmt.setBoolean(idx++, vo.isSecret());
			retVal = pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public int getCount(String category,String keyword) {
		int cnt = 0;
		String sql = "SELECT MAX(ROWNUM) FROM BOARD WHERE 1 = 1 \r\n";
		if(category != null) sql += " AND CATEGORY = " + category;
		if(keyword != null) {
			keyword = "'%"+ keyword.trim() +"%'";
			sql += " AND TITLE LIKE " + keyword;
		}
				
		try {
			PreparedStatement pstmt = DBConn.getConnection().prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
			cnt = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return cnt;
	}

	public List<BoardVo> getBoards(Criteria cri, String category, String keyword){
		List<BoardVo> boardList = new ArrayList<>();
		String sql ="SELECT * FROM\r\n" + 
				"    (SELECT  A.*, ROWNUM RN FROM (\r\n" + 
				"        SELECT \r\n" + 
				"        BOARDNO, TITLE, WRITER, \r\n" + 
				"        (SELECT NICKNAME FROM MEMBER M WHERE BOARD.WRITER = M.EMAIL) AS WRITERNAME,\r\n" + 
				"        TO_CHAR(REGDATE, 'YYYY-MM-DD') REGDATE, HITCOUNT, RECM, NOTRECM, SECRET \r\n" + 
				"    FROM BOARD \r\n" + 
				"    WHERE 1 = 1 \r\n";  
				if(category != null) {sql += " AND CATEGORY = " + category.trim() +  " \r\n";}
				if(keyword != null) {
					keyword = "'%"+keyword.trim()+"%'";
					sql += "AND TITLE LIKE " + keyword + " \r\n";
				}
				sql += "    ORDER BY BOARDNO DESC\r\n" + 
				"    ) A \r\n" + 
				"    WHERE ROWNUM <= ? * ? \r\n" + 
				")\r\n" + 
				" WHERE RN > (? - 1) * ?";
				
				
//		String sql = "SELECT * FROM\r\n" + 
//				"    (SELECT  A.*, ROWNUM RN FROM (\r\n" + 
//				"        SELECT \r\n" + 
//				"        BOARDNO, TITLE, WRITER, \r\n" + 
//				"        (SELECT NICKNAME FROM MEMBER M WHERE BOARD.WRITER = M.EMAIL) AS WRITERNAME,\r\n" + 
//				"        TO_CHAR(REGDATE, 'YYYY-MM-DD') REGDATE, HITCOUNT, RECM, NOTRECM, SECRET \r\n" +  
//				"    FROM BOARD \r\n" +
//				"    WHERE 1 = 1 \r\n";
//				if(category != null) {sql += " AND CATEGORY = " + category;}
//				if(keyword != null) {
//					keyword = "'%"+ keyword.trim() +"%'";
//					sql += " AND TITLE LIKE " + keyword + " \r\n";
//					}
//				sql += "    ORDER BY BOARDNO DESC\r\n" + 
//				"    ) A \r\n" + 
//				"    WHERE ROWNUM <= ? * ? \r\n" + 
//				")\r\n" + 
//				" WHERE RN > (? - 1) * ?";
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int idx = 1;
			pstmt.setInt(idx++, cri.getPage());
			pstmt.setInt(idx++, cri.getAmount());
			pstmt.setInt(idx++, cri.getPage());
			pstmt.setInt(idx++, cri.getAmount());
			
			ResultSet rs =  pstmt.executeQuery();
			while(rs.next()) {
				BoardVo boardVo = new BoardVo();
				idx = 1;
				boardVo.setBoardno(rs.getInt(idx++));
				boardVo.setTitle(rs.getString(idx++));
				boardVo.setWriter(rs.getString(idx++));
				boardVo.setWritername(rs.getString(idx++));
				boardVo.setRegdate(rs.getString(idx++));
				boardVo.setHitcount(rs.getInt(idx++));
				boardVo.setRecm(rs.getInt(idx++));
				boardVo.setNotrecm(rs.getInt(idx++));
				boardVo.setSecret(rs.getBoolean(idx++));
				boardList.add(boardVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return boardList;
	}
	
	public BoardVo getBoard(int boardno) {
		BoardVo vo = new BoardVo();
		Connection conn = DBConn.getConnection();
		try {
			String sql = "UPDATE BOARD SET HITCOUNT = (SELECT HITCOUNT FROM BOARD WHERE BOARDNO = ? ) + 1 WHERE BOARDNO = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			pstmt.setInt(2, boardno);
			pstmt.executeUpdate();
			pstmt.close();
			
			sql = "SELECT BOARDNO, TITLE, CONTENT, WRITER, \r\n" + 
					"        (SELECT NICKNAME FROM MEMBER M WHERE M.EMAIL = B.WRITER) WRITERNAME,\r\n" + 
					"        HITCOUNT, RECM, NOTRECM, CATEGORY, TO_CHAR(REGDATE,'YYYY-MM-DD'), TO_CHAR(MODDATE,'YYYY-MM-DD') \r\n" + 
					"FROM BOARD B\r\n" + 
					"WHERE BOARDNO = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				
				vo.setBoardno(rs.getInt(idx++));
				vo.setTitle(rs.getString(idx++));
				vo.setContent(rs.getString(idx++));
				vo.setWriter(rs.getString(idx++));
				vo.setWritername(rs.getString(idx++));
				vo.setHitcount(rs.getInt(idx++));
				vo.setRecm(rs.getInt(idx++));
				vo.setNotrecm(rs.getInt(idx++));
				vo.setCategory(rs.getString(idx++));
				vo.setRegdate(rs.getString(idx++));
				vo.setModdate(rs.getString(idx++));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}

	public boolean modify(BoardVo vo) {
		boolean retVal = false;
		String sql = "UPDATE BOARD SET TITLE = ?, CONTENT = ? WHERE BOARDNO = ? ";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBoardno());
			retVal = pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

	public boolean remove(int boardno) {
		boolean retVal = false;
		String sql = "DELETE BOARD WHERE BOARDNO = ?";
		try {
			Connection conn = DBConn.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardno);
			retVal = pstmt.executeUpdate() != 0;
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}

}
