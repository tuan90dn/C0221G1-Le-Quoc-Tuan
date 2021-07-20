create database quan_ly_vat_tu;
use quan_ly_vat_tu;
create table sdt(
id_sdt varchar(10) primary key not null,
ma_quoc_gia varchar(5)
);
create table nha_cc(
ma_nha_cc int primary key not null,
ten_nha_cc varchar(50),
dia_chi varchar(50),
id_sdt varchar(50),
foreign key (id_sdt) references sdt(id_sdt) 
);
create table don_hang(
so_DH int primary key not null,
ngay_DH date,
ma_nha_cc int,
foreign key (ma_nha_cc) references nha_cc(ma_nha_cc)
);
create table vat_tu(
ma_vt int primary key not null,
ten_vt varchar(50)
);
create table doi_chieu_don_hang_voi_vat_tu(
so_dh int,
ma_vt int,
primary key (so_dh,ma_vt),
foreign key (so_dh) references don_hang(so_dh),
foreign key (ma_vt) references vat_tu(ma_vt)
);
create table phieu_nhap(
so_PN int primary key not null,
ngay_nhap date
);
create table chi_tiet_nhap_vat_tu(
so_PN int,
ma_vt int,
primary key (so_PN,ma_vt),
dg_nhap varchar(50),
sl_nhap varchar(50),
foreign key (so_PN) references phieu_nhap(so_PN),
foreign key (ma_vt) references vat_tu(ma_vt)
);
create table phieu_nhap(
so_PN int primary key not null,
ngay_nhap date
);
drop table chi_tiet_nhap_vat_tu;
create table phieu_xuat(
so_PX int primary key not null,
ngay_xuat date
);
create table chi_tiet_xuat_vat_tu(
so_PX int,
ma_vt int,
primary key (so_PX,ma_vt),
dg_xuat varchar(50),
sl_xuat varchar(50),
foreign key (so_PX) references phieu_xuat(so_PX),
foreign key (ma_vt) references vat_tu(ma_vt)
);
drop table chi_tiet_xuat_vat_tu;



