/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.nhanVienDao;
import MODEL.hoTRo;
import javax.swing.JOptionPane;

/**
 *
 * @author thuha
 */
public class QL_NhanVien extends javax.swing.JFrame {

    String tentk = "";

    /**
     * Creates new form QL_NhanVien
     */
    public QL_NhanVien(String tentk) {
        initComponents();
        this.tentk = tentk;
        hoTRo.clock(lb_cloack);
        setLocationRelativeTo(null);
       
        lbXinChao.setText("Xin Chao:"+lbXinChao.getText()+ nhanVienDao.timTenNVThaoMa(tentk));
    }

    private QL_NhanVien() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_ttdichvu1 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btn_ttdichvu = new javax.swing.JButton();
        btn_ttthanhtoan = new javax.swing.JButton();
        btn_ttthuephong = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbXinChao = new javax.swing.JLabel();
        lb_cloack = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QL_NhanVien");

        btn_ttdichvu1.setBackground(new java.awt.Color(255, 255, 0));
        btn_ttdichvu1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_ttdichvu1.setForeground(new java.awt.Color(153, 0, 0));
        btn_ttdichvu1.setText("QL_KHACHHANG");
        btn_ttdichvu1.setToolTipText("Khách Hàng");
        btn_ttdichvu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttdichvu1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(153, 0, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/Login-icon-16.png"))); // NOI18N
        jButton1.setText("ĐĂNG XUẤT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_ttdichvu.setBackground(new java.awt.Color(0, 102, 102));
        btn_ttdichvu.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_ttdichvu.setForeground(new java.awt.Color(255, 204, 255));
        btn_ttdichvu.setText("TT_DICHVU");
        btn_ttdichvu.setToolTipText("Dịch Vụ");
        btn_ttdichvu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttdichvuActionPerformed(evt);
            }
        });

        btn_ttthanhtoan.setBackground(new java.awt.Color(102, 0, 0));
        btn_ttthanhtoan.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_ttthanhtoan.setForeground(new java.awt.Color(255, 255, 204));
        btn_ttthanhtoan.setText("TT_THANHTOAN");
        btn_ttthanhtoan.setToolTipText("Thanh Toán");
        btn_ttthanhtoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttthanhtoanActionPerformed(evt);
            }
        });

        btn_ttthuephong.setBackground(new java.awt.Color(0, 0, 51));
        btn_ttthuephong.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btn_ttthuephong.setForeground(new java.awt.Color(255, 255, 255));
        btn_ttthuephong.setText("TT_THUEPHONG");
        btn_ttthuephong.setToolTipText("Thuê Phòng");
        btn_ttthuephong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ttthuephongActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(102, 0, 0));
        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 204));
        jButton2.setText("EXIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ICON/menu.jpg"))); // NOI18N
        jButton3.setText("jButton3");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        lbXinChao.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        lb_cloack.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        lb_cloack.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_ttdichvu1)
                    .addComponent(btn_ttdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(244, 244, 244))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_ttthanhtoan)
                            .addComponent(btn_ttthuephong))
                        .addGap(0, 39, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(225, 225, 225)
                .addComponent(lb_cloack)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbXinChao, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lb_cloack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbXinChao, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(88, 88, 88))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton1)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(btn_ttthanhtoan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(93, 93, 93)
                                .addComponent(btn_ttthuephong, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(btn_ttdichvu1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(90, 90, 90)
                                    .addComponent(btn_ttdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(15, 15, 15)
                        .addComponent(jButton2)))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ttdichvu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttdichvu1ActionPerformed
        setVisible(false);
        new KHACHHANG(tentk).setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ttdichvu1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new LOGIN().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_ttdichvuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttdichvuActionPerformed
        setVisible(false);
        new DICHVU().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ttdichvuActionPerformed

    private void btn_ttthanhtoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttthanhtoanActionPerformed
        setVisible(false);
        new THANHTOAN().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ttthanhtoanActionPerformed

    private void btn_ttthuephongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ttthuephongActionPerformed
        setVisible(false);
        new THUEPHONG().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_ttthuephongActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int a = JOptionPane.showConfirmDialog(null, "Do you quan exit", "Thong bao!!", JOptionPane.YES_NO_OPTION);
        if (a == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
////        /* Set the Nimbus look and feel */
////        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
////        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
////         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
////         */
////        try {
////            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
////                if ("Nimbus".equals(info.getName())) {
////                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
////                    break;
////                }
////            }
////        } catch (ClassNotFoundException ex) {
////            java.util.logging.Logger.getLogger(QL_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(QL_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(QL_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            Object etx = null;
////            java.util.logging.Logger.getLogger(QL_NhanVien.class.getName()).log(java.util.logging.Level.SEVERE, null, etx);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new QL_NhanVien().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ttdichvu;
    private javax.swing.JButton btn_ttdichvu1;
    private javax.swing.JButton btn_ttthanhtoan;
    private javax.swing.JButton btn_ttthuephong;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lbXinChao;
    private javax.swing.JLabel lb_cloack;
    // End of variables declaration//GEN-END:variables

    static class setVisible {

        public setVisible(boolean b) {
        }
    }
}