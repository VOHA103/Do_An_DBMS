
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.dichVu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class dichVuDao {

    public static ArrayList<dichVu> getDSDichVu() {
        ArrayList<dichVu> dshv = new ArrayList<>();

        try {
            connectionDB.getCon();
            String sql = "select *from DICHVU ";
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
               

              dshv.add(new dichVu(rs.getString("MaDV").trim(), rs.getString("TenDV").trim(), rs.getFloat("GiaDV")));
               
            }

        } catch (Exception e) {
        }
        connectionDB.close();
        return dshv;
    }


    public static int themDV(String maDV, String tenDV, float giaDV) {
        String sql = "insert into DICHVU  values(?,?,?)";
        int i = -1;
        try {
            connectionDB.getCon();

            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, maDV);
            pre.setString(2, tenDV);

            pre.setFloat(3, giaDV);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trung ma hoac ten  dich vu", "Thông báo", 1);
        }
        connectionDB.close();
        return i;
    }

    public static int xoaDV(String maKH) {
        int i = -1;
        String sql = "delete DICHVU where MaDV='" + maKH + "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }


    public static int updateDV(String maDV, String tenDV, float giaDV) {
        int i = -1;
        String sql = "update DICHVU set TenDV=?,GiaDV=? where MahDV=?";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(3, maDV);
            pre.setString(1, tenDV);
            pre.setFloat(2, giaDV);

            i = pre.executeUpdate();
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }
   
}
