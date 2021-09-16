/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.util.Date;

/**
 *
 * @author thuha
 */
public class thuePhong {
    String maThue ,maKH ,maPhong ;
    Date ngaVao ,ngayRa ;
    float tienThueP ;

    public thuePhong(String maThue, String maKH, String maPhong, Date ngaVao, Date ngayRa, float tienThueP) {
        this.maThue = maThue;
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.ngaVao = ngaVao;
        this.ngayRa = ngayRa;
        this.tienThueP = tienThueP;
    }

    public thuePhong() {
    }

    public thuePhong(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getMaThue() {
        return maThue;
    }

    public void setMaThue(String maThue) {
        this.maThue = maThue;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public Date getNgaVao() {
        return ngaVao;
    }

    public void setNgaVao(Date ngaVao) {
        this.ngaVao = ngaVao;
    }

    public Date getNgayRa() {
        return ngayRa;
    }

    public void setNgayRa(Date ngayRa) {
        this.ngayRa = ngayRa;
    }

    public float getTienThueP() {
        return tienThueP;
    }

    public void setTienThueP(float tienThueP) {
        this.tienThueP = tienThueP;
    }

    @Override
    public String toString() {
        return "thuePhong{" + "maThue=" + maThue + ", maKH=" + maKH + ", maPhong=" + maPhong + ", ngaVao=" + ngaVao + ", ngayRa=" + ngayRa + ", tienThueP=" + tienThueP + '}';
    }
}
