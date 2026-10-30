package com.ssafy.exam.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ssafy.exam.model.dto.Member;
import com.ssafy.exam.util.DBUtil;
import com.ssafy.exam.model.dto.Car;

/*
 * 초기 정보 파일 입출력 관련 처리는 완성된 형태로 제공된다.*/
/* 싱글톤 형태로 완성되어 제공 됨*/
public class CarDaoImpl implements CarDao {
	private static final CarDaoImpl instance = new CarDaoImpl();
	
	private CarDaoImpl() {
			
	}
	
	
	
	public static CarDaoImpl getInstance() {
		return instance;
	}

	
	
	///////////////////////////////////////////////////////
	//------아래 메소드를 확인하고 코드를 완성하세요.---------------//
	///////////////////////////////////////////////////////
	/// 
	@Override
	public Member login(String email, String password) {
		Member member = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT mno, name, email, password, role FROM member WHERE email = ? AND password = ?";

		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, password);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				member = new Member(
					rs.getInt("mno"),
					rs.getString("name"),
					rs.getString("email"),
					rs.getString("password"),
					rs.getString("role")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, pstmt, conn);
		}

		return member;
	}

	@Override
	public List<Car> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(Car car) {
		// TODO Auto-generated method stub
		return 0;
	}





}
