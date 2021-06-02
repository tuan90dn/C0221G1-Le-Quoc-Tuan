
-- task 2

select * from nhan_vien
where (ho_ten like 'H%'
 or ho_ten like 'T%' 
 or ho_ten like 'K%') and (char_length(ho_ten)<=15) ;

 -- task 3
 
 select * from khach_hang
 where ((year(curdate())-year(khach_hang.ngay_sinh)) between 18 and 50)
 and (khach_hang.dia_chi='Đà Nẵng' or khach_hang.dia_chi ='Quảng Trị');
 
 -- task4
 
 select kh.ho_ten, loai_khach.ten_loai_khach,count(kh.ID_khach_hang) 'so_lan_dat_phong'
 from hop_dong h 
join khach_hang kh on h.ID_khach_hang = kh.ID_khach_hang
join loai_khach on kh.ID_loai_khach = loai_khach.ID_loai_khach
where loai_khach.ten_loai_khach = 'Diamond'
group by kh.ID_khach_hang;


-- task 5
 select kh.ID_khach_hang,kh.ho_ten,lk.ten_loai_khach,h.ID_hop_dong,dv.ten_dich_vu,
 h.ngay_lam_hop_dong,h.ngay_ket_thuc,dv.chi_phi_thue+hct.so_luong*dvk.gia 'tong_tien'
 from khach_hang kh
 join loai_khach lk on kh.ID_loai_khach=lk.ID_loai_khach
 left join hop_dong h on kh.ID_khach_hang = h.ID_khach_hang  
 left join dich_vu dv on h.ID_dich_vu = dv.ID_dich_vu 
 left join hop_dong_chi_tiet hct on hct.ID_hop_dong = h.ID_hop_dong
 left join dich_vu_di_kem dvk on hct.ID_dich_vu_di_kem = dvk.ID_dich_vu_di_kem 
 group by kh.ID_khach_hang,h.ID_hop_dong;
 

-- task 6

select dv.ID_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong,hd.ID_dich_vu
from dich_vu dv
left join hop_dong hd on dv.ID_dich_vu = hd.ID_dich_vu
join loai_dich_vu ldv on dv.ID_loai_dich_vu = ldv.ID_loai_dich_vu
where hd.ID_dich_vu is null or hd.ngay_lam_hop_dong not in
(select hd.ngay_lam_hop_dong from hop_dong hd where (month(hd.ngay_lam_hop_dong) in(1,2,3)) and year(hd.ngay_lam_hop_dong)=2019);

-- task 7
select * from dich_vu;
select * from hop_dong;
select dv.ID_dich_vu ,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu,dv.so_nguoi_toi_da,hd.ngay_lam_hop_dong
from dich_vu dv
join loai_dich_vu as ldv on dv.ID_loai_dich_vu = ldv.ID_loai_dich_vu
join hop_dong as hd on dv.ID_dich_vu = hd.ID_dich_vu
where (year(hd.ngay_lam_hop_dong) = 2018)
and hd.ID_dich_vu not in 
(select hd.ID_dich_vu from hop_dong hd
 where year(hd.ngay_lam_hop_dong) = 2019); 


-- task 8


select ho_ten from khach_hang
group by ho_ten;

select distinct ho_ten from khach_hang;

select ho_ten from khach_hang union 
select ho_ten from khach_hang;

-- task 9

select month(hd.ngay_lam_hop_dong) 'thang', year(hd.ngay_lam_hop_dong) 'nam',count(kh.ID_khach_hang) 'so_lan_dat_phong'
from khach_hang kh
join hop_dong hd
on  kh.ID_khach_hang = hd.ID_khach_hang
where (year(hd.ngay_lam_hop_dong) = 2021)
group by month(hd.ngay_lam_hop_dong);

-- task 10


select hd.ID_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc,sum(hct.so_luong)'so_luong_dich_vu_di_kem'
from hop_dong hd
join hop_dong_chi_tiet hct 
on hd.ID_hop_dong = hct.ID_hop_dong
join dich_vu_di_kem dvk
on dvk.ID_dich_vu_di_kem = hct.ID_dich_vu_di_kem
group by hd.ID_hop_dong;

-- task 11

select dvk.ten_dich_vu_di_kem,dvk.gia,kh.ho_ten
from khach_hang kh
join loai_khach lk on kh.ID_loai_khach = lk.ID_loai_khach
join hop_dong hd on kh.ID_khach_hang = hd.ID_khach_hang
join hop_dong_chi_tiet hct on hd.ID_hop_dong = hct.ID_hop_dong
join dich_vu_di_kem dvk on hct.ID_dich_vu_di_kem = dvk.ID_dich_vu_di_kem
where lk.ten_loai_khach = 'Diamond' and (kh.dia_chi = 'Quảng Ngãi' or kh.dia_chi = 'Vinh') ;

