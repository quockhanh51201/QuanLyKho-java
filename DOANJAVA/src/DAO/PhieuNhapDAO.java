/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.PhieuNhap;
import java.sql.ResultSet;

/**
 *
 * @author quock
 */
public class PhieuNhapDAO {

    static SQLServerDataProvider pro = new SQLServerDataProvider();

    public static boolean themPhieuNhap(PhieuNhap phieunhap) {
        boolean kq = false;
        String sql = String.format("INSERT INTO PhieuNhapHang (NgayNhap, TongTien, MaNhanVien, MaNhaCungCap) values ('%s','%s','%s','%s')",
                phieunhap.getNgayNhap(), phieunhap.getTongTien(), phieunhap.getMaNhanVien(), phieunhap.getMaNhaCungCap());
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

    public static boolean suaPhieuNhap(PhieuNhap PN) {
        boolean kq = false;
        String sql = String.format("UPDATE PhieuNhapHang SET TongTien = '%s' WHERE MaPhieuNhap = %s",
                PN.getTongTien(), PN.getMaPhieuNhap());
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
    
    public static PhieuNhap layPhieuNhap(PhieuNhap PN) {
        PhieuNhap PNN = new PhieuNhap();
        try {
            String sql = String.format("SELECT*FROM PhieuNhapHang WHERE NgayNhap = '%s' AND TongTien = '%s' AND MaNhanVien = '%s' AND MaNhaCungCap = '%s'", PN.getNgayNhap(),PN.getTongTien(),PN.getMaNhanVien(),PN.getMaNhaCungCap());
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                PNN.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
                PNN.setNgayNhap(rs.getString("NgayNhap"));
                PNN.setTongTien(rs.getInt("TongTien"));
                PNN.setMaNhanVien(rs.getInt("MaNhanVien"));
                PNN.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
            }
            pro.close();
            System.out.println("Lấy được thông tin PNH");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return PNN;
    }

}
