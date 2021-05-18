create database demo;
drop table products;
create table products(
id int primary key not null ,
product_code varchar(50),
product_name varchar(50),
product_price varchar(50),
product_amount varchar(50),
product_description varchar(50),
product_status varchar(50));
select * from products;
insert into products
values(1,1,'b','c','e','f','g'),
(2,2,'b2','c2','e2','f2','g2'),
(3,3,'b2','c2','e2','f2','g2'),
(4,4,'b2','c2','e2','f2','g2');