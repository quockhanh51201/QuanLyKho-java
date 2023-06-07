/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.NhaCungCap;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author quock
 */
public class NhaCungCapDAO {

    static SQLServerDataProvider pro = new SQLServerDataProvider();

    public static ArrayList<NhaCungCap> layDanhSachNhaCungCap() {
        ArrayList<NhaCungCap> LNCC = new ArrayList<NhaCungCap>();
        try {
            String sql = "SELECT * FROM NhaCungCap";
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                NhaCungCap NCC = new NhaCungCap();
                NCC.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                NCC.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
                LNCC.add(NCC);
            }
            pro.close();
            System.out.println("Lấy được danh sách nhà cung cấp");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return LNCC;
    }

    public static NhaCungCap layThongTinNhaCungCap(String tenNCC) {
        NhaCungCap NCC = new NhaCungCap();
        try {
            String sql = String.format("SELECT * FROM NhaCungCap WHERE TenNhaCungCap = N'%s'", tenNCC);
            pro.open();
            ResultSet rs = pro.executeQuery(sql);
            while (rs.next()) {
                NCC.setMaNhaCungCap(rs.getInt("MaNhaCungCap"));
                NCC.setTenNhaCungCap(rs.getString("TenNhaCungCap"));
            }
            pro.close();
            System.out.println(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return NCC;
    }
}