-- task 12
select hd.ID_hop_dong,nv.ho_ten'ho_ten_nhan_vien',kh.ho_ten 'ho_ten_khach_hang',kh.sdt 'sdt_khach_hang',dv.ten_dich_vu,hd.tien_dat_coc,hd.ngay_lam_hop_dong,count(hct.ID_hop_dong_chi_tiet)'so_luong_dich_vu_di_kem' 
from khach_hang kh
join loai_khach lk on kh.ID_loai_khach = lk.ID_loai_khach
join hop_dong hd on kh.ID_khach_hang = hd.ID_khach_hang
join dich_vu dv on hd.ID_dich_vu = dv.ID_dich_vu
join nhan_vien nv on hd.ID_nhan_vien = nv.ID_nhan_vien
join hop_dong_chi_tiet hct on hd.ID_hop_dong = hct.ID_hop_dong
join dich_vu_di_kem dvk on hct.ID_dich_vu_di_kem = dvk.ID_dich_vu_di_kem
where year(hd.ngay_lam_hop_dong) like 2019 and month(hd.ngay_lam_hop_dong) in (10,11,12) 
and hd.ID_dich_vu not in
(select hd.ID_dich_vu from hop_dong hd where year(hd.ngay_lam_hop_dong) like 2019 and month(hd.ngay_lam_hop_dong) between 1 and 6)
group by hct.ID_hop_dong_chi_tiet;

-- task 13

select ten_dich_vu_di_kem,gia,tong_so from  (select dvk.ID_dich_vu_di_kem,dvk.ten_dich_vu_di_kem,dvk.gia,dvk.don_vi,sum(hct.so_luong)'tong_so'
from dich_vu_di_kem dvk
inner join hop_dong_chi_tiet hct on dvk.ID_dich_vu_di_kem = hct.ID_dich_vu_di_kem
inner join hop_dong hd on hd.ID_hop_dong = hct.ID_hop_dong
group by dvk.ten_dich_vu_di_kem)x
where tong_so >= all (select tong_so from so_lan_su_dung_dvdk) ;




-- task 14

select ten_dich_vu_di_kem,tong_so from (select dvk.ten_dich_vu_di_kem,dvk.gia,dvk.don_vi,sum(hct.so_luong)'tong_so'
from dich_vu_di_kem dvk
inner join hop_dong_chi_tiet hct on dvk.ID_dich_vu_di_kem = hct.ID_dich_vu_di_kem
inner join hop_dong hd on hd.ID_hop_dong = hct.ID_hop_dong
group by dvk.ten_dich_vu_di_kem)x
where x.tong_so = 1;

-- task 15

select nv.ID_nhan_vien,nv.ho_ten,trinh_do.ten_trinh_do,
bo_phan.ten_bo_phan,nv.sdt,nv.dia_chi,count(hd.ID_nhan_vien) 'so_hop_dong_da_lap'
from nhan_vien nv
inner join trinh_do on trinh_do.ID_trinh_do = nv.ID_trinh_do
inner join bo_phan on bo_phan.ID_bo_phan = nv.ID_bo_phan
inner join hop_dong hd on hd.ID_nhan_vien = nv.ID_nhan_vien
where year(hd.ngay_lam_hop_dong) between 2018 and 2019
group by hd.ID_nhan_vien
having so_hop_dong_da_lap < 4;


-- task 16 

delete from nhan_vien
where ID_nhan_vien not in (select ID_nhan_vien
from (select nhan_vien.ID_nhan_vien from nhan_vien
join hop_dong
on nhan_vien.ID_nhan_vien = hop_dong.ID_nhan_vien
where year(hop_dong.ngay_lam_hop_dong) between 2017 and 2019)x);

-- task 17


 update loai_khach
 set ten_loai_khach ='Diamond'
 where ten_loai_khach = 'Platinum' and ten_loai_khach in (select ten_loai_khach from (select kh.ID_khach_hang,kh.ho_ten,lk.ten_loai_khach,h.ID_hop_dong,dv.ten_dich_vu,
 h.ngay_lam_hop_dong,h.ngay_ket_thuc,dv.chi_phi_thue+hct.so_luong*dvk.gia 'tong_tien'
 from khach_hang kh
 join loai_khach lk on kh.ID_loai_khach=lk.ID_loai_khach
 left join hop_dong h on kh.ID_khach_hang = h.ID_khach_hang  
 left join dich_vu dv on h.ID_dich_vu = dv.ID_dich_vu 
 left join hop_dong_chi_tiet hct on hct.ID_hop_dong = h.ID_hop_dong
 left join dich_vu_di_kem dvk on hct.ID_dich_vu_di_kem = dvk.ID_dich_vu_di_kem
 where year(h.ngay_lam_hop_dong) = 2019
 group by kh.ID_khach_hang)x where x.tong_tien > 10000000);
 
 -- task 18
 delete from khach_hang
 where ID_khach_hang in (select ID_khach_hang from (select kh.ID_khach_hang
 from khach_hang kh
 inner join hop_dong hd
 on kh.ID_khach_hang = hd.ID_khach_hang
 where year(hd.ngay_lam_hop_dong) < 2016)x);
 
 -- task 19
 create or replace view  so_lan_su_dung_dvdk as
 select dvk.ID_dich_vu_di_kem,dvk.ten_dich_vu_di_kem,dvk.gia,dvk.don_vi,sum(hct.so_luong)'tong_so'
