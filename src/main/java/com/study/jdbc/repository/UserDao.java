package main.java.com.study.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import lombok.RequiredArgsConstructor;
import main.java.com.study.jdbc.entity.User;
import main.java.com.study.jdbc.util.DBConnectionMgr;

//@RequiredArgsConstructor
public class UserDao {
	
//	private final DBConnectionMgr pool;
	
//	public UserDao(DBConnectionMgr pool) {
//		this.pool = pool;
//	}
	private DBConnectionMgr pool;
	
		
	public UserDao() {
		pool = DBConnectionMgr.getInstance();
	}

	public int insertUser(User user) {
		Connection con =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int successCount = 0;
		
		try {
			con = pool.getConnection();
			sql = "insert into user_mst values(0, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			successCount = pstmt.executeUpdate();
			
			rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				
				user.setUser_Id(rs.getInt(1));
				System.out.println(user);
			}
			
					
		} catch (Exception e) {
		
			e.printStackTrace();
		}finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return successCount;
		
	}
}
