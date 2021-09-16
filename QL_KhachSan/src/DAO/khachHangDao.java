/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.dichVu;
import POJO.khachHang;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class khachHangDao {

    public static ArrayList<khachHang> getDSKHang() {
        ArrayList<khachHang> ds = new ArrayList();
        try {
            connectionDB.getCon();
            CallableStatement sql = connectionDB.con.prepareCall("{call SP_KHACHHANG_HIENTHI()}");

            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                ds.add(new khachHang(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(), rs.getString(4).trim(), rs.getString(5).trim()));

            }
        } catch (Exception e) {
        }
        connectionDB.close();
        return ds;

    }

    public static String demSL_Khach() {
        int dem=0;
        try {
            connectionDB.getCon();
            CallableStatement st = connectionDB.con.prepareCall("{?=call FC_COUNT_KH()}");
           st.registerOutParameter(1, Types.INTEGER);
            st.execute();
            dem=st.getInt(1);
            connectionDB.close();
        } catch (SQLException e) {
            
        }
        return String.valueOf(dem);
    }

    public static int themKH(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement sql = connectionDB.con.prepareCall("{call sp_them1khachhang(?,?,?,?,?)}");
            sql.setString(1, maKH);
            sql.setString(2, tenKH);
            sql.setString(3, gioiTinh);
            sql.setString(4, diaChi);
            sql.setString(5, soDT);
            i = sql.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);
        }
        connectionDB.close();
        return i;
    }

    public static int xoaKH(String maKH) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement sql = connectionDB.con.prepareCall("{call sp_xoa1khachhang(?)}");
            sql.setString(1, maKH);

            i = sql.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }

    public static int updateKH(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement sql = connectionDB.con.prepareCall("{call sp_sua1khachhang(?,?,?,?,?)}");

            sql.setString(1, maKH);
            sql.setString(2, tenKH);
            sql.setString(3, gioiTinh);
            sql.setString(4, diaChi);
            sql.setString(5, soDT);
            i = sql.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
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

    public static ArrayList<khachHang> timMa_KhachHang(String makh) {
        ArrayList<khachHang> ds = new ArrayList<>();
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call SP_tim_MaKH(?)}");
            ResultSet rs = call.executeQuery();
            while (rs.next()) {
                ds.add(new khachHang(rs.getString(1).trim(), rs.getString(2).trim(), rs.getString(3).trim(),
                        rs.getString(4).trim(), rs.getString(5).trim()));
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
    public ArrayList<khachHang> get;
}
