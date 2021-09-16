
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import static DAO.connectionDB.con;
import POJO.dichVu;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
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
            CallableStatement sql = connectionDB.con.prepareCall("{call SP_DICHVU_HIENTHI()}");
            ResultSet rs = sql.executeQuery();
            while (rs.next()) {
                dshv.add(new dichVu(rs.getString(1).trim(), rs.getString(2).trim(), rs.getFloat(3)));
            }
        } catch (Exception e) {
        }
        connectionDB.close();
        return dshv;
    }

    public static int themDV(String maDV, String tenDV, float giaDV) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call SP_THEM1DICHVU(?,?,?)}");

            call.setString(1, maDV);
            call.setString(2, tenDV);
            call.setFloat(3, giaDV);
            i = call.executeUpdate();
            call.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);
            e.printStackTrace();
        }
        connectionDB.close();
        return i;
    }

    public static int xoaDV(String madv) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call sp_xoa_dv(?)}");
            call.setString(1, madv);

            i = call.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }

    public static int updateDV(String maDV, String tenDV, float giaDV) {
        int i = -1;
        try {
            connectionDB.getCon();
            CallableStatement call = connectionDB.con.prepareCall("{call sp_update_dv(?,?,?)}");
            call.setString(1, maDV);
            call.setString(2, tenDV);
            call.setFloat(3, giaDV);
            i = call.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Loi thu tuc", "Thông báo", 1);

        }
        connectionDB.close();
        return i;
    }

    //test consaction
    private static final String sql_them = "INSERT INTO DICHVU (MaDV, TenDV,GiaDV) VALUES (?,?,?)";
//     INSERT INTO DICHVU  Values ('DV07', N'Fitness centre', 10);

    private static final String sql_sua = "UPDATE DICHVU SET TenDV=?,GiaDV=? WHERE MaDV=?";

    public static void main(String[] args) throws SQLException {

        try {
            connectionDB.getCon();
            PreparedStatement insert = connectionDB.getCon().prepareStatement(sql_them);
            PreparedStatement update = connectionDB.getCon().prepareStatement(sql_sua);
            connectionDB.getCon().setAutoCommit(false);

            //them dic vu
            insert.setString(1, "DV010");
            insert.setString(2, "hhaha");
            insert.setFloat(3, 400);
            insert.execute();
            //them dich vu

            insert.setString(1, "DV011");
            insert.setString(2, "duyduyduy");
            insert.setFloat(3, 800);
            insert.execute();
            //sua dic vu
            insert.setString(1, "DV010");
            insert.setString(2, "hhaha11");
            insert.setFloat(3,6700);
            insert.execute();

            connectionDB.getCon().commit();
            
            String sql="select*from DICHVU";
            ResultSet rs=connectionDB.executeQuery(sql);
            System.out.println("Danh sach dich vu");
            System.out.println(rs);
            
            connectionDB.getCon().setAutoCommit(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
