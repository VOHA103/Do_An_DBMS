/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.nhanVien;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class nhanVienDao {

    public static ArrayList<nhanVien> getDSNVien() {
        ArrayList<nhanVien> ds = new ArrayList<>();
        String sql = "select*from NHANVIEN";
        try {
            connectionDB.getCon();
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {

                ds.add(new nhanVien(rs.getString("MaNV").trim(), rs.getString("MATKHAU").trim(), rs.getString("HoTen").trim(), rs.getString("GioiTinh").trim(), rs.getString("SoDT").trim(), rs.getDate("NgaySinh")));
            }
            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();
        return ds;
    }

    public static String timTenNVThaoMa(String manv) {
        for (nhanVien nv : getDSNVien()) {
            if (nv.getMaNV().toUpperCase().equals(manv.trim().toUpperCase())) {
                return nv.getHoTen();
            }
        }
        return "";
    }

    public static int themNHanVien(String maNV, String matKhau, String hoTen, String gioiTinh, String soDT, String ngaySinh) {

        int i = -1;
        String sql = "set dateFormat DMY;insert into NHANVIEN values(?,?,?,?,?,?)";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, maNV);
            pre.setString(2, matKhau);
            pre.setString(3, hoTen);
            pre.setString(4, gioiTinh);
            pre.setString(5, soDT);
            pre.setString(6, ngaySinh);

            i = pre.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thong bao", 1);
        }
        connectionDB.close();
        return i;

    }

    public static String dangNhap(String taikhoan, String matKhau) {
        for (nhanVien nv : getDSNVien()) {
            if (nv.getMaNV().equals(taikhoan) && nv.getMatkhau().equals(matKhau)) {
                return nv.getMaNV();
            }
        }
        return "";
    }

    public static int doiMatKhau(String manv, String matKhauMoi) {
        String sql = "update NHANVIEN set MATKHAU='" + matKhauMoi + "'where MaNV='" + manv + "'";
        System.out.println(sql);
        int i = -1;
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {

        }
        connectionDB.close();
        return i;
    }

    public static ArrayList<nhanVien> timtenNV(String tennv) {
        ArrayList<nhanVien> ds = new ArrayList<>();
        for (nhanVien hv : getDSNVien()) {
            if (hv.getHoTen().toLowerCase().contains(tennv.trim().toLowerCase())) {
                ds.add(hv);
            }
        }
        return ds;
    }

    public static int xoaNHVien(String nhv) {
        int i = -1;
        String sql = "delete NHANVIEN where MaNV='" + nhv + "'";
        System.out.println(sql);
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println("Lỗi");
        }
        connectionDB.close();
        return i;
    }

    public static int updateNV(String maNV, String hoTen, String gioiTinh, String ngaySinh, String soDT) {
        int i = -1;
        String sql = "set dateFormat DMY;update NHANVIEN set HoTen=?,GioiTinh=?,NgaySinh=?,SoDT=? where MaNV=?";
        try {

            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(5, maNV);

            pre.setString(1, hoTen);
            pre.setString(2, gioiTinh);
            pre.setString(3, ngaySinh);
            pre.setString(4, soDT);
            i = pre.executeUpdate();

        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }

    public static int resetPW(String maNV, String matKhau) {
        int i = -1;
        String sql = "update NHANVIEN set MATKHAU='" + matKhau + "'where MaNV='" + matKhau + "'";
        try {
            connectionDB.getCon();
            i = connectionDB.executeUpdate(sql);
        } catch (Exception e) {
        }
        connectionDB.close();
        return i;
    }
}
