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
public class dichVu {
    String maDV ,tenDV ;
    float giaDV ;

    public dichVu(String maDV, String tenDV, float giaDV) {
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
    }

    public String getMaDV() {
        return maDV;
    }

    public void setMaDV(String maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(float giaDV) {
        this.giaDV = giaDV;
    }

    public dichVu() {
    }

    @Override
    public String toString() {
        return "dichVu{" + "maDV=" + maDV + ", tenDV=" + tenDV + ", giaDV=" + giaDV + '}';
    }

}
