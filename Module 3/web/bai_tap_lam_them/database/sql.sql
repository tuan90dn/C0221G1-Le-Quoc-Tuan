create database product;
use product;
create table product(
product_ID int primary key auto_increment,
product_name varchar(30),
product_price decimal(15,0),
product_quantity int,
product_color varchar(50),
product_description varchar(50),
category_Id int,foreign key (category_Id) references category (category_Id) on delete cascade
);
insert into product (product_name,product_price,product_quantity,product_color,product_description,category_Id)
values ("Iphone 11",799,12,"Purple,Yellow,Green","New 100%",1),
("Iphone 11 Pro",1100,12,"Green,Black,White","New 100%",1),
("Smart Tivi 4k UHD 49 inches",500,5,"Black","New 100%",3);

create table category(
category_Id int primary key,
category_name varchar(45)
);
insert into category
values (1,"Phone"),(2,"Computer"),(3,"Television");

select * from product where product_name like samsung;

delete from category;


