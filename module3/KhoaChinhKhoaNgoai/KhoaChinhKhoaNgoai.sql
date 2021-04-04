create database bank;
use bank;
create table customers(
customer_number char(13) primary key,
account_number char(15),
full_name varchar(30),
address varchar(30),
email nchar(15),
phone int (11),
constraint fk_customers_account_number foreign key (account_number) references accounts(account_number)
);
create table accounts(
account_number char(15) primary key,
account_type varchar(30),
`date` date,
balance decimal(18,0) 
);
create table transactions(
tran_number char(13) primary key,
account_number char(15),
`date` date,
amounts int,
descriptions varchar(50),
constraint fk_transactions_account_number foreign key (account_number) references accounts(account_number)
);
