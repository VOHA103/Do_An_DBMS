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
public class suDungDV {
    String maSD ,maThueP ,maDV ;
    int soLuong ;
    float tienSD ;

    public suDungDV(String maSD, String maThueP, String maDV, int soLuong, float tienSD) {
        this.maSD = maSD;
        this.maThueP = maThueP;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.tienSD = tienSD;
    }

    public suDungDV() {
    }

    public String getMaSD() {
        return maSD;
    }

    public void setMaSD(String maSD) {
        this.maSD = maSD;
    }

    public String getMaThueP() {
        return maThueP;
    }

    public void setMaThueP(String maThueP) {
        this.maThueP = maThueP;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getTienSD() {
        return tienSD;
    }

    public void setTienSD(float tienSD) {
        this.tienSD = tienSD;
    }

    @Override
    public String toString() {
        return "suDungDV{" + "maSD=" + maSD + ", maThueP=" + maThueP + ", maDV=" + maDV + ", soLuong=" + soLuong + ", tienSD=" + tienSD + '}';
    }
    
}
