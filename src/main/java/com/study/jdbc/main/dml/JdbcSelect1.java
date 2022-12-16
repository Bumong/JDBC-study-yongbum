package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.study.jdbc.util.DBConnection;

public class JdbcSelect1 {

	public static void main(String[] args) {
		Connection connection = DBConnection.getInstance().getConnection();
		
		String sql = "select * from score_mst";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);   //query 입력하는 공간 쿼리를 들고있는거
			ResultSet rs = pstmt.executeQuery();						  //연결된 데이터베이스 쿼리 실행 iterator와 동일한 형태 한번쓰면 비어있음
			
			System.out.println("id\t name \t\t score");
			
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1) //() 숫자는 컬럼번호 1번부터 시작
				+ "\t name: " + rs.getString(2) 
				+ "\t score:" + rs.getInt(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
