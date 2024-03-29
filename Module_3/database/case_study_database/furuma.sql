create database case_study;
use case_study;
create table loai_khach(
ID_loai_khach int primary key not null,
ten_loai_khach varchar(45) not null);
insert into loai_khach
values (1,"tuan"),(2,"toàn"),(3,"đức");
insert into loai_khach
values (4,"Diamond"),(5,"Gold"),(6,"Diamon");
update loai_khach
set ten_loai_khach='Platinum'
where ten_loai_khach='Gold';
truncate table khach_hang;
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
insert into khach_hang
values(1,1,"Nguyễn Văn A",'1990-11-28',123456789,8239483,'a@gmail.com','Lê Duẩn'),
(2,2,"Nguyễn Văn B",'1991-11-28',123456789,8239483,'b@gmail.com','Lê Lợi'),
(3,3,"Nguyễn Văn C",'1992-11-28',123456789,8239483,'c@gmail.com','Lê Độ');
insert into khach_hang
values(4,4,"Nguyễn Văn A",'1990-11-28',123456789,8239483,'a@gmail.com','Đà Nẵng'),
(5,5,"Nguyễn Văn B",'1991-11-28',123456789,8239483,'b@gmail.com','Đà Nẵng'),
(6,6,"Nguyễn Văn C",'1992-11-28',123456789,8239483,'c@gmail.com','Quảng Trị');
delete from khach_hang
where (ID_khach_hang=1)or
(ID_khach_hang=2)or
(ID_khach_hang=3);
select * from khach_hang;
create table vi_tri(
ID_vi_tri int primary key not null, 
ten_vi_tri varchar(45));
insert into vi_tri
values (1,"Lễ tân"),(2,"Phục vụ"),(3,"Chuyên viên");
delete from vi_tri
where (ID_vi_tri=1)or
(ID_vi_tri=2)or
(ID_vi_tri=3);
select * from vi_tri;
create table bo_phan(
ID_bo_phan int primary key not null, 
ten_bo_phan varchar(45));
insert into bo_phan
values (1,"Hành chính"),(2,"Phục vụ"),(3,"Quản lý");
delete from bo_phan
where (ID_bo_phan=1)or
(ID_bo_phan=2)or
(ID_bo_phan=3);
select * from bo_phan;
create table trinh_do(
ID_trinh_do int primary key not null, 
ten_trinh_do varchar(45) not null);
insert into trinh_do
values (1,"đại học"),(2,"cao đẳng"),(3,"trung cấp");
select * from trinh_do;

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
insert into nhan_vien
values (1,'Lê Văn A',1,1,1,'1992-11-30',34346456,10000000,23534534,'abc@gmail','đà nẵng'),
(2,'Lê Văn B',2,2,2,'1993-11-30',3896456,10000000,23534534,'abc@gmail','đà nẵng'),
(3,'Lê Văn C',3,3,3,'1994-11-30',35346456,10000000,23534534,'abc@gmail','đà nẵng');
insert into nhan_vien
values (5,'Lê Hoang Tuan',3,3,3,'1994-11-30',35346456,10000000,23534534,'abc@gmail','đà nẵng'),
(6,'Ho Van Tuan',3,3,3,'1994-11-30',35346456,10000000,23534534,'abc@gmail','đà nẵng');
select * from nhan_vien;
delete from nhan_vien
where (ID_nhan_vien=1)or
(ID_nhan_vien=2)or
(ID_nhan_vien=3);

update nhan_vien
set dia_chi = 'Hải Châu'
where ID_nhan_vien = 1;

select * from khach_hang;


create table loai_dich_vu(
ID_loai_dich_vu int primary key not null,
ten_loai_dich_vu varchar(50)
);
insert into loai_dich_vu
values (1,"Villa"),(2,"House"),(3,"Room");
create table kieu_thue(
ID_kieu_thue int primary key not null,
ten_kieu_thue varchar(50),
gia int
);
insert into kieu_thue
values (1,"Năm",100000000),(2,"Tháng",10000000),(3,"Ngày",500000);
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
);
insert into dich_vu
values(1,'Villa',300,5,30,150,1,1,'Trống'),
(2,'House',200,3,30,150,2,2,'Trống'),
(3,'Room',100,1,30,150,3,3,'Trống');
create table dich_vu_di_kem(
ID_dich_vu_di_kem int primary key not null,
ten_dich_vu_di_kem varchar(50),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);
insert into dich_vu_di_kem
values(1,'Massage',300,1,'Trống'),
(2,'Karaoke',200,1,'Trống'),
(3,'Thuê xe',100,1,'Trống');
insert into dich_vu_di_kem
values(4,'Massage',300,1,'Trống'),
(5,'Karaoke',200,1,'Trống'),
(6,'Thuê xe',100,1,'Trống');

create table hop_dong(
ID_hop_dong int primary key not null,
ID_nhan_vien int,
ID_khach_hang int,
ID_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
foreign key (ID_nhan_vien) references nhan_vien(ID_nhan_vien),
foreign key (ID_khach_hang) references khach_hang(ID_khach_hang),
foreign key (ID_dich_vu) references dich_vu(ID_dich_vu)
);
alter table hop_dong
add foreign key (ID_khach_hang) references khach_hang(ID_khach_hang) on delete cascade;
select * from hop_dong;
insert into hop_dong
values(1,1,1,1,'2021-05-10','2021-05-13',1000000,5000000),
(2,2,2,2,'2021-05-10','2021-05-11',1000000,5000000),
(3,3,3,3,'2021-05-10','2021-05-12',1000000,5000000);
insert into hop_dong
values(4,4,4,1,'2021-05-10','2021-05-13',1000000,5000000),
(5,5,5,2,'2021-05-10','2021-05-11',1000000,5000000),
(6,6,6,3,'2021-05-10','2021-05-12',1000000,5000000);
delete from hop_dong
where ID_hop_dong like 7;
update hop_dong
set ID_nhan_vien = 6
where ID_hop_dong=5;
create table hop_dong_chi_tiet(
ID_hop_dong_chi_tiet int primary key not null,
ID_dich_vu_di_kem int,
ID_hop_dong int,
unique(ID_dich_vu_di_kem,ID_hop_dong),
so_luong int,
foreign key (ID_dich_vu_di_kem) references dich_vu_di_kem(ID_dich_vu_di_kem),
foreign key (ID_hop_dong) references hop_dong(ID_hop_dong)
);
drop table hop_dong_chi_tiet;
select * from hop_dong_chi_tiet;
insert into hop_dong_chi_tiet
values(1,1,1,3),
(2,2,2,3),
(3,3,3,3);
insert into hop_dong_chi_tiet
values(4,4,4,2),
(5,5,5,6),
(6,6,6,8);
insert into hop_dong_chi_tiet
values(7,4,5,2);
delete from hop_dong_chi_tiet
where ID_hop_dong_chi_tiet like 7;
update hop_dong_chi_tiet
set ID_dich_vu_di_kem = 1
where ID_dich_vu_di_kem in (4,5,6);
insert into hop_dong
values(7,3,4,3,'2018-05-5','2018-05-10',100000,3000000);

SET FOREIGN_KEY_CHECKS = 1;
