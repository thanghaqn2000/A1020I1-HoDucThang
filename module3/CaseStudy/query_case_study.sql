use furama_resorts;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có 
-- tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select *
from nhan_vien
where ((ho_ten like 'T%') or (ho_ten like 'H%') or (ho_ten like 'K%')) and char_length(ho_ten)<=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select *
from khach_hang
where ((SELECT TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) > 18) or (SELECT TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) <50)) and ( dia_chi in ('Đà Nẵng','Quảng Trị'))

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.ho_ten ,count(hd.id_hop_dong) as 'số lần đặt phòng'
from khach_hang kh
	inner join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang 
	inner join loai_khach lkh on lkh.id_loai_khach=kh.id_loai_khach
where lkh.ten_loai_khach='Diamond'
group by hd.id_khach_hang
order by 'số lần đặt phòng' 


