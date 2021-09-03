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
public class nhanVien {
    String maNV,matkhau,hoTen ,gioiTinh ,soDT;
    Date ngaySinh ;

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public nhanVien() {
    }

    public nhanVien(String maNV, String matkhau, String hoTen, String gioiTinh, String soDT, Date ngaySinh) {
        this.maNV = maNV;
        this.matkhau = matkhau;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.soDT = soDT;
        this.ngaySinh = ngaySinh;
    }

    @Override
    public String toString() {
        return "nhanVien{" + "maNV=" + maNV + ", matkhau=" + matkhau + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", soDT=" + soDT + ", ngaySinh=" + ngaySinh + '}';
    }

}
