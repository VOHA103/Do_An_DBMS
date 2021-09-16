/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.loaiPhong;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import jdk.internal.org.objectweb.asm.tree.IntInsnNode;

/**
 *
 * @author thuha
 */
public class loaiPhongDao {

    public static ArrayList<loaiPhong> getDSLoai() {
        ArrayList<loaiPhong> ds = new ArrayList<>();
        String sql = "select *from LOAIPHONG";
        try {
            connectionDB.getCon();
            ResultSet rs = connectionDB.executeQuery(sql);
            while (rs.next()) {
                ds.add(new loaiPhong(rs.getString("MaLoai").toString().trim(), rs.getString("TenLoai").toString().trim()));

            }
//            System.out.println(ds);
        } catch (Exception e) {
        }
        connectionDB.close();
        return ds;

    }

    public static int thenLoaiPhong(String maLoai, String tenLoai) {
        String sql = "insert into LOAIPHONG values(?,?)";
        int i = -1;
        try {
            connectionDB.getCon();
            PreparedStatement pre = connectionDB.con.prepareStatement(sql);
            pre.setString(1, maLoai);
            pre.setString(2, tenLoai);
            i=pre.executeUpdate();
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Trung ma loai hoac ten loai","thong bao",1);
        }
        connectionDB.close();
        return i;

    }
     
//    public  static int xoaLoaiPhong(String ph){
//        int i=-1;
//        String  sql ="delete loaiPhong where MaLoai='"+ph+"'";
//        try {
//            connectionDB.getCon();
//          i=connectionDB.executeUpdate(sql);
//          
//            
//        } catch (Exception e) {
//        }
//        connectionDB.close();
//        return i;
//        
//    }
    public  static int updateLoaiP(String maLoai,String tenLoai){
        int i=-1;
        String sql="update LOAIPHONG set TenLoai=? where MaLoai=?";
        try {
            
            connectionDB.getCon();
            PreparedStatement pre =connectionDB.con.prepareStatement(sql);
            pre.setString(2,tenLoai);
            pre.setString(1,maLoai);
            i=pre.executeUpdate();
        } catch (Exception e) {
        }
        connectionDB.close();
        
        return i;
    }

}
