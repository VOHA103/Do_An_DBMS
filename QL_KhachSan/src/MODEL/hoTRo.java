/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author thuha
 */
public class hoTRo {

    static SimpleDateFormat ft = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public static boolean checkRong(JTextField txt) {
        if (txt.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Khong duoc de trong thong tin", "Thong bao", 1);
            txt.requestFocus();
            return true;
        }
        return false;
    }

    public static boolean ktraNgay(JTextField txt) {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false);
        try {
            df.parse(txt.getText().trim());
        } catch (Exception e) {
            txt.setText("");
            txt.requestFocus();
            JOptionPane.showMessageDialog(null, txt.getName() + "ngay/thang/nam không được hợp lệ", "Thông báo", 1);
            return false;
        }
        return true;
    }

    public static boolean ktraSDT(JTextField txt) {
        String ktra = "0\\d{9,10}";
        if (!txt.getText().trim().matches(ktra)) {
            JOptionPane.showMessageDialog(null, txt.getName() + "SDT không hợp lệ", "Thông báo", 1);
            txt.setText("");
            txt.requestFocus();
            return false;
        }
        return true;
    }

    public static boolean ktraEmail(String mail) {
        String ktra = "\\w+@\\w+\\.\\w+";
        if (mail.matches(ktra)) {
            return true;
        }
        return false;

    }

    public static boolean ktraNamXB(int nam) {
        if (nam > 1974 && nam < 2022) {
            return true;
        }
        return false;
    }

    public static void clock(JLabel lbTime) {
        Thread clock = new Thread() {
            @Override
            public void run() {
                try {
                    while (true) {
                        Date t = new Date();
                        lbTime.setText(ft.format(t));
                        sleep(1000);
                    }
                } catch (InterruptedException e) {
                }
            }
        };
        System.out.println("hihih");
        clock.start();

    }

    public static boolean kt_tienThue(float tr) {
        if (tr > 0) {
            return true;
        }
        return false;
    }

    public static boolean kt_SL(int tr) {
        if (tr > 0) {
            return true;
        }
        return false;
    }

    public static String md5(String passWord) {
        String str = "";
        try {
            MessageDigest msd = MessageDigest.getInstance("MD5");
            byte[] srcTextBytes = passWord.getBytes("UTF-8");
            byte[] enrTextBytes = msd.digest(srcTextBytes);
            BigInteger bigInt = new BigInteger(1, enrTextBytes);
            str = bigInt.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public static int writeFile(String tenFile, String noiDungFile) {
        try {
            File file = new File("src\\FILE\\" + tenFile + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(noiDungFile);
            bw.close();
            fw.close();
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }

    public static void openFile(String tenFile) {
        try {
            ProcessBuilder pb = new ProcessBuilder("Notepad.exe", "src\\FILE\\" + tenFile + ".txt");
            pb.start();
        } catch (IOException ex) {
        }
    }

    public static void offEdittingTable(JTable tb) {
        if (tb.isEditing()) {
            int row = tb.getSelectedRow();
            int col = tb.getSelectedColumn();
            tb.getCellEditor(row, col).cancelCellEditing();
        }
    }
}
