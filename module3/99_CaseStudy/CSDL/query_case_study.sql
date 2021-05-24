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

select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong
from dich_vu dv
	inner join loai_dich_vu ldv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
    inner join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
where dv.id_dich_vu not in(
	select id_dich_vu
	from hop_dong hd
	where (month(ngay_lam_hop_dong))>=1 and (month(ngay_lam_hop_dong))<=3  and (year(ngay_lam_hop_dong))=2019
);

-- 7.	Hiển thị thông tin IDDichVu, TenDichVu, DienTich, SoNguoiToiDa, ChiPhiThue, TenLoaiDichVu 
-- của tất cả các loại dịch vụ đã từng được Khách hàng đặt phòng trong năm 2018 nhưng chưa từng 
-- được Khách hàng đặt phòng  trong năm 2019.
select dv.id_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.so_nguoi_toi_da,dv.chi_phi_thue,ldv.ten_loai_dich_vu,hd.ngay_lam_hop_dong
from dich_vu dv
	inner join loai_dich_vu ldv on ldv.id_loai_dich_vu=dv.id_loai_dich_vu
    inner join hop_dong hd on hd.id_dich_vu=dv.id_dich_vu
where  dv.id_dich_vu in(
	select hd.id_dich_vu
    from hop_dong hd
    where (year(hd.ngay_lam_hop_dong))=2018 and hd.id_dich_vu =dv.id_dich_vu
) and dv.id_dich_vu not in (select hd.id_dich_vu
    from hop_dong hd
    where (year(hd.ngay_lam_hop_dong))=2019 and hd.id_dich_vu =dv.id_dich_vu);

-- 8.	Hiển thị thông tin HoTenKhachHang có trong hệ thống, với yêu cầu HoThenKhachHang không trùng nhau.
-- cách 1
select distinct ho_ten
from khach_hang;
-- cách 2
select ho_ten 
from khach_hang
union
select ho_ten 
from khach_hang;
-- cách 3
select ho_ten
from khach_hang
group by ho_ten;

-- 9.	Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với
--  mỗi tháng trong năm 2019 thì sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select hd.ngay_lam_hop_dong,count(hd.id_khach_hang) as `số lượng đặt phòng`,sum(hd.tong_tien) as DoanhThu
from hop_dong hd
	inner join khach_hang kh on kh.id_khach_hang = hd.id_khach_hang
where (year(hd.ngay_lam_hop_dong))=2019
group by (month(hd.ngay_lam_hop_dong))
order by `số lượng đặt phòng` desc;

-- 10.	Hiển thị thông tin tương ứng với từng Hợp đồng thì đã sử dụng bao nhiêu Dịch vụ đi kèm. 
-- Kết quả hiển thị bao gồm IDHopDong, NgayLamHopDong, NgayKetthuc, TienDatCoc, 
-- SoLuongDichVuDiKem (được tính dựa trên việc count các IDHopDongChiTiet).

select hd.id_hop_dong,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,hd.tien_dat_coc, count(hdct.id_dich_vu_di_kem) as `Số lượng dịch vụ đi kèm`
from hop_dong hd
	inner join hop_dong_chi_tiet hdct on hdct.id_hop_dong=hd.id_hop_dong
group by (hd.id_hop_dong);

-- 11.	Hiển thị thông tin các Dịch vụ đi kèm đã được sử dụng bởi những Khách hàng
--  có TenLoaiKhachHang là “Diamond” và có địa chỉ là “Vinh” hoặc “Quảng Ngãi”.
select dvdk.id_dich_vu_di_kem,dvdk.id_dich_vu,hd.id_hop_dong,kh.ho_ten,dvdk.ten_dich_vu_di_kem,dvdk.gia,dvdk.donvi,dvdk.trang_thai_kha_dung
from dich_vu_di_kem dvdk
	inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem =dvdk.id_dich_vu_di_kem
    inner join hop_dong hd on hd.id_hop_dong=hdct.id_hop_dong
    inner join khach_hang kh on kh.id_khach_hang=hd.id_khach_hang
    inner join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach
where (lk.ten_loai_khach='Diamond') and ( kh.dia_chi in ('Vinh','Quảng Ngãi'));

