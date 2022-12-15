package main.java.com.study.jdbc.main.dml;

import main.java.com.study.jdbc.util.DBConnection2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("삭제할 계정의 id값을 입력하세요: ");
        int id = scanner.nextInt();


        Connection con = DBConnection2.getInstance().getConnection();
        String sql = "delete from study_mst where id = ?";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            int successCount = pstmt.executeUpdate();
            System.out.println(successCount + "건 삭제완료!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
