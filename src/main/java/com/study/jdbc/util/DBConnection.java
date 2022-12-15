package main.java.com.study.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DBConnection {
	private static DBConnection instance = null;
	
	private DBConnection () {}
	
	public static DBConnection getInstance() {
		if (instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	public Connection getConnection() {
		Connection connection = null;
		String url = null;
		String username = null;
		String password = null;
		
		try {
			Class.forName(Driver.class.getName());  //Class.forName 객체 생성
			System.out.println("데이터베이스 드라이버 로딩 성공!");
			url = "jdbc:mysql://localhost:3306/subquery_study";  //jdbc:mysql:을 프로토콜하고 localhost 로 서버를 설정하고 my sql 데이터베이스 불러옴
			username = "root";
			password = "root";
			
			connection = DriverManager.getConnection(url, username, password);
			
		} catch (ClassNotFoundException e) {     //ClassNotFoundException 경로가 없을경우 실패
			e.printStackTrace();
			System.out.println("드라이버 로딩 실패!");
		} catch (SQLException e) {               //SQLException 연결되지 않았을 때
			e.printStackTrace();
			System.out.println("데이터베이스 연결 실패!");
		}
		return connection;
	}
	
	
	

}