-- 12.	Hiển thị thông tin IDHopDong, TenNhanVien, TenKhachHang, SoDienThoaiKhachHang, TenDichVu, SoLuongDichVuDikem 
-- (được tính dựa trên tổng Hợp đồng chi tiết), TienDatCoc của tất cả các dịch vụ đã từng được khách hàng đặt vào 3
--  tháng cuối năm 2019 nhưng chưa từng được khách hàng đặt vào 6 tháng đầu năm 2019.
select hd.id_hop_dong , nv.ho_ten , kh.ho_ten,kh.sdt,dv.ten_dich_vu
from hop_dong hd
	inner join nhan_vien nv on nv.id_nhan_vien=hd.id_nhan_vien
    inner join khach_hang kh on kh.id_khach_hang =kh.id_khach_hang
    inner join hop_dong_chi_tiet hdct on hdct.id_hop_dong =hd.id_hop_dong
    inner join dich_vu dv on dv.id_dich_vu = hd.id_dich_vu
where dv.id_dich_vu in(
	select hd.id_dich_vu
    from hop_dong hd
    where (month(hd.ngay_lam_hop_dong)>=10 and month(hd.ngay_lam_hop_dong)<=12) and year(hd.ngay_lam_hop_dong)=2019 and hd.id_dich_vu=dv.id_dich_vu
) and dv.id_dich_vu not in(
	select hd.id_dich_vu
    from hop_dong hd
    where (month(hd.ngay_lam_hop_dong)>=1 and month(hd.ngay_lam_hop_dong)<=6) and year(hd.ngay_lam_hop_dong)=2019 and hd.id_dich_vu=dv.id_dich_vu);
	
-- 13.	Hiển thị thông tin các Dịch vụ đi kèm được sử dụng nhiều nhất bởi các Khách hàng đã đặt phòng. 
-- (Lưu ý là có thể có nhiều dịch vụ có số lần sử dụng nhiều như nhau).
-- select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem, count(hdct.id_hop_dong) as quantity_order
-- from dich_vu_di_kem dvdk
-- 	inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
-- group by (dvdk.id_dich_vu_di_kem)
-- order by quantity_order desc
-- limit 1;

SELECT dvdk.*,(temp.quantity_order) quantity_order
FROM dich_vu_di_kem dvdk
INNER JOIN(
   select dvdk.id_dich_vu_di_kem,dvdk.ten_dich_vu_di_kem, count(hdct.id_hop_dong) as quantity_order
	from dich_vu_di_kem dvdk
		inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
		group by (dvdk.id_dich_vu_di_kem)
		order by quantity_order desc
) temp
ON temp.id_dich_vu_di_kem = dvdk.id_dich_vu_di_kem
having quantity_order=3;


select dvdk.*, count(dvdk.id_dich_vu_di_kem) as sudung
from dich_vu_di_kem dvdk
	left join hop_dong_chi_tiet hdct
	on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
group by dvdk.id_dich_vu_di_kem
having sudung in (
	select tmp.sudung
    from (
	select count(dvdk.id_dich_vu_di_kem) as sudung
	from dich_vu_di_kem dvdk
		left join hop_dong_chi_tiet hdct
		on dvdk.id_dich_vu_di_kem = hdct.id_dich_vu_di_kem
	group by dvdk.id_dich_vu_di_kem
	order by sudung desc
    limit 1) as tmp
);

-- 14.	Hiển thị thông tin tất cả các Dịch vụ đi kèm chỉ mới được sử dụng một lần duy nhất. 
-- Thông tin hiển thị bao gồm IDHopDong, TenLoaiDichVu, TenDichVuDiKem, SoLanSuDung

select hdct.id_hop_dong,dvdk.ten_dich_vu_di_kem, count(hdct.id_hop_dong) as quantity_use
from dich_vu_di_kem dvdk
	inner join hop_dong_chi_tiet hdct on hdct.id_dich_vu_di_kem=dvdk.id_dich_vu_di_kem
group by (dvdk.id_dich_vu_di_kem)
having quantity_use=1;

-- 15.	Hiển thi thông tin của tất cả nhân viên bao gồm IDNhanVien, HoTen, TrinhDo, TenBoPhan, 
-- SoDienThoai, DiaChi mới chỉ lập được tối đa 3 hợp đồng từ năm 2018 đến 2019.
select nv.id_nhan_vien,nv.ho_ten,count(hd.id_hop_dong) as `số hợp đồng`
from nhan_vien nv
	inner join hop_dong hd on hd.id_nhan_vien=nv.id_nhan_vien
