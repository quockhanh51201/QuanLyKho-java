/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Administrator
 */
public class SQLServerDataProvider {
    private Connection connection;
    
    public void open(){

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QL_KhoSieuThi";
            String user = "sa";
            String pass = "123";
            connection = DriverManager.getConnection(dbURL, user, pass);
            if (connection != null) {
                System.out.println("Kết nối thành công đến SQL Server!");
            }
        } catch (SQLException ex) {
            System.out.println("Lỗi kết nối đến SQL Server!");
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            System.out.println("Không tìm thấy driver SQL Server!");
            ex.printStackTrace();
        }
    }
    
    public void close(){
        try {
            this.connection.close();
        } catch (Exception e) {
            e.getStackTrace();
        }  
    }
    
    public ResultSet executeQuery(String sql)
    {
        ResultSet rs = null;
        try {
            Statement sm = connection.createStatement();
            rs = sm.executeQuery(sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return rs;
    }
    
    public int executeUpdate(String sql)
    {
        int n = -1;
        try {
            Statement sm = connection.createStatement();
            n = sm.executeUpdate(sql);
        } catch (Exception e) {
            e.getStackTrace();
        }
        return n;
    }
}
