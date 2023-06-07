/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author quock
 */
public class SanPham {
    private int maSanPham;
    private String tenSanPham;
    private int donGia;
    private int soLuongTon;

    public SanPham(int maSanPham, String tenSanPham, int donGia, int soLuongTon) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }

    
    public SanPham() {
    }

    public SanPham(String tenSanPham, int donGia, int soLuongTon) {
        this.tenSanPham = tenSanPham;
        this.donGia = donGia;
        this.soLuongTon = soLuongTon;
    }
    

    public int getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(int maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }
    
}
