use furama_resorts;
-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có 
-- tên bắt đầu là một trong các ký tự “H”, “T” hoặc “K” và có tối đa 15 ký tự.
select *
from nhan_vien
where ((ho_ten like 'T%') or (ho_ten like 'H%') or (ho_ten like 'K%')) and char_length(ho_ten)<=15;

-- 3.	Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng” hoặc “Quảng Trị”.
select * ,(SELECT TIMESTAMPDIFF(YEAR, khach_hang.ngay_sinh, CURDATE())) as Tuổi
from khach_hang
where ((SELECT TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) > 18) or (SELECT TIMESTAMPDIFF(YEAR, ngay_sinh, CURDATE()) <50)) 
and ( dia_chi in ('Đà Nẵng','Quảng Trị'));

-- 4.	Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. 
-- Kết quả hiển thị được sắp xếp tăng dần theo số lần đặt phòng của khách hàng. 
-- Chỉ đếm những khách hàng nào có Tên loại khách hàng là “Diamond”.
select kh.ho_ten ,lkh.ten_loai_khach,count(hd.id_hop_dong) as 'số lần đặt phòng'
from khach_hang kh
	inner join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang 
	inner join loai_khach lkh on lkh.id_loai_khach=kh.id_loai_khach
where lkh.ten_loai_khach='Diamond'
group by hd.id_khach_hang
order by 'số lần đặt phòng';

-- 5.	Hiển thị IDKhachHang, HoTen, TenLoaiKhach, IDHopDong, TenDichVu, NgayLamHopDong, NgayKetThuc, TongTien 
-- (Với TongTien được tính theo công thức như sau: ChiPhiThue + SoLuong*Gia, với SoLuong và Giá là từ bảng DichVuDiKem) 
-- cho tất cả các Khách hàng đã từng đặt phỏng. (Những Khách hàng nào chưa từng đặt phòng cũng phải hiển thị ra). 
select kh.id_khach_hang, kh.ho_ten, lk.ten_loai_khach,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,(dv.chi_phi_thue+hdct.so_luong*dvdk.gia) as 'Tổng tiền'
from khach_hang kh
	inner join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach
    left join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang
	left join dich_vu dv on dv.id_dich_vu =hd.id_dich_vu
	left join dich_vu_di_kem dvdk on dvdk.id_dich_vu =dv.id_dich_vu
	left join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong;
    
-- 6.	Hiển thị IDDichVu, TenDichVu, DienTich, ChiPhiThue, TenLoaiDichVu của tất cả các loại Dịch vụ 
-- 		chưa từng được Khách hàng thực hiện đặt từ quý 1 của năm 2019 (Quý 1 là tháng 1, 2, 3).

select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv
	inner join loai_dich_vu ldv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
    inner join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
where dv.id_dich_vu not in(
	select id_dich_vu
	from hop_dong hd
	where (month(ngay_lam_hop_dong))>=1 and (month(ngay_lam_hop_dong))<=3 
);


    
    
		





