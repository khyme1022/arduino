package com.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectDB {
    private static ConnectDB instance = new ConnectDB();

    public static ConnectDB getInstance() {
        return instance;
    }
    public ConnectDB() {  }

    // oracle 계정
    String jdbcUrl = "jdbc:oracle:thin:@175.202.237.63:1521:xe";
    String userId = "scott";
    String userPw = "tiger";

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "";
    String returns = "dd";

    public String connectionDB(String id, String pwd) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl, userId, userPw);
            sql = "INSERT INTO ArduinoDB VALUES(?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, pwd);
            pstmt.executeUpdate();
            returns = "입력 성공";
			rs.close();
			pstmt.close();
			conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returns;
    }
}