/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.suDungDV;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class suDungDVDao {
   public static  ArrayList<suDungDV> getDSSDDV(){
       ArrayList<suDungDV> ds=new ArrayList<>();
       String sql ="select *from SDDICHVU";
       try {
           connectionDB.getCon();
           ResultSet rs =connectionDB.executeQuery(sql);
          while(rs.next()){
              ds.add(new suDungDV(rs.getString("MaSD").trim(),rs.getString("MaThue").trim(),rs.getString("MaDV").trim(),rs.getInt("SoLuong"), rs.getFloat("TienSD")));
          }
           System.out.println(ds);
       } catch (Exception e) {
       }
       connectionDB.close();
       return ds;
   }
     public static int themSDDV(String masd, String mathue, String madv, int soluong, float tiensud) {
        int i = -1;
        String sql = "insert into SDDICHVU values(?,?,?,?,?)";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, masd);
            pre.setString(2, mathue);
            pre.setString(3, madv);
            pre.setInt(4, soluong);
            pre.setFloat(5, tiensud);

            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trung ma ", "Thong bao", 1);

        }
        connectionDB.close();

        return i;
    }

    public static int xoaSDDV(String sddv) {
        int i = -1;
        String sql = "delete SDDICHVU where MaSD='" + sddv + "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }

    public static int updateSDDV(String masd, String mathue, String madv, int soluong, float tiensud) {
        int i = -1;
        String sql = "update SDDICHVU set MaThue=?,MaDV=?,SoLuong=?,TienSD=? where MaSD=?";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(5, masd);

            pre.setString(1,mathue);
            pre.setString(2, madv);
            pre.setInt(3, soluong);
            pre.setFloat(4, tiensud);
            i = pre.executeUpdate();
        } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }
    
}
