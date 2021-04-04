create database cars_management;
use cars_management;

create table product(
id_product int primary key not null auto_increment,
id_product_line int ,
productName  varchar(70) not null,
productScale varchar(10) not null,
productVendor varchar(50) not null,
productDescription varchar(70) not null,
quantityInStock  int not null,
buyPrice decimal(18,0) not null,
MSRP decimal(18,0) not null,
constraint id_product_line_product foreign key (id_product_line) references product_line(id_product_line)
);
create table product_line(
id_product_line int primary key not null auto_increment,
textDescription   varchar(70) not null,
image  varchar(10) not null
);
create table employee(
id_employee int primary key not null auto_increment,
id_office int ,
id_emp_management int,
lastName   varchar(50) not null,
firstName  varchar(50) not null,
email  varchar(100) not null,
jobTitle  varchar(50) not null,
constraint id_office_employee foreign key (id_office) references office(id_office)
);
create table office(
id_office int primary key not null auto_increment,
city   varchar(50) not null,
phone  varchar(50) not null,
addressLine1  varchar(50) not null,
state   varchar(50) not null,
country   varchar(50) not null,
postalCode   varchar(15) not null
);
create table customer(
id_customer int primary key not null auto_increment,
id_employee int ,
customerName   varchar(70) not null,
contactLastName  varchar(10) not null,
contactFirstName  varchar(50) not null,
phone  varchar(11) not null,
addressLine1   varchar(50) not null,
addressLine2   varchar(50) not null,
city   varchar(50) not null,
state   varchar(50) not null,
postalCode   varchar(50) not null,
country   varchar(50) not null,
creditLimit   float not null,
constraint id_employee_customer foreign key (id_employee) references employee(id_employee)
);

create table payment(
id_payment int primary key not null auto_increment,
id_customer int ,
checkNumber   varchar(50) not null,
paymentDate  date not null,
amount   decimal(18,0) not null,
constraint id_customer_payment foreign key (id_customer) references customer(id_customer)
);

create table `order`(
id_order int primary key not null auto_increment,
id_customer int ,
orderDate  date not null,
requiredDate  date not null,
shippedDate date not null,
`status`  varchar(15) not null,
comments  varchar(50) ,
quantityOrdered  int not null,
priceEach decimal(18,0) not null,
constraint id_customer_customer foreign key (id_customer) references customer(id_customer)
);
create table detail_oder(
id_order int ,
id_product int,
primary key(id_order,id_product),
constraint id_order_detail_oder foreign key (id_order) references `order`(id_order),
constraint id_productdetail_oder foreign key (id_product) references product(id_product)
);
alter table employee
add constraint id_emp_management_employee foreign key (id_emp_management) references employee(id_employee)