from dich_vu_di_kem dvk
inner join hop_dong_chi_tiet hct on dvk.ID_dich_vu_di_kem = hct.ID_dich_vu_di_kem
inner join hop_dong hd on hd.ID_hop_dong = hct.ID_hop_dong
group by dvk.ten_dich_vu_di_kem;


update dich_vu_di_kem
set gia = gia*2
where ID_dich_vu_di_kem in (select ID_dich_vu_di_kem from so_lan_su_dung_dvdk where so_lan_su_dung_dvdk.tong_so > 10);

-- task 20

select ID_khach_hang ID,ho_ten,email,sdt,ngay_sinh,dia_chi,1 as 'type'
from khach_hang
union all
select ID_nhan_vien,ho_ten,email,sdt,ngay_sinh,dia_chi,0 as 'type'
from nhan_vien;

-- task 21
create or replace view v_nhan_vien as
select nv.ID_nhan_vien,nv.ho_ten,nv.dia_chi,hd.ngay_lam_hop_dong from nhan_vien nv
join hop_dong hd
on nv.ID_nhan_vien = hd.ID_nhan_vien
where nv.dia_chi = 'đà nẵng' and hd.ngay_lam_hop_dong = '2018-02-10'
;
select * from v_nhan_vien;

-- task 22

update nhan_vien
set dia_chi = 'Liên Chiểu'
where ID_nhan_vien in (select ID_nhan_vien from (select ID_nhan_vien from v_nhan_vien)x);

-- task 23
delimiter //

create procedure sp_1(in p_id int)
begin
delete from khach_hang
where ID_khach_hang=p_id;
end //

delimiter ;

-- task 24
DELIMITER //
CREATE  PROCEDURE sp_2(
p_ID_hop_dong int ,
p_ID_nhan_vien int,
p_ID_khach_hang int,
p_ID_dich_vu int,
p_ngay_lam_hop_dong date,
p_ngay_ket_thuc date,
p_tien_dat_coc int,
p_tong_tien int
)
begin
if (p_ID_hop_dong not in (select ID_hop_dong from hop_dong)
and p_ID_nhan_vien in (select ID_nhan_vien from nhan_vien)
and p_ID_khach_hang in (select ID_khach_hang from khach_hang)
and p_ID_dich_vu in (select ID_dich_vu from dich_vu))
then
insert into hop_dong
values (p_ID_hop_dong,p_ID_nhan_vien,p_ID_khach_hang,p_ID_dich_vu,p_ngay_lam_hop_dong,
p_ngay_ket_thuc,p_tien_dat_coc,p_tong_tien);
else select concat('Wrong input') as 'Error';
end if;
end //
DELIMITER ;

call sp_2(7,3,4,3,'2018-05-5','2018-05-10',100000,1000000);
select * from hop_dong;
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = '...';


-- task 25
delimiter //

create trigger tr_1 after delete on hop_dong for each row
begin
declare so_luong_hd int;
insert into luu_hop_dong
values (OLD.ID_hop_dong,OLD.ID_nhan_vien,OLD.ID_khach_hang,OLD.ID_dich_vu,OLD.ngay_lam_hop_dong,OLD.ngay_ket_thuc,OLD.tien_dat_coc,OLD.tong_tien);
set so_luong_hd = (select count(ID_hop_dong) from hop_dong);
insert into so_luong_hd_con_lai
values(so_luong_hd);
end //

delimiter ;

drop trigger tr_1;
delete from hop_dong
where ID_hop_dong = 7;

delimiter //
create procedure lay_record()
begin
select count(*) from hop_dong
where ID_khach_hang=p_id;
end //

delimiter ;
call lay_record(6);
select * from khach_hang
where ID_khach_hang=6;
create table so_luong_hd_con_lai(so_luong_hd int);
create table luu_hop_dong(
ID_hop_dong int primary key not null,
ID_nhan_vien int,
ID_khach_hang int,
ID_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int);

-- task 26
delimiter //
create trigger tr_2 before update on hop_dong for each row
begin
if datediff(NEW.ngay_ket_thuc,OLD.ngay_lam_hop_dong)<2
then 
SIGNAL SQLSTATE '02000' SET MESSAGE_TEXT = 'Ngày kết thúc hợp đồng phải lớn hơn ngày làm hợp đồng ít nhất là 2 ngày';
end if;
end //

delimiter ;
drop trigger tr_2;

update hop_dong
set ngay_ket_thuc='2018-02-15'
where ngay_ket_thuc='2018-02-12';

