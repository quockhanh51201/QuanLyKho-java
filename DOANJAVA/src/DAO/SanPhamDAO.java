/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.SanPham;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quock
 */
public class SanPhamDAO {

    static SQLServerDataProvider pro = new SQLServerDataProvider();

    public static ArrayList<SanPham> layDanhSachSanPham() {
        ArrayList<SanPham> LSP = new ArrayList<SanPham>();
        try {
            String sql = "SELECT * FROM SanPham";
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                SanPham SP = new SanPham();
                SP.setMaSanPham(rs.getInt("MaSanPham"));
                SP.setTenSanPham(rs.getString("TenSanPham"));
                SP.setSoLuongTon(rs.getInt("SoLuongTon"));
                SP.setDonGia(rs.getInt("DonGia"));
                LSP.add(SP);
            }
            pro.close();
            System.out.println("Lấy được danh sách sản phẩm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LSP;
    }

    public static SanPham laySanPham(int maSP) {
        SanPham SP = new SanPham();
        try {
            String sql = String.format("SELECT * FROM SanPham WHERE MaSanPham = '%s'", maSP);
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                SP.setMaSanPham(rs.getInt("MaSanPham"));
                SP.setTenSanPham(rs.getString("TenSanPham"));
                SP.setSoLuongTon(rs.getInt("SoLuongTon"));
                SP.setDonGia(rs.getInt("DonGia"));
            }
            pro.close();
            System.out.println("Lấy được thông tin sản phẩm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SP;
    }

    public static SanPham timKiemSanPham(String tenSanPham) {
        SanPham SP = new SanPham();
        try {
            String sql = String.format("SELECT * FROM SanPham WHERE TenSanPham = N'%s'", tenSanPham);
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                SP.setMaSanPham(rs.getInt("MaSanPham"));
                SP.setTenSanPham(rs.getString("TenSanPham"));
                SP.setSoLuongTon(rs.getInt("DonGia"));
                SP.setDonGia(rs.getInt("SoLuongTon"));
            }
            pro.close();
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return SP;
    }

    public static boolean xoaSanPham(int id) {
        boolean kq = false;
        String sql = "DELETE FROM SanPham WHERE MaSanPham = '" + id + "'";
        System.out.println(sql);
        pro.open();
        int n = pro.executeUpdate(sql);
        System.out.println(n);
        if (n == 1) {
            kq = true;
        }
        pro.close();
        return kq;

    }

    public static boolean themSanPham(SanPham sp) {
        boolean kq = false;
        String sql = String.format("INSERT INTO SanPham(TenSanPham, DonGia, SoLuongTon) values (N'%s','%s','%s')",
                sp.getTenSanPham(), sp.getDonGia(), sp.getSoLuongTon());
        System.out.println(sql);
        pro.open();
        int n = pro.executeUpdate(sql);
        System.out.println(sql);
        if (n == 1) {
            kq = true;
        }
        pro.close();
        return kq;

    }

    public static boolean suaSanPham(SanPham sp) {
        boolean kq = false;
        String sql = String.format("UPDATE SanPham SET TenSanPham = N'%s', DonGia= '%s' WHERE MaSanPham = %s",
                sp.getTenSanPham(), sp.getDonGia(), sp.getMaSanPham());
        System.out.println(sql);
        pro.open();
        int n = pro.executeUpdate(sql);
        System.out.println(sql);
        if (n == 1) {
            kq = true;
        }
        pro.close();
        return kq;

    }

}
