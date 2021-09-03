/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.phong;
import POJO.thuePhong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class thuePhongDao {

    public static ArrayList<thuePhong> getDSPhong() {
        ArrayList<thuePhong> ds = new ArrayList<>();
        String sql = "select*from THUEPHONG";
        try {
            connectionDB.getCon();
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new thuePhong(rs.getString("MaThue").trim(), rs.getString("MaKH").trim(), rs.getString("MaPhong").trim(), rs.getDate("NgayVao"), rs.getDate("NgayRa"), rs.getFloat("tienThue")));

            }
            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();

        return ds;

    }

    public static int themNT(String MaThue, String maKhach, String maPhong, String ngayVao, String ngayRa, float tienThue) {

        int i = -1;
        String sql = "set dateFormat DMY; insert into THUEPHONG values(?,?,?,?,?,?)";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, MaThue);
            pre.setString(2, maKhach);
            pre.setString(3, maPhong);
            pre.setString(4, ngayVao);
            pre.setString(5, ngayRa);
            pre.setFloat(6, tienThue);

            i = pre.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trung ma", "Thong bao", 1);
        }
        connectionDB.close();
        return i;

    }

    public static int xoaNHSDDV(String sd) {
        int i = -1;
        String sql = "delete  THUEPHONG where maThue='" + sd + "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }

    public static int updateSD(String MaThue, String maKhach, String maPhong, String ngayVao, String ngayRa, float tienThue) {
        int i = -1;
        String sql = "set dateFormat DMY; update  THUEPHONG set maKH=?,maPhong=?,ngayVao=?,ngayRa=?,thanhTien=?  where maThue=?";
        try {

            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(6, MaThue);
            pre.setString(1, maKhach);
            pre.setString(2, maPhong);
            pre.setString(3, ngayVao);
            pre.setString(4, ngayRa);
            pre.setFloat(5, tienThue);

            i = pre.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }


}



