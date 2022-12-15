package main.java.com.study.jdbc.main.dml;

import main.java.com.study.jdbc.util.DBConnection2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("등록할 아이디 입력: ");
        String username = scanner.nextLine();

        Connection con = DBConnection2.getInstance().getConnection();
        String sql = "insert into study_mst values(0, ?)";
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, username);
            int successCount = pstmt.executeUpdate();
            System.out.println("데이터" + successCount + "건 등록완료!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
