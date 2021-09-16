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
public class phong {
   String maPhong ,tenPhong ,maLoai ;
   int tinhTrang ;
   float giaPhong;

    public phong(String maPhong, String tenPhong, String maLoai, int tinhTrang, float giaPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.maLoai = maLoai;
        this.tinhTrang = tinhTrang;
        this.giaPhong = giaPhong;
    }

    public phong() {
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(String maLoai) {
        this.maLoai = maLoai;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }

    @Override
    public String toString() {
        return "phong{" + "maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", maLoai=" + maLoai + ", tinhTrang=" + tinhTrang + ", giaPhong=" + giaPhong + '}';
    }
}
