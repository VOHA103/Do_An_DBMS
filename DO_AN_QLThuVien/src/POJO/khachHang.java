/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author thuha
 */
public class khachHang {
    String maKH ,tenKH ,gioiTinh ,diaChi ,soDT ;

    public khachHang() {
    }

    public khachHang(String maKH, String tenKH, String gioiTinh, String diaChi, String soDT) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.diaChi = diaChi;
        this.soDT = soDT;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    @Override
    public String toString() {
        return "khachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", gioiTinh=" + gioiTinh + ", diaChi=" + diaChi + ", soDT=" + soDT + '}';
    }
    
}
