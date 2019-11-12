package com.kimyunjae.basket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import com.kimyunjae.game.vo.Game;
import com.kimyunjae.util.common.DBConn;

public class BasketDao {
	public List<Game> addBasket(int gno, String email) {
		List<Game> list = new ArrayList<>();
		String sql = "INSERT INTO BASKET(BASKETNO, GNO, EMAIL) VALUES(BASKET_SEQ.NEXTVAL, ?, ?)";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			pstmt.setString(2, email);
			pstmt.executeUpdate();
			pstmt.close();
			conn.close();
			
			list = getBasketList(email);
			System.out.println(list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	};
	
	
	public boolean buyBasket(String email, List<Integer> gnos,List<Integer> basketnos) {
		boolean retVal = false;
		String sql = "INSERT INTO KEY(KNO, GNO, EMAIL) VALUES (KEY_SEQ.NEXTVAL, ? , ?)";
		Connection conn = DBConn.getConnection();
		
		try {
			for (int i = 0; i < gnos.size(); i++) {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, gnos.get(i));
				pstmt.setString(2, email);
				retVal = pstmt.executeUpdate() != 0;
				pstmt.close();
				removeSelectedBasket(email, basketnos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	public List<Game> removeBasket(String email, int basketno) {
		List<Game> list = new ArrayList<>();
		String sql = "DELETE BASKET WHERE EMAIL = ? AND BASKETNO = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setInt(2, basketno);
			pstmt.executeUpdate();
			pstmt.close();
			list = getBasketList(email);
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	};
	public boolean removeBasketAll(String email) {
		boolean retVal = false;
		String sql = "DELETE BASKET WHERE EMAIL = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			retVal = pstmt.executeUpdate() != 0;
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	public boolean removeSelectedBasket(String email, List<Integer> basketno) {
		boolean retVal = false;

		String sql = "DELETE BASKET WHERE EMAIL = ? AND (\r\n";
		for (int i = 0; i < basketno.size(); i++) {
			if(i == 0) {
				sql += " BASKETNO = " + basketno.get(i) + " \r\n";
			}else {
				sql += "OR BASKETNO = " + basketno.get(i) + " \r\n";
			}
		}
		sql += ")";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			retVal = pstmt.executeUpdate() != 0;
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	public List<Game> getBasketList(String email) {
		List<Game> list = new ArrayList<>();
		String sql = "SELECT B.BASKETNO, A.GNO, A.GNAME, A.PRICE, A.IMGPATH, A.CATEGORY, A.GOUTLINE, A.GEXPLAIN, A.GUSERCOM,\r\n" + 
				"A.DLC, A.ORI, TO_CHAR(B.REGDATE,'YYYY-MM-DD') FROM GAME A \r\n" + 
				"JOIN BASKET B\r\n" + 
				"ON A.GNO = B.GNO\r\n" + 
				"WHERE B.EMAIL = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Game g = new Game();
				int idx = 1;
				g.setBasketno(rs.getInt(idx++));
				g.setGno(rs.getInt(idx++));
				g.setGname(rs.getString(idx++));
				g.setPrice(rs.getInt(idx++));
				g.setImgpath(rs.getString(idx++));
				g.setCategory(rs.getString(idx++));
				g.setGoutline(rs.getString(idx++));
				g.setGexplain(rs.getString(idx++));
				g.setGusercom(rs.getDouble(idx++));
				g.setDlc(rs.getInt(idx++));
				g.setOri(rs.getInt(idx++));
				g.setRegdate(rs.getString(idx++));
				list.add(g);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
