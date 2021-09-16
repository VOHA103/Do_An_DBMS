/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.dichVu;
import POJO.quanTri;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class quanTriDao {

    public static ArrayList<quanTri> getDSQTri() {
        ArrayList<quanTri> ds = new ArrayList<>();
        try {
            connectionDB.getCon();
            CallableStatement sql = connectionDB.con.prepareCall("{call SP_QUANTRI_HIENTHI()}");
//cursor :CS_QUANTRI1()
///proc SP_QUANTRI_HIENTHI(do9c du lieu
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                ds.add(new quanTri(rs.getInt(1), rs.getString(2).trim(), rs.getString(3).trim()));
            }
            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();
        return ds;
    }

    //  ------dung thu tuc de dang ky
    public static int themQuanTri(String ten, String makhau) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call SP_THEM1QUANTRI(?,?)}");
            call.setString(1, ten);
            call.setString(2, makhau);
            i = call.executeUpdate();
            call.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);
        }
        connectionDB.close();
        return i;
    }

    public static int xoaTK(String matk) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call sp_xoa1QUANTRI(?)}");
            call.setString(1, matk);
            i = call.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }

    public static int themTK(String ten, String mk) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call SP_THEM1QUANTRI(?,?)}");
            call.setString(1, ten);
            call.setString(2, mk);

            i = call.executeUpdate();
            call.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);
            e.printStackTrace();
        }
        connectionDB.close();
        return i;
    }

    public static int updateDV(String ten, String mk) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call sp_sua1QTri(?,?)}");
            call.setString(1, ten);
            call.setString(2, mk);
            i = call.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }

    public static boolean dangNhap(String tentk, String matKhau) {
//        System.out.println("chao moi nguoi");
        for (quanTri qt : getDSQTri()) {
            if (qt.getTENTK().equals(tentk) && qt.getMATKHAU().equals(matKhau)) {
                return true;
            }
        }

        return false;
    }

}
