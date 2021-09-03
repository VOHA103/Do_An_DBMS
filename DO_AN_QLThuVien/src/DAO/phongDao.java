/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.phong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class phongDao {

    public static ArrayList<phong> getDSPhong() {
        ArrayList<phong> ds = new ArrayList<>();
        String sql = "select*from PHONG";
        try {
            connectionDB.getCon();
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new phong(rs.getString("MaPhong").trim(), rs.getString("TenPhong").trim(), rs.getString("MaLoai").trim(), rs.getInt("TinhTRang"), rs.getFloat("GiaPhong")));

            }
            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();

        return ds;

    }

    public static int themPhong(String maP, String tenP, String maLoai, int tingTrng, float giaP) {
        int i = -1;
        String sql = "insert into PHONG values(?,?,?,?,?)";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, maP);
            pre.setString(2, tenP);
            pre.setString(3, maLoai);
            pre.setInt(4, tingTrng);
            pre.setFloat(5, giaP);

            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trung ma hay ten phong", "Thong bao", 1);

        }
        connectionDB.close();

        return i;
    }

    public static int xoaPhong(String phong) {
        int i = -1;
        String sql = "delete PHONG where MaPhong='" + phong + "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }

    public static int update(String maP, String tenP, String maLoai, int tinhTrang, float giaP) {
        int i = -1;
        String sql = "update PHONG set TenPhong=?,MaLoai=?,TinhTrang=?,GiaPhong=? where MaPhong=?";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(5, maP);

            pre.setString(1, tenP);
            pre.setString(2, maLoai);
            pre.setInt(3, tinhTrang);
            pre.setFloat(4, giaP);
            i = pre.executeUpdate();
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }
}
