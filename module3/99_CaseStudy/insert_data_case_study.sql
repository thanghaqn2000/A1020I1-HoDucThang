use furama_resorts;

insert into loai_khach
values  (1,'Diamond'),
		(2,'Platinium'),
		(3,'Gold'),
		(4,'Silver'),
		(5,'Member');
-- DELETE FROM `furama_resorts`.`loai_khach` WHERE (`id_loai_khach` = '1');

insert into khach_hang
values  (1,3,'Hồ Đức Thắng','2000/09/18','181112345','1234567890','thang@gmail.com','Hội An'),
		(2,4,'Trần A','1999/10/12','181112345','1234567190',null,'Đà Nẵng'),
		(3,1,'Lê hào ','2002/07/18','181112845','1234563890','thang@gmail.com','Quảng Trị'),
		(4,5,'Nguyễn Thị Tuyết','2001/12/30','181212345','1234567890','thang@gmail.com','Huế'),
		(5,1,'Hồ Đức Thắng','2000/09/18','181532345','1238267890',null,'Hội An'),
        (8,1,'Nguyễn Thị Hoa','2000/09/18','181532345','1238267890',null,'Hội An');
insert into loai_dich_vu
values(1,'Villa'),
	  (2,'Room'),
	  (3,'House');

insert into kieu_thue
values (1,'year',500000),
	   (2,'month',600000),
	   (3,'day',700000);
insert into dich_vu
values (1,1,3,'Villa theo ngay',350,3,'15','150000000','Tot'),
	   (2,2,2,'Room theo tháng',120,4,'10','300000000','Tốt'),
 	   (3,3,3,'House theo ngày',241,6,'15','150000000','bình Thường'),
       (4,1,1,'Villa theo năm',350,3,'6','1500000000','Tốt'),
	   (5,3,1,'House theo năm',250,3,'15','250000000','Tot');
insert into dich_vu_di_kem
values  (1,1,'karaoke',350000,35000,'Chưa ai thuê'),
	   (2,2,'massage',150000,15000,'Đã có'),
	   (3,3,'thuê xe',750000,75000,'Chưa ai thuê'),
	   (4,4,'thức ăn',250000,25000,'Chưa ai thuê');

insert into trinh_do
values (1,'Đại học'),
	   (3,'Cao đẳng'),
	   (2,'trung cấp'),
	   (4,'Sau đại học');
insert into bo_phan
values (1,'Sale – Marketing'),
       (2,'Hành chính'),
       (3,'Quản lí'),
       (4,'Phục vụ');
insert into vi_tri
values (1,'Giám đốc'),
	   (2,'Quản lí'),
	   (3,'Giám sát'),
	   (4,'chuyên viên'),
	   (5,'phục vụ'),
	   (6,'Lễ tân');
insert into nhan_vien
values (1,6,3,4,'Tường vi','2000/09/11','123456789',6000000,'12345678999','vi@gmail.com','Hội An'),
	   (2,1,1,2,'Đức Thắng','2000/09/18','123456787',100000000,'33345678999','thang@gmail.com','Hội An'),
	   (3,5,2,4,'Văn Hậu','2001/10/12','123456653',4000000,'33345678542','hau@gmail.com','Đà Nẵng'),
	   (4,5,2,4,'Trần Thanh','2001/10/12','123456653',10000000,'33345678111','trung@gmail.com','Huế');
insert into hop_dong
values (1,4,5,1,'2019/03/02','2021/03/05',2000000,10000000),
	   (2,4,2,1,'2019/02/22','2021/03/01',2000000,11000000),
	   (3,3,4,2,'2019/03/29','2021/04/02',1500000,9000000),
	   (4,1,1,3,'2019/02/21','2021/02/25',1000000,80000000),
       (6,4,5,5,'2020/04/02','2021/04/02',3000000,20000000),
       (7,4,3,3,'2018/05/01','2018/05/20',3000000,20000000),
       (8,3,5,4,'2018/10/01','2018/11/20',4000000,50000000),
       (9,3,8,4,'2015/04/02','2015/07/20',4000000,50000000);
       
insert into hop_dong_chi_tiet
values (1,1,1,5),
       (2,2,3,10),
       (3,3,2,6),
       (4,4,4,7),
       (5,5,3,2),
	   (6,6,2,4),
	   (7,7,1,2),
	   (8,8,4,6),
       (9,1,2,3),
	   (10,9,1,5);
       
       

        