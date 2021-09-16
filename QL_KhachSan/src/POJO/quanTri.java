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
    int id;
    String  TENTK ,MATKHAU;

    public quanTri(int id, String TENTK, String MATKHAU) {
        this.id = id;
        this.TENTK = TENTK;
        this.MATKHAU = MATKHAU;
    }

    public quanTri() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "quanTri{" + "id=" + id + ", TENTK=" + TENTK + ", MATKHAU=" + MATKHAU + '}';
    }

    
    
}
