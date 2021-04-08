#create database furama_resorts,
use furama_resorts,
create table dich_vu(
id_dich_vu int primary key not null auto_increment,
id_loai_dich_vu int,
id_kieu_thue int,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
trang_thai varchar(45),
constraint fk_id_loai_dich_vu_dich_vu foreign key (id_loai_dich_vu) references loai_dich_vu(id_loai_dich_vu),
constraint fk_id_kieu_thue_dich_vu foreign key (id_kieu_thue) references kieu_thue(id_kieu_thue)
);

create table loai_dich_vu(
id_loai_dich_vu int primary key not null auto_increment,
ten_loai_dich_vu varchar(45)
);

create table kieu_thue(
id_kieu_thue int primary key not null auto_increment,
ten_kieu_thue varchar(45),
gia decimal(18,0)
);

create table dich_vu_di_kem(
id_dich_vu_di_kem int primary key not null auto_increment,
id_dich_vu int ,
ten_dich_vu_di_kem varchar(45),
gia decimal(18,0),
donvi int,
trang_thai_kha_dung varchar(45),
constraint fk_id_dich_vu_di_kem
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table khach_hang(
id_khach_hang int primary key not null auto_increment,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd char(9),
sdt char(10),
email varchar(50),
dia_chi varchar(50),
constraint fk_id_loai_khach_hang_khach_hang
foreign key (id_loai_khach) references loai_khach(id_loai_khach)
);

create table loai_khach(
id_loai_khach int primary key not null auto_increment,
ten_loai_khach varchar(45)
);

create table nhan_vien(
id_nhan_vien int primary key not null auto_increment,
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ho_ten varchar(50),
ngay_sinh date,
cmnd char(9),
luong decimal(18,0),
sdt char(11),
email varchar(45),
dia_chi varchar(45),

constraint fk_id_vi_tri_nhan_vien
foreign key(id_vi_tri) references vi_tri(id_vi_tri),

constraint fk_id_trinh_do_nhan_vien
foreign key (id_trinh_do) references trinh_do(id_trinh_do),

constraint fk_id_bo_phan_nhan_vien
foreign key (id_bo_phan) references bo_phan(id_bo_phan)
);

create table vi_tri(
id_vi_tri int primary key not null auto_increment,
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int primary key not null auto_increment,
ten_trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int primary key not null auto_increment,
ten_bo_phan varchar(45)
);

create table hop_dong(
id_hop_dong int primary key not null auto_increment,
id_nhan_vien int ,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc decimal(18,0),
tong_tien decimal(18,0),

constraint fk_id_nhan_vien_hop_dong
foreign key (id_nhan_vien) references nhan_vien(id_nhan_vien),

constraint fk_id_khach_hang_hop_dong
foreign key (id_khach_hang) references khach_hang(id_khach_hang),

constraint fk_id_dich_vu_hop_dong
foreign key (id_dich_vu) references dich_vu(id_dich_vu)
);

create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet  int primary key not null auto_increment,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,

constraint fk_id_hop_dong_hop_dong_chi_tiet
foreign key (id_hop_dong) references hop_dong(id_hop_dong),

constraint fk_id_dich_vu_di_kem_hop_dong_chi_tiet
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem(id_dich_vu_di_kem)
);




