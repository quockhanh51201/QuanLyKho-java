/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NhanVien;
import java.sql.ResultSet;

/**
 *
 * @author quock
 */
public class NhanVienDAO {

    static SQLServerDataProvider pro = new SQLServerDataProvider();

    public static NhanVien layThongTinNhanVien(int maTK) {
        NhanVien NV = new NhanVien();
        try {
            String sql = String.format("SELECT * FROM NhanVien WHERE mataikhoan = '%s'", maTK);
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                NV.setMaNhanVien(rs.getInt("MaNhanVien"));
                NV.setHoTen(rs.getString("HoTen"));
                NV.setNgaySinh(rs.getString("NgaySinh"));
                NV.setSoDienThoai(rs.getString("SoDienThoai"));
                NV.setDiaChi(rs.getString("DiaChi"));
                NV.setMaTaiKhoan(rs.getInt("MaTaiKhoan"));
            }
            pro.close();
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NV;
    }

    public static boolean themNhanVien(NhanVien nhanvien) {
        boolean kq = false;
        String sql = String.format("INSERT INTO NhanVien (HoTen, NgaySinh, DiaChi, SoDienThoai, MaTaiKhoan) values (N'%s','%s',N'%s','%s','%s')",
                nhanvien.getHoTen(), nhanvien.getNgaySinh(), nhanvien.getDiaChi(), nhanvien.getSoDienThoai(), nhanvien.getMaTaiKhoan());
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

    public static boolean suaNhanVien(NhanVien nhanvien) {
        boolean kq = false;
        String sql = String.format("UPDATE NhanVien SET HoTen = N'%s', NgaySinh= '%s', DiaChi= N'%s', SoDienThoai= '%s' WHERE MaTaiKhoan = %s",
                nhanvien.getHoTen(), nhanvien.getNgaySinh(), nhanvien.getDiaChi(), nhanvien.getSoDienThoai(), nhanvien.getMaTaiKhoan());
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
