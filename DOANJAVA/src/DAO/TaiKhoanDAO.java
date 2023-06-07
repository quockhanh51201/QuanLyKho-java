/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.TaiKhoan;
import java.sql.ResultSet;

/**
 *
 * @author quock
 */
public class TaiKhoanDAO {

    static SQLServerDataProvider pro = new SQLServerDataProvider();

    public static boolean dangKi(String tenDangNhap, String matKhau) {
        boolean kq = false;
        String sql = String.format("INSERT INTO TaiKhoan (TenDangNhap, MatKhau) values ('%s','%s')",
                tenDangNhap, matKhau);
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

    public static TaiKhoan dangNhap (String tenDangNhap, String matKhau){
        TaiKhoan TK = new TaiKhoan();
        try {
            String sql = String.format("SELECT * FROM TaiKhoan WHERE TenDangNhap = '%s' AND MatKhau = '%s'",
                    tenDangNhap, matKhau);
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                TK.setMa(rs.getInt("MaTaiKhoan"));
                TK.setTenDangNhap(rs.getString("TenDangNhap"));
                TK.setMatKhau(rs.getString("MatKhau"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TK;
    }
}
