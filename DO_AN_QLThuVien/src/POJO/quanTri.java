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
public class quanTri {
    String TENTK ,MATKHAU;

    public quanTri() {
    }

    public String getTENTK() {
        return TENTK;
    }

    public void setTENTK(String TENTK) {
        this.TENTK = TENTK;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    @Override
    public String toString() {
        return "quanTri{" + "TENTK=" + TENTK + ", MATKHAU=" + MATKHAU + '}';
    }

    public quanTri(String TENTK, String MATKHAU) {
        this.TENTK = TENTK;
        this.MATKHAU = MATKHAU;
    }

    
}
