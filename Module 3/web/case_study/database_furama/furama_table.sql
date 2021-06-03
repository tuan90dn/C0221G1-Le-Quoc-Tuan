create database furama;

create table customer_type(
customer_type_id int primary key not null,
customer_type_name varchar(45) not null);
insert into customer_type
values (1,"Diamond"),(2,"Platinium"),(3,"Gold"),(4,"Silver"),(5,"Member");

create table customer(
customer_id int primary key auto_increment,
customer_type_id int not null,
foreign key (customer_type_id) references customer_type(customer_type_id) on delete cascade,
customer_name varchar(45),
customer_birthday date,
customer_gender bit(1),
customer_id_card varchar(45),
customer_phone varchar(45),
customer_email varchar(45),
customer_address varchar(45));
-- truncate table customer;
insert into customer (customer_type_id,customer_name,customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address)
values(1,"Nguyễn Văn A",'1990-11-28',0,123456789,8239483,'a@gmail.com','Đà Nẵng'),
(3,"Nguyễn Văn B",'1991-11-28',0,123456789,8239483,'b@gmail.com','Quảng Nam'),
(2,"Trần Thị C",'1992-11-28',1,123456789,8239483,'c@gmail.com','Kon Tum'),
(4,"Nguyễn Văn D",'1990-11-28',0,123456789,8239483,'d@gmail.com','Đà Nẵng'),
(5,"Lê Thị E",'1991-11-28',1,123456789,8239483,'e@gmail.com','Đà Nẵng'),
(3,"Nguyễn Văn F",'1992-11-28',0,123456789,8239483,'c@gmail.com','Quảng Trị');

create table service_type(
service_type_id int primary key,
service_type_name varchar(45)
);