where year(hd.ngay_lam_hop_dong) =2018 or year(hd.ngay_lam_hop_dong)=2019 
group by (nv.id_nhan_vien) 
having `số hợp đồng`>=1 and `số hợp đồng` <=3;

-- 16.	Xóa những Nhân viên chưa từng lập được hợp đồng nào từ năm 2017 đến năm 2019.
-- cách anh hải
delete from nhan_vien where not exists(
select nhan_vien.id_nhan_vien 
from hop_dong
where year(hop_dong.ngay_lam_hop_dong)>=2017 and year(hop_dong.ngay_lam_hop_dong)<=2019 and hop_dong.id_nhan_vien =nhan_vien.id_nhan_vien);

-- cách 2
delete from nhan_vien
where nhan_vien.id_nhan_vien not in 
 (
	select id_nhan_vien
    from(
		select hd.id_nhan_vien
		from hop_dong hd
		inner join nhan_vien nv on nv.id_nhan_vien=hd.id_nhan_vien
		where year(hd.ngay_lam_hop_dong) >=2017 or year(hd.ngay_lam_hop_dong)<=2019 and hd.id_nhan_vien=nv.id_nhan_vien
		group by (nv.id_nhan_vien) 
		having count(hd.id_hop_dong)>=1
        )as tmp
       --  k cần dùng delete cascade
);
    
-- 17.	Cập nhật thông tin những khách hàng có TenLoaiKhachHang từ  Platinium lên Diamond, 
-- chỉ cập nhật những khách hàng đã từng đặt phòng với tổng Tiền thanh toán trong năm 2019
-- là lớn hơn 10.000.000 VNĐ.
update khach_hang ,(
select kh.id_khach_hang
from khach_hang kh
	inner join hop_dong hd on hd.id_khach_hang=kh.id_khach_hang
    inner join loai_khach lk on lk.id_loai_khach = kh.id_loai_khach
where hd.tong_tien > 10000000 and lk.ten_loai_khach='Platinium' and year(hd.ngay_lam_hop_dong)=2019) as TongTien_Kh100
set khach_hang.id_loai_khach=1
where khach_hang.id_khach_hang =TongTien_Kh100.id_khach_hang;

-- câu 18 done cách anh Hải
delete hop_dong_chi_tiet,hop_dong,khach_hang
from khach_hang 
inner join hop_dong on hop_dong.id_khach_hang=khach_hang.id_khach_hang
inner join hop_dong_chi_tiet on hop_dong_chi_tiet.id_hop_dong=hop_dong.id_hop_dong
where not exists (select hop_dong.id_hop_dong where year(hop_dong.ngay_lam_hop_dong)>2016 and khach_hang.id_khach_hang=hop_dong.id_khach_hang);

-- 18.	Xóa những khách hàng có hợp đồng trước năm 2016 (chú ý ràng buộc giữa các bảng).
-- cách anh Tiến
delete from khach_hang
where id_khach_hang in(
	select id_khach_hang
	from hop_dong
	where year(ngay_lam_hop_dong) < 2016
    -- dùng on delete cascade
);

-- 19.	Cập nhật giá cho các Dịch vụ đi kèm được sử dụng trên 10 lần trong năm 2019 lên gấp đôi.
update dich_vu_di_kem as dvdk,
(select hop_dong_chi_tiet.id_dich_vu_di_kem, count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as SoLanSuDung 
from hop_dong 
	inner join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
where Year(hop_dong.ngay_lam_hop_dong) = 2019 or Year(hop_dong.ngay_lam_hop_dong) = 2020
group by hop_dong_chi_tiet.id_dich_vu_di_kem) as DichVuDiKem2019
set dvdk.gia = dvdk.gia * 2
where dvdk.id_dich_vu_di_kem = DichVuDiKem2019.id_dich_vu_di_kem
and DichVuDiKem2019.SolanSuDung > 2;


