package main.java.com.study.jdbc.main.dml;

import main.java.com.study.jdbc.util.DBConnection2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        Connection con = DBConnection2.getInstance().getConnection();

        String sql = "select * from study_mst";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                System.out.println("id: " + rs.getInt(1)
                + "\t name: " + rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
