create database quan_ly_ban_hang;
use quan_ly_ban_hang;
create table customer(
c_ID int primary key,
c_name varchar(50),
c_age int
);
create table `order`(
o_ID int primary key,
c_ID int,
o_date date,
o_total_price varchar(50),
foreign key (c_ID) references customer(c_ID)
);
create table product(
p_ID int primary key,
p_name varchar(50),
p_price int
);
create table order_detail(
o_ID int,
p_ID int,
primary key (o_ID,p_ID),
foreign key (o_ID) references `order`(o_ID),
foreign key (p_ID) references product(p_ID)
);
alter table order_detail
add od_QTY varchar(50);
