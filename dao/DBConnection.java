package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DBConnection {
    private static String DB_URL = "jdbc:mysql://localhost:3306/qlsanpham"; 
    private static String USER_NAME = "root"; // Tên người dùng MySQL
    private static String PASSWORD = ""; // Mật khẩu MySQL
    public static Connection conn;
    
    public DBConnection() {
        try {            
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("Connect successfully!");
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Lỗi thiếu thư viện kết nối");
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối CSDL!");
        }
    }
    
    // Hàm thực hiện câu lệnh Select
    public static ResultSet GetData(String cauTruyVan) {
        try {
            Statement stm = conn.createStatement();           
            ResultSet rs = stm.executeQuery(cauTruyVan);
            
            return rs;
            
        } catch (SQLException ex) {
            System.out.println("Lỗi lấy dữ liệu");
            return null; 
        }
    }
    
    // Hàm thực hiện 3 lệnh Insert, Update, Delete
    public static int ExecuteTruyVan(String cauTruyVan) {
        try {
            Statement stm = conn.createStatement();
            int kq = stm.executeUpdate(cauTruyVan);
            return kq;
        } catch (SQLException ex) {
            System.out.println("Lỗi thực thi lệnh SQL");
            return -1;
        }        
    }
}
