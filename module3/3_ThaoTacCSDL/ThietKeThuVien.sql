create database libary;
use libary;
create table book(
id_book int primary key not null,
ten_sach varchar(30),
nha_xb varchar(30),
tac_gia varchar(30),
gia_ban decimal(18,0),
anh char(10)
);
create table borrow_order(
id_borrow_order int primary key not null,
id_sinh_vien int,
ngay_muon date,
ngay_tra date,
constraint fk_id_sinh_vien_borrow_order foreign key (id_sinh_vien) 
references sinh_vien(id_sinh_vien)
);

create table sinh_vien(
id_sinh_vien int primary key not null,
ten_sinh_vien varchar(30),
ngay_sinh date,
dia_chi varchar(30),
email varchar(30),
anh char(10)
);

create table detail_book_order(
id_book int,
id_borrow_order int,
primary key(id_book,id_borrow_order),
constraint fk_id_sach_detail_book_order foreign key (id_book) references book(id_book),

constraint fk_id_borrow_order_detail_book_order foreign key (id_borrow_order) 
references borrow_order(id_borrow_order)
);
insert into sinh_vien
values (1,'Đức Thắng','2000/02/28','Hội An','thang@gmail.com','anh1'),
		(2,'Đức Toàn','2000/03/12','Đà Nẵng','thang@gmail.com','anh2'),
		(3,'Tường Vi','2000/05/18','Sài Gòn','thang@gmail.com','anh3');
        
insert into borrow_order
values (1,1,'2020/12/20',null),
		(2,2,'2020/12/20',null);

insert into book
values (11,'Ai rồi cũng iu','Kim đồng','Tuấn',150000,'anh11'),
	(12,'Ai rồi cũng khóc','Kim đồng','Mạnh',169000,'anh12');
    
insert into detail_book_order
values(12,2),
	(11,1);
    
    
select b.ten_sach,count(b.id_book) soluong
from sinh_vien s
		inner join borrow_order br on br.id_sinh_vien=s.id_sinh_vien
        inner join detail_book_order d on d.id_borrow_order=br.id_borrow_order
        right join book b on b.id_book=d.id_book
group by b.id_book
