/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.loaiPhongDao;
import DAO.phongDao;
import MODEL.hoTRo;
import POJO.loaiPhong;
import POJO.phong;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author thuha
 */
public class PHONG extends javax.swing.JFrame {

    String tentk = "";
    DefaultTableModel modelTB;
    Vector Tile = new Vector();
    ArrayList<phong> dsp;

    private PHONG() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void loadPhong() {
        dsp = phongDao.getDSPhong();
        modelTB.setRowCount(0);
        for (phong p : dsp) {
            Vector v = new Vector();
            v.add(p.getMaPhong());
            v.add(p.getTenPhong());
            v.add(p.getMaLoai());
            v.add(p.getTinhTrang());
            v.add(p.getGiaPhong());
            modelTB.addRow(v);
        }
    }

    /**
     * Creates new form PHONG
     *
     * @param tentk
     */
    public PHONG(String tentk) {
        initComponents();
        this.tentk = tentk;

        setLocationRelativeTo(null);
        Tile.add("Ma Phong");
        Tile.add("Ten Phong");
        Tile.add("Ma Loai");
        Tile.add("Tinh Trang");
        Tile.add("Gia Phong");
        modelTB = new DefaultTableModel();
        modelTB.setColumnIdentifiers(Tile);
        tb_dsphong.setModel(modelTB);
        loadPhong();
        this.tentk = tentk;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_xoa = new javax.swing.JButton();
        btn_thoat = new javax.swing.JButton();
        btn_them = new javax.swing.JButton();
        btn_sua = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        span_tinhtrang = new javax.swing.JSpinner();
        txt_maphong = new javax.swing.JTextField();
        txt_tenphong = new javax.swing.JTextField();
        txt_maloai = new javax.swing.JTextField();
        txt_giaphong = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_dsphong = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("THÔNG TIN PHONG");

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setText("TINHTRANG:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("GIAPHONG:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("MALOAI:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("TENPHONG:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("MAPHONG:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("DANH SÁCH PHÒNG");

        btn_xoa.setBackground(new java.awt.Color(0, 153, 51));
        btn_xoa.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_xoa.setForeground(new java.awt.Color(204, 255, 255));
        btn_xoa.setText("Xóa");
        btn_xoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaActionPerformed(evt);
            }
        });

        btn_thoat.setBackground(new java.awt.Color(0, 153, 51));
        btn_thoat.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_thoat.setForeground(new java.awt.Color(204, 255, 255));
        btn_thoat.setText("ĐÓNG");
        btn_thoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thoatActionPerformed(evt);
            }
        });

        btn_them.setBackground(new java.awt.Color(0, 153, 51));
        btn_them.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_them.setForeground(new java.awt.Color(204, 255, 255));
        btn_them.setText("Thêm");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_sua.setBackground(new java.awt.Color(0, 153, 51));
        btn_sua.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(204, 255, 255));
        btn_sua.setText("Sửa");
        btn_sua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_suaActionPerformed(evt);
            }
        });

        btn_luu.setBackground(new java.awt.Color(0, 153, 51));
        btn_luu.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_luu.setForeground(new java.awt.Color(204, 255, 255));
        btn_luu.setText("LƯU");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        span_tinhtrang.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        span_tinhtrang.setModel(new javax.swing.SpinnerNumberModel(1, 0, 1, 1));

        tb_dsphong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_dsphong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tb_dsphongMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tb_dsphong);

        jScrollPane2.setViewportView(jScrollPane1);

        jButton1.setText("MENU>>");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btn_huy.setBackground(new java.awt.Color(0, 153, 51));
        btn_huy.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btn_huy.setForeground(new java.awt.Color(204, 255, 255));
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(511, 511, 511))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel1))
                                        .addGap(52, 52, 52)
                                        .addComponent(txt_giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(btn_thoat)
                                        .addGap(183, 183, 183)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(67, 67, 67)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(span_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(85, 85, 85)
                                        .addComponent(btn_them)))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btn_xoa)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btn_sua)
                                        .addGap(8, 8, 8))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(txt_tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(63, 63, 63)
                                .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(382, Short.MAX_VALUE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(126, 126, 126)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_luu, btn_sua, btn_them, btn_thoat, btn_xoa});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_maloai, txt_maphong, txt_tenphong});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_thoat)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jLabel6))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton1)))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txt_maphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_luu)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tenphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_maloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua)
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(span_tinhtrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btn_them)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_giaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn_xoa))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(311, Short.MAX_VALUE)
                    .addComponent(btn_huy)
                    .addGap(194, 194, 194)))
        );

        jTabbedPane1.addTab("THÔNG TIN PHÒNG", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_thoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thoatActionPerformed
        setVisible(false);
        new QL_NhanVien(tentk).setVisible(true);
        dispose();  // TODO add your handling code here:
    }//GEN-LAST:event_btn_thoatActionPerformed

    private void tb_dsphongMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_dsphongMouseReleased
        int row = tb_dsphong.getSelectedRow();
        if (row >= 0) {
            txt_maphong.setText((String) (tb_dsphong.getValueAt(row, 0)));
            txt_tenphong.setText((String) (tb_dsphong.getValueAt(row, 1)));
            txt_maloai.setText((String) (tb_dsphong.getValueAt(row, 2)));
            span_tinhtrang.setValue((tb_dsphong.getValueAt(row, 3)));
            txt_giaphong.setText((tb_dsphong.getValueAt(row, 4).toString()));
            btn_sua.setEnabled(true);
            btn_huy.setEnabled(false);
            btn_luu.setEnabled(false);
            btn_xoa.setEnabled(true);
            btn_them.setEnabled(true);
        }

