
CREATE DATABASE QL_KhoSieuThi;
go
-- Sử dụng cơ sở dữ liệu
USE QL_KhoSieuThi;
go
-- Bảng Tài khoản
CREATE TABLE TaiKhoan (
  MaTaiKhoan INT IDENTITY(1,1) PRIMARY KEY,
  TenDangNhap VARCHAR(50) NOT NULL,
  MatKhau VARCHAR(50) NOT NULL
);
go
-- Bảng Nhân viên
CREATE TABLE NhanVien (
  MaNhanVien INT IDENTITY(1,1) PRIMARY KEY,
  HoTen NVARCHAR(100) NOT NULL,
  NgaySinh DATE NOT NULL,
  DiaChi NVARCHAR(200) NOT NULL,
  SoDienThoai VARCHAR(20) NOT NULL,
  MaTaiKhoan INT,
  FOREIGN KEY (MaTaiKhoan) REFERENCES TaiKhoan(MaTaiKhoan)
);
go
-- Bảng Sản phẩm
CREATE TABLE SanPham (
  MaSanPham INT IDENTITY(1,1) PRIMARY KEY,
  TenSanPham NVARCHAR(100) NOT NULL,
  DonGia INT NOT NULL,
  SoLuongTon INT NOT NULL
);
go
-- Bảng  nhà cung cấp
CREATE TABLE NhaCungCap (
  MaNhaCungCap INT IDENTITY(1,1) PRIMARY KEY,
  TenNhaCungCap NVARCHAR(100) NOT NULL
);
go
-- Bảng Phiếu nhập hàng
CREATE TABLE PhieuNhapHang (
  MaPhieuNhap INT IDENTITY(1,1) PRIMARY KEY,
  NgayNhap VARCHAR(50) NOT NULL,
  TongTien INT NOT NULL,
  MaNhanVien INT,
  MaNhaCungCap INT,
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien),
  FOREIGN KEY (MaNhaCungCap) REFERENCES NhaCungCap(MaNhaCungCap)
);
go
-- Bảng Chi tiết phiếu nhập
CREATE TABLE ChiTietPhieuNhap (
  MaPhieuNhap INT,
  MaSanPham INT,
  SoLuong INT NOT NULL,
  PRIMARY KEY (MaPhieuNhap, MaSanPham),
  FOREIGN KEY (MaPhieuNhap) REFERENCES PhieuNhapHang(MaPhieuNhap),
  FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)
  );
  go
-- Bảng Phiếu xuất hàng
CREATE TABLE PhieuXuatHang (
  MaPhieuXuat INT IDENTITY(1,1) PRIMARY KEY,
  NgayXuat VARCHAR(50) NOT NULL,
  MaNhanVien INT NOT NULL,
  FOREIGN KEY (MaNhanVien) REFERENCES NhanVien(MaNhanVien)
);
go
-- Bảng Chi tiết phiếu xuất
CREATE TABLE ChiTietPhieuXuat (
  MaPhieuXuat INT,
  MaSanPham INT,
  SoLuong INT NOT NULL,
  PRIMARY KEY (MaPhieuXuat, MaSanPham),
  FOREIGN KEY (MaPhieuXuat) REFERENCES PhieuXuatHang(MaPhieuXuat),
  FOREIGN KEY (MaSanPham) REFERENCES SanPham(MaSanPham)
);
go

-- Ràng buộc dữ liệu (Constraints)
ALTER TABLE TaiKhoan
ADD CONSTRAINT CK_TaiKhoan_TenDangNhap_Unique UNIQUE (TenDangNhap);

ALTER TABLE NhanVien
ADD CONSTRAINT CK_NhanVien_SoDienThoai_Unique UNIQUE (SoDienThoai);

ALTER TABLE SanPham
ADD CONSTRAINT CK_SanPham_TenSanPham_Unique UNIQUE (TenSanPham);

ALTER TABLE ChiTietPhieuXuat
ADD CONSTRAINT CK_ChiTietPhieuXuat_SoLuong CHECK (SoLuong > 0);

ALTER TABLE ChiTietPhieuNhap
ADD CONSTRAINT CK_ChiTietPhieuNhap_SoLuong CHECK (SoLuong > 0);
go
INSERT INTO TaiKhoan (TenDangNhap, MatKhau)
VALUES ('admin', '123456'),
       ('user1', 'abcdef'),
       ('user2', 'xyz123');
INSERT INTO NhanVien (HoTen, NgaySinh, DiaChi, SoDienThoai, MaTaiKhoan)
VALUES ('Nguyen Van A', '1990-01-01', 'Hanoi', '0123456789', 1),
       ('Tran Thi B', '1995-02-02', 'Ho Chi Minh City', '0987654321', 2),
       ('Pham Van C', '1998-03-03', 'Da Nang', '0369876543', 3);
INSERT INTO SanPham (TenSanPham, DonGia, SoLuongTon)
VALUES ('Laptop Dell', 15000000, 10),
       ('Smartphone Samsung', 10000000, 20),
       ('TV Sony', 20000000, 15);
INSERT INTO NhaCungCap(TenNhaCungCap)
VALUES (N'Công ty A'),(N'Công ty B'),(N'Công ty C')
go
	   ------------------PROC-----------------
	   ------------------Trigger--------------
CREATE TRIGGER updateSoLuongSanPhamNhap
ON ChiTietPhieuNhap
AFTER INSERT, UPDATE
AS
BEGIN
  UPDATE SanPham
  SET SoLuongTon = SanPham.SoLuongTon + inserted.SoLuong - deleted.SoLuong
  FROM SanPham JOIN inserted ON SanPham.MaSanPham = inserted.MaSanPham
  JOIN deleted ON inserted.MaPhieuNhap = deleted.MaPhieuNhap AND inserted.MaSanPham = deleted.MaSanPham
END;
go
	   -------------test-------------------
--SELECT * FROM TaiKhoan WHERE TenDangNhap = 'demo' AND MatKhau = '12'
--SELECT * FROM SanPham
--DELETE FROM SanPham WHERE MaSanPham = 1
--SELECT * FROM NhanVien WHERE mataikhoan = 4
--SELECT * FROM NhaCungCap
--SELECT * FROM NhaCungCap WHERE TenNhaCungCap = N'Công Ty A'
--SELECT * FROM PhieuNhapHang
--INSERT INTO PhieuNhapHang (NgayNhap, TongTien, MaNhanVien, MaNhaCungCap) values ('2023/26/5','0','1','1')
--SELECT * FROM ChiTietPhieuNhap WHERE MaPhieuNhap = 14
--SELECT* FROM PhieuNhapHang WHERE NgayNhap = '12/12/2222' AND TongTien = '0' AND MaNhanVien = '4' AND MaNhaCungCap = '1'
INSERT INTO ChiTietPhieuNhap (MaPhieuNhap, MaSanPham, SoLuong) values ('2','1','4')