/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DAO.ChiTietPhieuNhapDAO;
import DAO.NhaCungCapDAO;
import DAO.NhanVienDAO;
import DAO.PhieuNhapDAO;
import DAO.SanPhamDAO;
import POJO.ChiTietPhieuNhap;
import POJO.NhaCungCap;
import POJO.NhanVien;
import POJO.PhieuNhap;
import POJO.SanPham;
import POJO.TaiKhoan;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author tuan
 */
public class PhieuNhapHang extends javax.swing.JFrame {

    /**
     * Creates new form DatPhongKs
     */
    DefaultTableModel dtm = new DefaultTableModel();
    String[] tieude = {"Mã", "Tên sản phẩm", "Số lượng tồn", " Đơn giá"};
    DefaultTableModel dtm1 = new DefaultTableModel();
    String[] tieude1 = {"Mã", "Tên sản phẩm", "Số lượng nhập", "Tổng giá"};
    
    TaiKhoan TK = new TaiKhoan();
    PhieuNhap phieuNhap = new PhieuNhap();

    public PhieuNhapHang(TaiKhoan taiKhoan) {
        initComponents();
        this.TK = taiKhoan;
        setTitle("Nhập hàng");
        setLocationRelativeTo(null);
        loadLSP();
        loadNCC();
        loadNhanVien();

    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnNhapHang = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTenNV = new javax.swing.JTextField();
        btnThoat = new javax.swing.JButton();
        txtNgayNhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbLNhap = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        cbbNCC = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbLSP = new javax.swing.JTable();
        btnRS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 48)); // NOI18N
        jLabel1.setText("Phiếu Nhập Hàng");

        btnNhapHang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnNhapHang.setText("Tạo phiếu nhập hàng");
        btnNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhapHangActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel3.setText("Ngày Nhập");

        txtTenNV.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        btnThoat.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        txtNgayNhap.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Tên nhân viên");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel9.setText("Tổng tiền");

        txtTongTien.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        tbLNhap.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbLNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbLNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLNhapMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbLNhap);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel10.setText("Nhà cung cấp");

        cbbNCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNCCActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel11.setText("Danh sách sản phẩm");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel12.setText("Danh sách sản phẩm nhập");

        tbLSP.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tbLSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbLSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbLSPMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbLSP);

        btnRS.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnRS.setText("Làm mới");
        btnRS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(178, 178, 178)
                                .addComponent(txtNgayNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel11)))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnThoat)
                        .addGap(19, 19, 19))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRS)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 53, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(284, 284, 284))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(474, 474, 474))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNgayNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cbbNCC, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNhapHang)
                    .addComponent(btnThoat))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel11)
                    .addComponent(btnRS))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhapHangActionPerformed
        // TODO add your handling code here:x
        System.out.println(TK.getTenDangNhap());
        NhanVien nhanVien = NhanVienDAO.layThongTinNhanVien(TK.getMa());
        NhaCungCap ncc = NhaCungCapDAO.layThongTinNhaCungCap(cbbNCC.getSelectedItem().toString());
        phieuNhap.setNgayNhap(txtNgayNhap.getText().trim());
        phieuNhap.setTongTien(0);
        phieuNhap.setMaNhanVien(nhanVien.getMaNhanVien());
        phieuNhap.setMaNhaCungCap(ncc.getMaNhaCungCap());
        PhieuNhapDAO.themPhieuNhap(phieuNhap);
        phieuNhap = PhieuNhapDAO.layPhieuNhap(phieuNhap);
    }//GEN-LAST:event_btnNhapHangActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        setVisible(false);

    }//GEN-LAST:event_btnThoatActionPerformed

    private void tbLNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLNhapMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tbLNhapMouseClicked

    private void tbLSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbLSPMouseClicked
        // TODO add your handling code here:
        SanPham sanPham = new SanPham();
        int row = tbLSP.getSelectedRow();
        sanPham.setMaSanPham(Integer.parseInt(tbLSP.getValueAt(row, 0).toString().trim()));
        sanPham.setTenSanPham(tbLSP.getValueAt(row, 1).toString().trim());
        sanPham.setSoLuongTon(Integer.parseInt(tbLSP.getValueAt(row, 2).toString().trim()));
        sanPham.setDonGia(Integer.parseInt(tbLSP.getValueAt(row, 3).toString().trim()));
        NhapSoLuong SL = new NhapSoLuong(sanPham,phieuNhap);
        SL.setVisible(true);
    }//GEN-LAST:event_tbLSPMouseClicked

    private void cbbNCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNCCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNCCActionPerformed

    private void btnRSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRSActionPerformed
         // TODO add your handling code here:
         loadLNhap(phieuNhap.getMaPhieuNhap());
         loadLSP();
         System.out.println(phieuNhap.getMaPhieuNhap());
    }//GEN-LAST:event_btnRSActionPerformed

    private void loadNCC() {
        ArrayList<NhaCungCap> LNCC = NhaCungCapDAO.layDanhSachNhaCungCap();
        for (NhaCungCap ncc : LNCC) {
            cbbNCC.addItem(ncc.getTenNhaCungCap());
        }
    }

    private void loadNhanVien() {
        NhanVien nhanVien = NhanVienDAO.layThongTinNhanVien(TK.getMa());
        txtTenNV.setEnabled(false);
        txtTenNV.setText(nhanVien.getHoTen());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuNhapHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhapHang;
    private javax.swing.JButton btnRS;
    private javax.swing.JButton btnThoat;
    private javax.swing.JComboBox<String> cbbNCC;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbLNhap;
    private javax.swing.JTable tbLSP;
    private javax.swing.JTextField txtNgayNhap;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

    private void loadLSP() {
        dtm.setColumnIdentifiers(tieude);
        tbLSP.setModel(dtm);
        ArrayList<SanPham> LSP = SanPhamDAO.layDanhSachSanPham();
        dtm.setRowCount(0);
        for (SanPham sp : LSP) {
            Vector<Object> v = new Vector<Object>();
            v.add(sp.getMaSanPham());
            v.add(sp.getTenSanPham());
            v.add(sp.getSoLuongTon());
            v.add(sp.getDonGia());
            dtm.addRow(v);
        }
    }

    private void loadLNhap(int maPhieuNhap) {
        dtm1.setColumnIdentifiers(tieude1);
        tbLNhap.setModel(dtm1);
        ArrayList<ChiTietPhieuNhap> LCTPN = ChiTietPhieuNhapDAO.layDanhChiTietPhieuNhap(maPhieuNhap);
        dtm1.setRowCount(0);
        for (ChiTietPhieuNhap ctsp : LCTPN) {
            Vector<Object> v = new Vector<Object>();
            v.add(ctsp.getMaSanPham());
            SanPham sp = SanPhamDAO.laySanPham(ctsp.getMaSanPham());
            v.add(sp.getTenSanPham());
            v.add(ctsp.getSoLuong());
            int tong = ctsp.getSoLuong() * sp.getDonGia();
            v.add(tong);
            dtm1.addRow(v);
        }
    }
}
