/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.phongDao;
import DAO.suDungDVDao;
import DAO.thanhToanDao;
import MODEL.hoTRo;
import POJO.suDungDV;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thuha
 */
public class SDDICHVU extends javax.swing.JFrame {

    String tentk = "";
    DefaultTableModel modelTB;
    Vector tbTitle = new Vector();
    ArrayList<suDungDV> ds;

    public void loaddata() {
        ds = suDungDVDao.getDSSDDV();
        modelTB.setRowCount(0);
        for (suDungDV sdDV : ds) {
            Vector v = new Vector();
            v.add(sdDV.getMaSD());
            v.add(sdDV.getMaThueP());
            v.add(sdDV.getMaDV());
            v.add(sdDV.getSoLuong());
            v.add(sdDV.getTienSD());
            modelTB.addRow(v);

        }
    }

    /**
     * Creates new form SDDICHVU
     */
    public SDDICHVU() {
        initComponents();
        this.tentk = tentk;

        setLocationRelativeTo(null);
        tbTitle.add("Ma SD");
        tbTitle.add("Ma Thue");
        tbTitle.add("Ma Dv");
        tbTitle.add("So Luong");
        tbTitle.add("Tien SD");
        modelTB = new DefaultTableModel();
        modelTB.setColumnIdentifiers(tbTitle);
        tb_SUDUNGDV.setModel(modelTB);
        loaddata();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_sua = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_xoa = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        txt_masd = new javax.swing.JTextField();
        txt_mathue = new javax.swing.JTextField();
        txt_madv = new javax.swing.JTextField();
        txttiensd = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_SUDUNGDV = new javax.swing.JTable();
        sp_soluong = new javax.swing.JSpinner();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THÔNG TIN KH SD DICH VỤ");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 51));
        jLabel1.setText("THÔNG TIN SỬ DỤNG DỊCH VỤ CỦA KHÁCH");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("Mã SD:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("Mã Thuê:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("Mã DV:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("Số Lượng :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("Tiền SD:");

        btn_sua.setBackground(new java.awt.Color(255, 255, 204));
        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setText("SỬA");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_huy.setBackground(new java.awt.Color(255, 255, 255));
        btn_huy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_huy.setText("HỦY");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(204, 204, 255));
        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setText("THÊM");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_xoa.setBackground(new java.awt.Color(255, 204, 204));
        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setText("XÓA");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_thoat.setBackground(new java.awt.Color(204, 255, 204));
        btn_thoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_thoat.setForeground(new java.awt.Color(51, 51, 51));
        btn_thoat.setText("ĐÓNG");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        tb_SUDUNGDV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5"
            }
        ));
        tb_SUDUNGDV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_SUDUNGDVMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_SUDUNGDV);

        jScrollPane2.setViewportView(jScrollPane1);

        sp_soluong.setModel(new javax.swing.SpinnerNumberModel(0, 0, 10, 1));

        jButton6.setText("<<<MENU");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(47, 47, 47)
                        .addComponent(jLabel1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(btn_sua)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_huy)
                                        .addGap(54, 54, 54)))
                                .addGap(18, 18, 18))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(70, 70, 70)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_xoa)
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttiensd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_madv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_masd, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))))
            .addGroup(layout.createSequentialGroup()
                .addGap(212, 212, 212)
                .addComponent(btn_thoat)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_madv, txt_masd, txt_mathue, txttiensd});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_huy, btn_sua, btn_them, btn_thoat, btn_xoa});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(txt_masd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(txt_mathue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(txt_madv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addComponent(txttiensd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel3)
                                .addGap(67, 67, 67)
                                .addComponent(jLabel4))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(sp_soluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sua)
                            .addComponent(btn_huy))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btn_them, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btn_xoa)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(btn_thoat)
                .addGap(30, 30, 30))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btn_huy, btn_sua, btn_them, btn_thoat, btn_xoa});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        setVisible(false);
        new QL_NhanVien(tentk).setVisible(true);
        dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_btn_thoatActionPerformed
    public void reset() {
        txt_masd.setText("");
        txt_mathue.setText("");
        txt_madv.setText("");
        sp_soluong.getValue().equals("");
        txttiensd.setText("");
        txt_masd.requestFocus();

    }
    private void tb_SUDUNGDVMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_SUDUNGDVMouseReleased
        int row = tb_SUDUNGDV.getSelectedRow();
        if (row >= 0) {
            txt_masd.setText((String) (tb_SUDUNGDV.getValueAt(row, 0)));
            txt_mathue.setText((String) (tb_SUDUNGDV.getValueAt(row, 1)));
            txt_madv.setText((String) (tb_SUDUNGDV.getValueAt(row, 2)));
            sp_soluong.setValue((tb_SUDUNGDV.getValueAt(row, 3)));
            txttiensd.setText((tb_SUDUNGDV.getValueAt(row, 4).toString()));

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_tb_SUDUNGDVMouseReleased

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        reset();        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyActionPerformed
    boolean ktraMaDV(String maPH) {
        String ktra = "DV\\d+";
        if (maPH.matches(ktra)) {
            return true;
        }
        return false;
    }

    boolean ktraMaTh(String maPH) {
        String ktra = "MT\\d+";
        if (maPH.matches(ktra)) {
            return true;
        }
        return false;
    }

    boolean ktraMaSD(String maPH) {
        String ktra = "MSD\\d+";
        if (maPH.matches(ktra)) {
            return true;
        }
        return false;
    }
    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        int row = tb_SUDUNGDV.getSelectedRow();
        if (row >= 0) {

            if (hoTRo.checkRong(txt_masd) || hoTRo.checkRong(txt_mathue) || hoTRo.checkRong(txt_madv) || hoTRo.checkRong(txttiensd)) {
                return;

            }
            if (!ktraMaSD(txt_masd.getText())) {
                JOptionPane.showMessageDialog(this, "Ma su dung co dang MSDxx voi x la chu so", "Thong bao", 1);

                txt_masd.setText("");
                txt_masd.requestFocus();

                return;
            }
            if (!ktraMaDV(txt_madv.getText())) {
                JOptionPane.showMessageDialog(this, "Ma dich vu co dang DVxx voi x la chu so", "Thong bao", 1);

                txt_madv.setText("");
                txt_madv.requestFocus();

                return;
            }
            if (!ktraMaTh(txt_mathue.getText())) {
                JOptionPane.showMessageDialog(this, "Ma thue co dang MTxx voi x la chu so", "Thong bao", 1);

                txt_mathue.setText("");
                txt_mathue.requestFocus();

                return;
            }

            int i = suDungDVDao.updateSDDV(txt_masd.getText().trim(), txt_mathue.getText().trim(), txt_madv.getText().trim(), sp_soluong.getValue().hashCode(), Float.parseFloat(txttiensd.getText()));
            if (i != -1) {
                JOptionPane.showMessageDialog(null, "Sửa thành công", "Thông báo", 1);
                reset();
                loaddata();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed

        if (hoTRo.checkRong(txt_masd) || hoTRo.checkRong(txt_mathue) || hoTRo.checkRong(txt_madv) || hoTRo.checkRong(txttiensd)) {
            return;

        }
        if (!ktraMaSD(txt_masd.getText())) {
            JOptionPane.showMessageDialog(this, "Ma su dung co dang MSDxx voi x la chu so", "Thong bao", 1);

            txt_masd.setText("");
            txt_masd.requestFocus();

            return;
        }
        if (!ktraMaDV(txt_madv.getText())) {
            JOptionPane.showMessageDialog(this, "Ma dich vu co dang DVxx voi x la chu so", "Thong bao", 1);

            txt_madv.setText("");
            txt_madv.requestFocus();

            return;
        }
        if (!ktraMaTh(txt_mathue.getText())) {
            JOptionPane.showMessageDialog(this, "Ma thue co dang MTxx voi x la chu so", "Thong bao", 1);

            txt_mathue.setText("");
            txt_mathue.requestFocus();

            return;
        }

        if (JOptionPane.showConfirmDialog(this, "Ban co muon them khong", "Thong bao", 1) == JOptionPane.YES_NO_OPTION) {
            int i = suDungDVDao.themSDDV(txt_masd.getText().trim(), txt_mathue.getText().trim(), txt_madv.getText().trim(), sp_soluong.getValue().hashCode(), Float.parseFloat(txttiensd.getText()));

            if (i != -1) {
                JOptionPane.showMessageDialog(this, "Ban da them thanh cong", "Thong bao", 1);

                loaddata();
                reset();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed

        if (hoTRo.checkRong(txt_masd) || hoTRo.checkRong(txt_mathue) || hoTRo.checkRong(txt_madv) || hoTRo.checkRong(txttiensd)) {
            return;

        }
        int tb = tb_SUDUNGDV.getSelectedRow();
        if (tb >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Ban co muon xoa ", "Thong bao", 1) == JOptionPane.YES_OPTION) {
                int i = phongDao.xoaPhong(tb_SUDUNGDV.getValueAt(tb, 0).toString());
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Ban da xoa thanh cong", "Thong bao", 1);
                    loaddata();

                }
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_xoaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        setVisible(false);
        new QUANLY().setVisible(true);
        dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(SDDICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SDDICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SDDICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SDDICHVU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SDDICHVU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner sp_soluong;
    private javax.swing.JTable tb_SUDUNGDV;
    private javax.swing.JTextField txt_madv;
    private javax.swing.JTextField txt_masd;
    private javax.swing.JTextField txt_mathue;
    private javax.swing.JTextField txttiensd;
    // End of variables declaration//GEN-END:variables
}