/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.connectionDB;
import DAO.dichVuDao;
import DAO.khachHangDao;
import MODEL.hoTRo;
import POJO.dichVu;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sun.misc.Cleaner;

/**
 *
 * @author thuha
 */
public class DICHVU extends javax.swing.JFrame {

    String tentk = "";

    DefaultTableModel modelTB;
    Vector tblTitle = new Vector();
    ArrayList<dichVu> ds;

    public void loaddulieu() {
        ds = dichVuDao.getDSDichVu();
        modelTB.setRowCount(0);
        for (dichVu dv : ds) {
            Vector v = new Vector();
            v.add(dv.getMaDV());
            v.add(dv.getTenDV());
            v.add(dv.getGiaDV());
            modelTB.addRow(v);
        }
    }

    /**
     * Creates new form DICHVU
     */
    public DICHVU() {

        initComponents();
        setLocationRelativeTo(null);
        this.tentk = tentk;

        tblTitle.add("MÃ DỊCH VỤ");
        tblTitle.add("TÊN DỊCH VỤ ");
        tblTitle.add("GIÁ DỊCH VỤ ");

        modelTB = new DefaultTableModel();
        modelTB.setColumnIdentifiers(tblTitle);
        tb_dichvu.setModel(modelTB);
        loaddulieu();

    }

    public void reset() {
        txt_madv.setText("");
        txt_tendv.setText("");
        txt_giadv.setText("");
        txt_madv.requestFocus();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tb_dichvu = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_madv = new javax.swing.JTextField();
        txt_tendv = new javax.swing.JTextField();
        txt_giadv = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THÔNG TIN DỊCH VỤ");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseReleased(evt);
            }
        });

        tb_dichvu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tb_dichvu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tb_dichvuMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_dichvuMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_dichvu);

        jLabel1.setDisplayedMnemonic('T');
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 0, 0));
        jLabel1.setText("THÔNG TIN DỊCH VỤ ");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Mã DV:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Tên DV:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Giá DV:");

        txt_madv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_madvActionPerformed(evt);
            }
        });

        jSeparator1.setForeground(new java.awt.Color(0, 0, 153));

        btn_them.setBackground(new java.awt.Color(255, 204, 204));
        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setForeground(new java.awt.Color(102, 102, 0));
        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Login-icon-16.png"))); // NOI18N
        btn_them.setText("THÊM");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(255, 204, 204));
        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(102, 102, 0));
        btn_xoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Actions-edit-delete-icon-16.png"))); // NOI18N
        btn_xoa.setText("XÓA");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_thoat.setBackground(new java.awt.Color(255, 204, 204));
        btn_thoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_thoat.setForeground(new java.awt.Color(102, 102, 0));
        btn_thoat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/logout-icon-16.png"))); // NOI18N
        btn_thoat.setText("ĐÓNG");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        btn_huy.setBackground(new java.awt.Color(255, 204, 204));
        btn_huy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_huy.setForeground(new java.awt.Color(102, 102, 0));
        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new-icon-16.png"))); // NOI18N
        btn_huy.setText("HỦY");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        jButton1.setText("MENU>>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(255, 204, 204));
        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(102, 102, 0));
        btn_sua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/new-icon-16.png"))); // NOI18N
        btn_sua.setText("SỬA");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton2.setText("TranSacTion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(29, 29, 29)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txt_tendv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt_giadv)
                                            .addComponent(txt_madv, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(btn_them, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_xoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_huy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_sua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_thoat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_giadv, txt_madv, txt_tendv});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_huy, btn_them, btn_thoat, btn_xoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_madv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_them))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txt_tendv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_giadv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_xoa)))
                        .addGap(1, 1, 1)
                        .addComponent(btn_sua)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_huy)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_thoat)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(43, 43, 43))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_giadv, txt_madv, txt_tendv});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_madvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_madvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_madvActionPerformed

    private void jScrollPane1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseReleased

// TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseReleased

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed

        setVisible(false);
        new QL_NhanVien(tentk).setVisible(true);
        dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed

        reset();

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyActionPerformed

    private void tb_dichvuMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dichvuMouseReleased

        int row = tb_dichvu.getSelectedRow();
        if (row >= 0) {
            txt_madv.setText((String) (tb_dichvu.getValueAt(row, 0)));
            txt_tendv.setText((String) (tb_dichvu.getValueAt(row, 1)));
            txt_giadv.setText((tb_dichvu.getValueAt(row, 2).toString()));

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_dichvuMouseReleased

    private void tb_dichvuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dichvuMousePressed

// TODO add your handling code here:
    }//GEN-LAST:event_tb_dichvuMousePressed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed

        if (hoTRo.checkRong(txt_madv) || hoTRo.checkRong(txt_tendv) || hoTRo.checkRong(txt_giadv)) {
            return;
        }
        int tb = tb_dichvu.getSelectedRow();
        if (tb >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Ban co muon xoa khong", "Thong bao", 1) == JOptionPane.YES_OPTION) {
                int i = dichVuDao.xoaDV(txt_madv.getText());

                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Ban da xoa thanh cong", "Thong bao", 1);
                    loaddulieu();
                    reset();
                }
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaActionPerformed
    boolean ktraMaKH(String maPH) {
        String ktra = "DV\\d+";
        if (maPH.matches(ktra)) {
            return true;
        }
        return false;
    }
    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        if (hoTRo.checkRong(txt_madv) || hoTRo.checkRong(txt_tendv) || hoTRo.checkRong(txt_giadv)) {
            return;
        }
        if (!ktraMaKH(txt_madv.getText())) {
            JOptionPane.showMessageDialog(this, "Ma khach co dang DVxx voi x la chu so", "Thong bao", 1);

            txt_madv.setText("");
            txt_madv.requestFocus();

            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Ban co muon them khong", "Thong bao", 1) == JOptionPane.YES_NO_OPTION) {
            int i = dichVuDao.themDV(txt_madv.getText(), txt_tendv.getText(), Float.parseFloat(txt_giadv.getText()));
            if (i != -1) {
                JOptionPane.showMessageDialog(this, "Ban da them thanh cong", "Thong bao", 1);

                loaddulieu();
                reset();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new QL_NhanVien(tentk).setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed

        int row = tb_dichvu.getSelectedRow();
        if (row >= 0) {
            if (hoTRo.checkRong(txt_madv) || hoTRo.checkRong(txt_tendv) || hoTRo.checkRong(txt_giadv)) {
                return;
            }
            if (!ktraMaKH(txt_madv.getText())) {
                JOptionPane.showMessageDialog(this, "Ma khach co dang DVxx voi x la chu so", "Thong bao", 1);

                txt_madv.setText("");
                txt_madv.requestFocus();

                return;
            }

            if (JOptionPane.showConfirmDialog(null, "Bạn muốn sửa  khong", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {
                int i = dichVuDao.updateDV(txt_madv.getText(), txt_tendv.getText(), Float.parseFloat(txt_giadv.getText()));
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Đã sửa thanh cong", "Thông báo", 1);

                    loaddulieu();
                    reset();
                }
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        connectionDB con = null;
        String ma = txt_madv.getText();
        String ten = txt_tendv.getText();
        String gia = txt_giadv.getText();
        PreparedStatement pst;
        PreparedStatement pst1;
        int i = -1;
        try {
            Statement st1 = connectionDB.getCon().createStatement();
            connectionDB.getCon().setAutoCommit(false);
//update 1
            CallableStatement sql_1 = connectionDB.getCon().prepareCall("{call sp_update_dv1(?,?)}");
            sql_1.setString(1, ten);
            sql_1.setString(2, gia);
          sql_1.execute();

//update 2
            CallableStatement sql_2 = connectionDB.getCon().prepareCall("{call sp_update_dv1(?,?)}");
            sql_2.setString(1, ten);
            sql_2.setString(2, gia);
           i= sql_2.executeUpdate();

// //insert 
//            CallableStatement call = connectionDB.getCon().prepareCall("{call SP_THEM1DICHVU(?,?,?)}");
//
//            call.setString(1, ma);
//            call.setString(2, ten);
//            call.setString(3, gia);
//            call.executeUpdate();

            ResultSet rs = null;
            rs.next();
            if (rs.getFloat(1) < 0) {
                connectionDB.getCon().rollback();
                JOptionPane.showMessageDialog(this, "Transaction khong thanh cong");
            } else {
                connectionDB.getCon().commit();
                JOptionPane.showMessageDialog(this, "Transaction thanh cong");
            }
            Cleaner();

            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(DICHVU.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DICHVU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tb_dichvu;
    private javax.swing.JTextField txt_giadv;
    private javax.swing.JTextField txt_madv;
    private javax.swing.JTextField txt_tendv;
    // End of variables declaration//GEN-END:variables

    private void Cleaner() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}