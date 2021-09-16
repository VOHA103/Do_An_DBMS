/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.phong;
import POJO.thanhToan;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class thanhToanDao {
        public  static  ArrayList<thanhToan> getdsTT(){
        ArrayList<thanhToan> ds=new ArrayList<>();
        String sql ="select*from THANHTOAN";
        try {
            connectionDB.getCon();
            ResultSet rs =connectionDB.executeQuery(sql);
            while(rs.next()){
                ds.add(new thanhToan(rs.getString("MaThue").trim(),rs.getDate("NgayTToan"),rs.getFloat("ThanhTien")));
                
            }
            System.out.println(ds);
        } catch (Exception e) {
        }
 connectionDB.close();
           
        
        
        return ds;
        
    }
        
        public static int themNT(String MaThue,float ThanhTien, String NgayTToan ) {

        int i = -1;
        String sql = "set dateFormat DMY; insert into THANHTOAN values(?,?,?)";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, MaThue);
            pre.setFloat(2, ThanhTien);
            pre.setString(3, NgayTToan);
      

            i = pre.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trung ma", "Thong bao", 1);
        }
        connectionDB.close();
        return i;

    }
public static int updateSD(String MaThue, float ThanhTien, String NgayTToan) {
        int i = -1;
        String sql = "set dateFormat DMY; update  THANHTOAN set ThanhTien=?,NgayTToan=? where MaThue=?";
        try {

            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(3, MaThue);
            pre.setFloat(1, ThanhTien);
            pre.setString(2, NgayTToan);
         

            i = pre.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }
    public static int xoaTT(String tt) {
        int i = -1;
        String sql = "delete THANHTOAN where MaThue='" + tt+ "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }
}
