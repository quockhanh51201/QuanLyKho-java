/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.ChiTietPhieuNhap;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quock
 */
public class ChiTietPhieuNhapDAO {

    static SQLServerDataProvider pro = new SQLServerDataProvider();

    public static boolean themCTPhieuNhap(ChiTietPhieuNhap CTphieunhap) {
        boolean kq = false;
        String sql = String.format("INSERT INTO ChiTietPhieuNhap (MaPhieuNhap, MaSanPham, SoLuong) values ('%s','%s','%s')",
                CTphieunhap.getMaPhieuNhap(), CTphieunhap.getMaSanPham(), CTphieunhap.getSoLuong());
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
        public static ArrayList<ChiTietPhieuNhap> layDanhChiTietPhieuNhap(int maPhieuNhap) {
        ArrayList<ChiTietPhieuNhap> LCTPN = new ArrayList<ChiTietPhieuNhap>();
        try {
            String sql = String.format("SELECT * FROM ChiTietPhieuNhap WHERE MaPhieuNhap = '%s'",maPhieuNhap);
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                ChiTietPhieuNhap CTPN = new ChiTietPhieuNhap();
                CTPN.setMaPhieuNhap(rs.getInt("MaPhieuNhap"));
                CTPN.setMaSanPham(rs.getInt("MaSanPham"));
                CTPN.setSoLuong(rs.getInt("SoLuong"));
                LCTPN.add(CTPN);
            }
            pro.close();
            System.out.println("Lấy được danh sách sản phẩm");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LCTPN;
    }
}
