/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.quanTri;
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
            String sql = "select *from QUANTRI";
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new quanTri(rs.getString("tentk").trim(), rs.getString("matkhau").trim()));
            }
            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();
        return ds;
    }

    public static int themQT(String tenDN, String gmail, String matKhau, String NLMatKhau) {
        int i = -1;
        String sql = "insert into  QUANTRI values(?,?)";
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, tenDN);
        
            pre.setString(2, matKhau);
      

            i = pre.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);
        }
        connectionDB.close();
        return i;
    }

    public static boolean dangNhap(String tentk, String matKhau) {
        for (quanTri qt : getDSQTri()) 
            if (qt.getTENTK().equals(tentk) && qt.getMATKHAU().equals(matKhau)) 
                return true;
       
        return false;
    }

}