-- 20.	Hiển thị thông tin của tất cả các Nhân viên và Khách hàng có trong hệ thống, 
-- thông tin hiển thị bao gồm ID (IDNhanVien, IDKhachHang), HoTen, Email, SoDienThoai, NgaySinh, DiaChi.
select concat('Nhân viên - ',id_nhan_vien) id, ho_ten, email, sdt, ngay_sinh, dia_Chi 
from nhan_vien 
union all
select concat('Khách hàng - ',id_khach_hang),  ho_ten, email, sdt, ngay_sinh, dia_Chi 
from khach_hang;

-- 21.	Tạo khung nhìn có tên là V_NHANVIEN để lấy được thông tin của tất cả các nhân viên có địa chỉ là 
-- “Hội An” và đã từng lập hợp đồng cho 1 hoặc nhiều Khách hàng bất kỳ  với ngày lập hợp đồng là “2019-02-21”
create view V_NHANVIEN
as
select nv.* ,count(hd.id_hop_dong) sohopdong
from nhan_vien nv
	inner join hop_dong hd on hd.id_nhan_vien=nv.id_nhan_vien 
where  hd.ngay_lam_hop_dong='2019-02-21' and nv.dia_chi='Hội An';


select * from V_NHANVIEN;

-- 22.	Thông qua khung nhìn V_NHANVIEN thực hiện cập nhật địa chỉ thành “Liên Chiểu” 
-- đối với tất cả các Nhân viên được nhìn thấy bởi khung nhìn này.

update nhan_vien nv
set nv.dia_chi='Liên Chiểu'
where nv.id_nhan_vien=(select id_nhan_vien from V_NHANVIEN);

-- 23.	Tạo Store procedure Sp_1 Dùng để xóa thông tin của một Khách hàng nào đó với Id Khách hàng được truyền vào như là 1 tham số của Sp_1
delimiter //
create procedure sp_delete_by_id_kh (in p_id_kh int)
begin
	delete from khach_hang
    
end;
// delimiter ;

use furama_resorts;

-- khach hang
select kh.id_khach_hang,kh.ho_ten ,lk.ten_loai_khach, kh.ngay_sinh,kh.so_cmnd,kh.sdt,kh.email,kh.dia_chi
from khach_hang kh 
left join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach;

insert into khach_hang(id_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi)
values  (3,'Duc Thang','2000/08/19','123456789','0916890776','thanghaqn2001@gmail.com','da nang');

delete from khach_hang kh
where id_khach_hang =12;

update khach_hang
set id_loai_khach=1,ho_ten='Đức Thiện',ngay_sinh='2019/02/03',so_cmnd='123456789',sdt='0916890776',email='thien@gmail.com',dia_chi='Thanh Tay'
where id_khach_hang=39;

select id_khach_hang,lk.id_loai_khach,lk.ten_loai_khach,ho_ten,ngay_sinh,so_cmnd,sdt,email,dia_chi
 from khach_hang kh
 left join loai_khach lk on lk.id_loai_khach=kh.id_loai_khach
where ((ho_ten like '%Th%'));

-- dich vu
-- 1 select *
select id_dich_vu,ten_loai_dich_vu,ten_kieu_thue,ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,trang_thai
from dich_vu dv
left join loai_dich_vu ldv on ldv.id_loai_dich_vu = dv.id_loai_dich_vu
left join kieu_thue kt on kt.id_kieu_thue = dv.id_kieu_thue;

-- 2 insert
insert into dich_vu(id_loai_dich_vu,id_kieu_thue,ten_dich_vu,dien_tich,so_tang,so_nguoi_toi_da,chi_phi_thue,trang_thai)
values (1,3,'Villa theo ngay',350,3,'15','150000000','Tệ');

-- nhan vien
-- select *
select id_nhan_vien,ten_vi_tri,ten_trinh_do,ten_bo_phan,ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi
from nhan_vien nv
left join vi_tri vt on vt.id_vi_tri=nv.id_vi_tri
left join trinh_do td on td.id_trinh_do=nv.id_trinh_do
left join bo_phan bp on bp.id_bo_phan=nv.id_bo_phan;

-- insert

insert into nhan_vien(id_vi_tri,id_trinh_do,id_bo_phan,ho_ten,ngay_sinh,cmnd,luong,sdt,email,dia_chi ) 
values (5,3,4,'Bảo Ngọc','2010/09/11','123456789',6000000,'12345678999','vi@gmail.com','Hội An');

-- delete
delete from nhan_vien
where id_nhan_vien=5;






 

		





