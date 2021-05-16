
-- task 2

select * from nhan_vien
where (ho_ten like 'H%'
 or ho_ten like 'T%' 
 or ho_ten like 'K%') and (char_length(ho_ten)<15) ;
 
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
 order by kh.ID_khach_hang;

-- task 6

select dv.ID_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong,hd.ID_dich_vu
from dich_vu dv
left join hop_dong hd on dv.ID_dich_vu = hd.ID_dich_vu
join loai_dich_vu ldv on dv.ID_loai_dich_vu = ldv.ID_loai_dich_vu
where hd.ID_dich_vu is null or not ((month(hd.ngay_lam_hop_dong)>3) and (year(hd.ngay_lam_hop_dong)=2019) or (year(hd.ngay_lam_hop_dong) in (2020,2021)));

-- task 7
select * from dich_vu;
select * from hop_dong;
select dv.ID_dich_vu ,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu,dv.so_nguoi_toi_da,hd.ngay_lam_hop_dong
from dich_vu dv
join loai_dich_vu as ldv on dv.ID_loai_dich_vu = ldv.ID_loai_dich_vu
join hop_dong as hd on dv.ID_dich_vu = hd.ID_dich_vu
where (year(hd.ngay_lam_hop_dong) like 2018)
and hd.ID_dich_vu not in 
(select hd.ID_dich_vu from hop_dong hd
 where year(hd.ngay_lam_hop_dong) like 2019); 


-- task 8

select ho_ten from khach_hang
group by ho_ten;

select distinct ho_ten from khach_hang;

-- task 9

select month(hd.ngay_lam_hop_dong) 'thang', year(hd.ngay_lam_hop_dong) 'nam',count(kh.ID_khach_hang) 'so_lan_dat_phong'
from khach_hang kh
join hop_dong hd
on  kh.ID_khach_hang = hd.ID_khach_hang
where (year(hd.ngay_lam_hop_dong) like 2021)
group by month(hd.ngay_lam_hop_dong);


