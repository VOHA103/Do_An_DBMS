/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.khachHang;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class khachHangDao {

    public static ArrayList<khachHang> getDSKHang() {
        ArrayList<khachHang> ds = new ArrayList();
        String sql = "select *from KHACHHANG";
        try {
            connectionDB.getCon();
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new khachHang(rs.getString("MaKH").trim(), rs.getString("TenKH").trim(), rs.getString("GioiTinh").trim(), rs.getString("DiaChi").trim(), rs.getString("SoDT").trim()));
//                System.out.println("jihih");

            }

//            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();
        return ds;
    }

    public static khachHang timTheoMa(String mahv) {
        for (khachHang hv : getDSKHang()) {
            if (hv.getMaKH().toLowerCase().equals(mahv.trim().toLowerCase())) {
                return hv;
            }
        }
        return null;
    }

    public static ArrayList<khachHang> timTheoTen(String tenhv) {
        ArrayList<khachHang> ds1 = new ArrayList<>();
        for (khachHang hv : getDSKHang()) {
            if (hv.getTenKH().toLowerCase().contains(tenhv.trim().toLowerCase())) {
                ds1.add(hv);
            }
        }
        return ds1;
    }

    public static int themKH(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT) {
        String sql = "insert  into KHACHHANG values(?,?,?,?,?)";
        int i = -1;
        try {
            connectionDB.getCon();

            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, maKH);
            pre.setString(2, tenKH);
            pre.setString(3, gioiTinh);
            pre.setString(4, diaChi);
            pre.setString(5, soDT);
            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Trung ma khach hang", "Thông báo", 1);
        }
        connectionDB.close();
        return i;
    }

    public static int xoaKH(String maKH) {
        int i = -1;
        String sql = "delete KHACHHANG where MaKh='" + maKH + "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }

    public static int updateKH(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT) {
        int i = -1;
        String sql = "update KHACHHANG set TenKH=?,GioiTinh=?,DiaChi=?,SoDT=? where MaKH=?";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(5, maKH);
            pre.setString(1, tenKH);
            pre.setString(2, gioiTinh);
            pre.setString(3, diaChi);
            pre.setString(4, soDT);
            i = pre.executeUpdate();
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }

    public static ArrayList<khachHang> timB(String MaSP) {
        ArrayList<khachHang> ds = new ArrayList<>();
        try {
            String sql = "select*from KHACHHANG where MaKH  like'" + MaSP + "'";
            connectionDB.getCon();
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new khachHang(rs.getString("MaKH").trim(), rs.getString("TenKH").trim(), rs.getString("GioiTinh").trim(), rs.getString("DiaChi").trim(), rs.getString("SoDT").trim()));
            }
            connectionDB.close();
        } catch (Exception e) {
        }
        return ds;

    }

    public static String timTen(String sl) {
        String value = "";
        for (khachHang b : getDSKHang()) {
            if (b.getMaKH().trim().toLowerCase().equals(sl.trim().toLowerCase())) {
                value = b.getTenKH();
                break;
            }
        }
        return value;
    }

    public static String timGTinh(String HT) {
        String value = "";
        for (khachHang b : getDSKHang()) {
            if (b.getMaKH().trim().toLowerCase().equals(HT.trim().toLowerCase())) {
                value = b.getGioiTinh();
                break;
            }
        }
        return value;
    }

    public static String timDiaChi(String QL) {
        String value = "";
        for (khachHang b : getDSKHang()) {
            if (b.getMaKH().trim().toLowerCase().equals(QL.trim().toLowerCase())) {
                value = b.getDiaChi();
                break;
            }
        }
        return value;
    }

    public static String timSDT(String QL) {
        String value = "";
        for (khachHang b : getDSKHang()) {
            if (b.getMaKH().trim().toLowerCase().equals(QL.trim().toLowerCase())) {
                value = b.getSoDT();
                break;
            }
        }
        return value;
    }
}
