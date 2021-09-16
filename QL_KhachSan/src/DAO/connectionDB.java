/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author thuha
 */
public class connectionDB {

   static Connection con;

    public static Connection getCon() {
        
        try {
            String url = "jdbc:sqlserver://localhost:1433;databaseName=QL_KHACHSAN";
            String user = "sa";
            String pass = "1003";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(url, user, pass);
            
            System.out.println("Ket noi csdl thanh cong");

        } catch (Exception e) {
            System.out.println("Ket noi csdl not  thanh cong");

        }

        return con;
    }

   
    
    
    

    public static void close() {
        try {
            con.close();
        } catch (Exception e) {
        }
    }

    public static ResultSet executeQuery(String sql) {
        ResultSet rs = null;
        try {
            Statement stm = con.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
        }

        return rs;

    }

    public static int executeUpdate(String sql) {
        int i = -1;

        try {
            Statement stm = con.createStatement();
            i = stm.executeUpdate(sql);
        } catch (Exception e) {
        }
        return i;

    }

    static int executeUpdate(CallableStatement call) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



 

  
  
  
    


   
}
