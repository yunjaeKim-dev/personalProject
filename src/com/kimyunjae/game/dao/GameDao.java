package com.kimyunjae.game.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.print.attribute.ResolutionSyntax;

import com.kimyunjae.game.vo.Game;
import com.kimyunjae.member.vo.Member;
import com.kimyunjae.util.common.DBConn;

public class GameDao {

	public boolean add() {
		return false;
	}

	public Game getGame(int gno) {
		Game game = new Game();
		String sql ="SELECT GNO, GNAME, PRICE, DISCOUNT,IMGPATH, GOUTLINE, GEXPLAIN, GUSERCOM, TO_CHAR(REGDATE,'YYYY-MM-DD'), DLC, ORI, CATEGORY FROM GAME WHERE GNO = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx = 1;
				game.setGno(rs.getInt(idx++));
				game.setGname(rs.getString(idx++));
				game.setPrice(rs.getInt(idx++));
				game.setDiscount(rs.getDouble(idx++));
				game.setImgpath(rs.getString(idx++));
				game.setGoutline(rs.getString(idx++));
				game.setGexplain(rs.getString(idx++));
				game.setGusercom(rs.getDouble(idx++));
				game.setRegdate(rs.getString(idx++));
				game.setDlc(rs.getInt(idx++));
				game.setOri(rs.getInt(idx++));
				game.setCategory(rs.getString(idx++));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return game;
	}

	public List<Game> getGames(String gamecategory,String keyword){
		List<Game> list = new ArrayList<>();
		String sql = "SELECT GNO, GNAME, PRICE, CATEGORY, IMGPATH, DISCOUNT \r\n" + 
				"FROM GAME \r\n" + 
				"WHERE 1 = 1 \r\n";
		if(gamecategory != null && !gamecategory.trim().equals("0")) {
			sql += "AND CATEGORY = " + gamecategory.trim() +  " \r\n";
		}
		if(keyword != null) {
			keyword = "'%"+keyword.trim()+"%'";
			sql += "AND GNAME LIKE " + keyword;
		}
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Game game = new Game();
				int idx = 1;
				game.setGno(rs.getInt(idx++));
				game.setGname(rs.getString(idx++));
				game.setPrice(rs.getInt(idx++));
				game.setCategory(rs.getString(idx++));
				game.setImgpath(rs.getString(idx++));
				game.setDiscount(rs.getDouble(idx++));
				list.add(game);
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean buy(int gno,Member member) {
		boolean retVal = false;
		String sql = "INSERT INTO KEY(KNO, GNO, EMAIL) VALUES (KEY_SEQ.NEXTVAL, ? , ?)";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, gno);
			pstmt.setString(2, member.getEmail());
			retVal = pstmt.executeUpdate() != 0;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retVal;
	}
	
	public boolean modify(Game vo) {
		return false;
	}

	public boolean remvoe(int gno) {
		return false;
	}
	
	public List<Game> getGamesByEmail(Member vo){
		List<Game> list = new ArrayList<>();
		String sql = "SELECT G.GNO, TO_CHAR(G.REGDATE,'YYYY-MM-DD'), G.GNAME, G.PRICE, G.DISCOUNT, G.IMGPATH, G.CATEGORY, G.GOUTLINE, G.GEXPLAIN, G.GUSERCOM, G.DLC, G.ORI\r\n" + 
				"FROM KEY K\r\n" + 
				"JOIN GAME G\r\n" + 
				"ON K.GNO = G.GNO\r\n" + 
				"WHERE K.EMAIL = ?";
		Connection conn = DBConn.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEmail());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				int idx= 1;
				Game game = new Game();
				game.setGno(rs.getInt(idx++));
				game.setRegdate(rs.getString(idx++));
				game.setGname(rs.getString(idx++));
				game.setPrice(rs.getInt(idx++));
				game.setDiscount(rs.getDouble(idx++));
				game.setImgpath(rs.getString(idx++));
				game.setCategory(rs.getString(idx++));
				game.setGoutline(rs.getString(idx++));
				game.setGexplain(rs.getString(idx++));
				game.setGusercom(rs.getDouble(idx++));
				game.setOri(rs.getInt(idx++));
				game.setDlc(rs.getInt(idx++));
				list.add(game);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
}
