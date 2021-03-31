create database classicmodels;
use classicmodels;
create table customers(
	customer_name varchar(30),
    phone int ,
    city varchar(30),
    country varchar(30)
);
insert into customers
values 
('Duc Thang',123456789,'Hoi An','Viet Nam'),
 ('Duc Toan',123456789,'Da Nang','Viet Nam'),
 ('Tuong Vi',123456666,'Ha Noi','Viet Nam'),
 ('Tran Dan',123456666,'Quan Cam','America');
 SELECT * FROM customers;
 
 SELECT customer_name, phone, city FROM customers ;
 
 select * from customers where customer_name="Duc Thang";
 
 select * from customers where customer_name like '%D%';
 
 select * from customers where city regexp 'Hoi|Da';
 
 update customers
 set customer_name ='Dep trai'
 where city='Hoi An';
 
 delete from customers
 where customer_name like '%Dep%';
 
 
 alter table customers
 drop column id;
 
 ALTER TABLE  customers
 ADD column id INT NOT NULL  PRIMARY KEY AUTO_INCREMENT FIRST
 