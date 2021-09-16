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
public class thanhToan {
    String maThueP;
    Date ngayTToan ;
    float thanhTien ;

    public thanhToan(String maThueP, Date ngayTToan, float thanhTien) {
        this.maThueP = maThueP;
        this.ngayTToan = ngayTToan;
        this.thanhTien = thanhTien;
    }

    public thanhToan() {
    }

    public String getMaThueP() {
        return maThueP;
    }

    public void setMaThueP(String maThueP) {
        this.maThueP = maThueP;
    }

    public Date getNgayTToan() {
        return ngayTToan;
    }

    public void setNgayTToan(Date ngayTToan) {
        this.ngayTToan = ngayTToan;
    }

    public float getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(float thanhTien) {
        this.thanhTien = thanhTien;
    }

    @Override
    public String toString() {
        return "thanhToan{" + "maThueP=" + maThueP + ", ngayTToan=" + ngayTToan + ", thanhTien=" + thanhTien + '}';
    }
}
