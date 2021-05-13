create database case_study;
use case_study;
create table loai_khach(
ID_loai_khach int primary key not null,
ten_loai_khach varchar(45) not null);
select * from loai_khach;
create table khach_hang(
ID_khach_hang int primary key,
ID_loai_khach int not null,
foreign key (ID_loai_khach) references loai_khach(ID_loai_khach),
ho_ten varchar(45),
ngay_sinh date,
so_CMND varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45));
drop table loai_khach;

create table vi_tri(
ID_vi_tri int primary key not null, 
ten_vi_tri varchar(45));
select * from vi_tri;
create table bo_phan(
ID_bo_phan int primary key not null, 
ten_bo_phan varchar(45));
select * from bo_phan;
create table trinh_do(
ID_trinh_do int primary key not null, 
ten_trinh_do varchar(45) not null);
select * from trinh_do;
drop table vi_tri;

create table nhan_vien(
ID_nhan_vien int primary key not null,
ho_ten varchar(100),
ID_vi_tri int,
ID_trinh_do int,
ID_bo_phan int,
ngay_sinh date,
so_CMND varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
foreign key (ID_vi_tri) references vi_tri(ID_vi_tri),
foreign key (ID_trinh_do) references trinh_do(ID_trinh_do),
foreign key (ID_bo_phan) references bo_phan(ID_bo_phan)
);
select * from nhan_vien;
drop table nhan_vien;

select * from khach_hang;


create table loai_dich_vu(
ID_loai_dich_vu int primary key not null,
ten_loai_dich_vu varchar(50)
);
create table kieu_thue(
ID_kieu_thue int primary key not null,
ten_kieu_thue varchar(50),
gia int
);
create table dich_vu(
ID_dich_vu int primary key not null,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
ID_kieu_thue int,
ID_loai_dich_vu int,
trang_thai varchar(45),
foreign key (ID_kieu_thue) references kieu_thue(ID_kieu_thue),
foreign key (ID_loai_dich_vu) references loai_dich_vu(ID_loai_dich_vu)
)