// TODO add your handling code here:
    }//GEN-LAST:event_tb_dsphongMouseReleased
    public void reset() {
        txt_giaphong.setText("");
        txt_maloai.setText("");
        txt_maphong.setText("");
        txt_tenphong.setText("");
        span_tinhtrang.getValue().equals("");

        txt_maphong.requestFocus();
    }

    boolean ktraMaLP(String maPH) {
        String ktra = "LP\\d+";
        if (maPH.matches(ktra)) {
            return true;
        }
        return false;
    }

    boolean ktraMaP(String maPH) {
        String ktra = "MP\\d+";
        if (maPH.matches(ktra)) {
            return true;
        }
        return false;
    }
    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed

        if (hoTRo.checkRong(txt_maphong) || hoTRo.checkRong(txt_tenphong) || hoTRo.checkRong(txt_maloai) || hoTRo.checkRong(txt_giaphong)) {
            return;
        }

        if (!ktraMaP(txt_maphong.getText())) {
            JOptionPane.showMessageDialog(this, "Ma phong co dang MPxx voi x la chu so", "Thong bao", 1);

            txt_maphong.setText("");
            txt_maphong.requestFocus();

            return;
        }
        if (!ktraMaLP(txt_maloai.getText())) {
            JOptionPane.showMessageDialog(this, "Ma phong co dang LPxx voi x la chu so", "Thong bao", 1);

            txt_maloai.setText("");
            txt_maloai.requestFocus();

            return;
        }
        if (!hoTRo.kt_tienThue(Float.parseFloat(txt_giaphong.getText()))) {
            JOptionPane.showMessageDialog(this, "Gia phong  phải lớn hơn 0", "Thong bao", 1);
            txt_giaphong.setText("");
            txt_giaphong.requestFocus();
            return;

        }

        if (JOptionPane.showConfirmDialog(this, "Ban co muon them khong", "Thong bao", 1) == JOptionPane.YES_NO_OPTION) {
            int i = phongDao.themPhong(txt_maphong.getText().trim(), txt_tenphong.getText().trim(), txt_maloai.getText().trim(), span_tinhtrang.getValue().hashCode(), Float.parseFloat(txt_giaphong.getText()));

            if (i != -1) {
                JOptionPane.showMessageDialog(this, "Ban da them thanh cong", "Thong bao", 1);

                loadPhong();
                reset();
            }
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btn_luuActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        reset();

        btn_huy.setEnabled(true);
        btn_luu.setEnabled(true);

        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);
        span_tinhtrang.setValue(0);
    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaActionPerformed
        btn_them.setEnabled(false);
        btn_sua.setEnabled(false);

        btn_huy.setEnabled(true);
        btn_luu.setEnabled(true);
        if (hoTRo.checkRong(txt_maphong) || hoTRo.checkRong(txt_tenphong) || hoTRo.checkRong(txt_maloai) || hoTRo.checkRong(txt_giaphong)) {
            return;
        }
        int tb = tb_dsphong.getSelectedRow();
        if (tb >= 0) {
            if (JOptionPane.showConfirmDialog(null, "Ban co muon xoa khong", "Thong bao", 1) == JOptionPane.YES_OPTION) {
                int i = phongDao.xoaPhong(tb_dsphong.getValueAt(tb, 0).toString());
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Ban da xoa thanh cong", "Thong bao", 1);
                    loadPhong();

                }
            }
        }


    }//GEN-LAST:event_btn_xoaActionPerformed

    private void btn_suaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_suaActionPerformed
        btn_xoa.setEnabled(false);
        btn_them.setEnabled(false);

        btn_luu.setEnabled(true);
        btn_huy.setEnabled(true);

        int row = tb_dsphong.getSelectedRow();
        if (row >= 0) {

            if (hoTRo.checkRong(txt_maphong) || hoTRo.checkRong(txt_tenphong) || hoTRo.checkRong(txt_maloai) || hoTRo.checkRong(txt_giaphong)) {
                return;
            }

            if (!ktraMaP(txt_maphong.getText())) {
                JOptionPane.showMessageDialog(this, "Ma phong co dang MPxx voi x la chu so", "Thong bao", 1);

                txt_maphong.setText("");
                txt_maphong.requestFocus();

                return;
            }
            if (!ktraMaLP(txt_maloai.getText())) {
                JOptionPane.showMessageDialog(this, "Ma phong co dang LPxx voi x la chu so", "Thong bao", 1);

                txt_maloai.setText("");
                txt_maloai.requestFocus();

                return;
            }
            if (!hoTRo.kt_tienThue(Float.parseFloat(txt_giaphong.getText()))) {
                JOptionPane.showMessageDialog(this, "Gia phong  phải lớn hơn 0", "Thong bao", 1);
                txt_giaphong.setText("");
                txt_giaphong.requestFocus();
                return;

            }

            if (JOptionPane.showConfirmDialog(null, "Bạn muốn sửa  khong", "Thông báo", JOptionPane.YES_NO_OPTION, 1) == JOptionPane.YES_OPTION) {
                int i = phongDao.update(txt_maphong.getText().trim(), txt_tenphong.getText().trim(), txt_maloai.getText().trim(), span_tinhtrang.getValue().hashCode(), Float.parseFloat(txt_giaphong.getText()));
                if (i != -1) {
                    JOptionPane.showMessageDialog(null, "Đã sửa thanh cong", "Thông báo", 1);

                    loadPhong();
                }
            }
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btn_suaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
        new QUANLY(tentk).setVisible(true);
        dispose();
       

// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        reset();

        btn_them.setEnabled(false);

        btn_sua.setEnabled(false);
        btn_xoa.setEnabled(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyActionPerformed

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
////            java.util.logging.Logger.getLogger(PHONG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (InstantiationException ex) {
////            java.util.logging.Logger.getLogger(PHONG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (IllegalAccessException ex) {
////            java.util.logging.Logger.getLogger(PHONG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
////            java.util.logging.Logger.getLogger(PHONG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
////        }
////        //</editor-fold>
////
////        /* Create and display the form */
////        java.awt.EventQueue.invokeLater(new Runnable() {
////            public void run() {
////                new PHONG().setVisible(true);
////            }
////        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_sua;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_thoat;
    private javax.swing.JButton btn_xoa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JSpinner span_tinhtrang;
    private javax.swing.JTable tb_dsphong;
    private javax.swing.JTextField txt_giaphong;
    private javax.swing.JTextField txt_maloai;
    private javax.swing.JTextField txt_maphong;
    private javax.swing.JTextField txt_tenphong;
    // End of variables declaration//GEN-END:variables
}
