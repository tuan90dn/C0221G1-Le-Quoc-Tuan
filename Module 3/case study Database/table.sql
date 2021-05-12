create database case_study;
use case_study;
create table loai_khach(
IDLoaiKhach int primary key not null,
TenLoaiKhach varchar(45) not null);
select * from loai_khach;
drop table loai_khach;
create table nhan_vien(
IDNhanVien int primary key,HoTen varchar(100),IDViTri int,
IDTrinhDo int,IDBoPhan int,NgaySinh date,
SoCMTND varchar(45),Luong varchar(45),SDT varchar(45),
Email varchar(45),DiaChi varchar(45));
select * from nhan_vien;
drop table nhan_vien;
create table vi_tri(
IDViTri int, TenViTri varchar(45));
select * from vi_tri;
create table bo_phan(
IDBoPhan int, TenBoPhan varchar(45));
select * from bo_phan;
create table trinh_do(
IDTrinhDo int not null, TenTrinhDo varchar(45) not null);
select * from trinh_do;
drop table khach_hang;
create table khach_hang(
IDKhachHang int primary key,
IDLoaiKhach int not null,
foreign key (IDLoaiKhach) references loai_khach(IDLoaiKhach),
HoTen varchar(45),
NgaySinh date,
SoCMTND varchar(45),
SDT varchar(45),
Email varchar(45),
DiaChi varchar(45));
select * from khach_hang;
create table dich_vu(
IDDichVu int primary key,
TenDichVu varchar(45),DienTich int,
SoTang int,SoNguoiToiDa varchar(45),
ChiPhiThue varchar(45),DiaChi varchar(45));
select * from khach_hang;


