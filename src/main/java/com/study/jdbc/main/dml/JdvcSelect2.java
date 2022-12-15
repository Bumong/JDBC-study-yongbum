package main.java.com.study.jdbc.main.dml;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import main.java.com.study.jdbc.util.DBConnection;

public class JdvcSelect2 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("작성자 id: ");
		int writer_id = scanner.nextInt();
		
		
		Connection connection = DBConnection.getInstance().getConnection();
		
		String sql = "select * from board_mst where writer_id = ?";
		
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, writer_id);                               //숫자는 몇번째 물음표인지 표시하는거
			ResultSet rs = pstmt.executeQuery();
			System.out.println("id \t title \t\t content\t\t read_count\t writer_id");
			
			while(rs.next()) {
				System.out.println("id: " + rs.getInt(1)
				+ "\t title: " + rs.getString(2)
				+ "\t content: " + rs.getString(3)
				+ "\t read_count: " + rs.getInt(4)
				+ "\t writer_id: " + rs.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
