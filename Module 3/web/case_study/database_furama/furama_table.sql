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
insert into service_type
values (1,"Villa"),(2,"House"),(3,"Room");
create table rent_type(
rent_type_id int primary key,
rent_type_name varchar(45),
rent_type_cost double
);
insert into rent_type
values (1,"Year",100000000),(2,"Month",10000000),(3,"Day",500000),(4,"Hour",100000);
create table service(
service_id int auto_increment primary key,
service_name varchar(45),
service_area int,
service_cost double,
service_max_people int,
rent_type_id int,foreign key (rent_type_id) references rent_type(rent_type_id) on delete cascade,
service_type_id int,foreign key (service_type_id) references service_type(service_type_id) on delete cascade,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
number_of_floor int
);
truncate table service;
insert into service(service_name,service_area,service_cost,service_max_people,rent_type_id,service_type_id,standard_room,description_other_convenience,pool_area,number_of_floor)
values('Luxury',300,5000000,30,1,1,'Luxury','Luxury',30,5),
('Commoner',200,4000000,20,1,1,'Commoner','Commoner',20,5),
('Luxury',300,5000000,30,1,2,'Luxury','Luxury',30,5),
('Commoner',200,4000000,20,1,2,'Commoner','Commoner',20,5),
('Luxury',300,5000000,30,1,3,'Luxury','Luxury',30,5),
('Commoner',200,4000000,20,1,3,'Commoner','Commoner',20,5);

create table `position`(
position_id int primary key,
position_name varchar(45)
);
insert into `position`
values (1,"Lễ Tân"),(2,"Phục Vụ"),(3,"Chuyên Viên"),(4,"Giám Sát"),(5,"Quản Lý"),(6,"Giám Đốc");

create table education_degree(
education_degree_id int primary key,
education_degree_name varchar(45)
);

insert into education_degree
values (1,"Trung Cấp"),(2,"Cao Đẳng"),(3,"Đại Học"),(4,"Sau Đại Học");

create table division(
division_id int primary key,
division_name varchar(45)
);

insert into division
values (1,"Sale – Marketing"),(2,"Hành Chính"),(3,"Phục Vụ"),(4,"Quản Lý");

-- create table `role`(
-- role_id int auto_increment primary key,
-- role_name varchar(225)
-- );
-- create table `user`(
-- username varchar(225) primary key,
-- password varchar(225)
-- );
-- create table user_role(
-- role_id int ,foreign key (role_id) references `role`(role_id) on delete cascade,
-- username varchar(225) ,foreign key (username) references `user`(username) on delete cascade
-- );
create table employee(
employee_id int auto_increment primary key,
employee_name varchar(45),
employee_birthday date,
employee_id_card varchar(45),
employee_salary decimal(15,0),
employee_phone varchar(45),
employee_email varchar(45),
employee_address varchar(45),
position_id int,foreign key(position_id) references `position`(position_id) on delete cascade,
education_degree_id int,foreign key(education_degree_id) references education_degree(education_degree_id) on delete cascade,
division_id int,foreign key (division_id) references division (division_id) on delete cascade,
username varchar(225)
);

insert into employee (employee_name,employee_birthday,employee_id_card,employee_salary,employee_phone,employee_email,employee_address,position_id,education_degree_id,division_id,username)
values ('Lê Văn A','1992-11-30',34346456,10000000,23534534,'abc@gmail','Đà Nẵng',1,2,4,'Lê Văn A'),
('Trần Văn B','1993-11-30',3896456,10000000,23534534,'abc@gmail','Huế',2,3,1,'Trần Văn B'),
('Nguyễn Thị C','1994-11-30',35346456,10000000,23534534,'abc@gmail','Đà Nẵng',6,4,3,'Nguyễn Thị C'),
('Lê Hoang Tuan','1994-11-30',35346456,10000000,23534534,'abc@gmail','Hà Nội',5,1,2,'Lê Hoang Tuan'),
('Ho Van Tuan','1994-11-30',35346456,10000000,23534534,'abc@gmail','Quảng Bình',4,3,4,'Ho Van Tuan');
truncate table employee;


create table attach_service(
attach_service_id int auto_increment primary key,
attach_service_name varchar(45),
attach_service_cost double,
attach_service_unit int,
attach_service_status varchar(45)
);
create table contract(
contract_id int auto_increment primary key,
contract_start_date date,
contract_end_date date,
contract_deposit double,
contract_total_money double,
employee_id int,foreign key (employee_id) references employee(employee_id) on delete cascade,
customer_id int,foreign key (customer_id) references customer(customer_id) on delete cascade,
service_id int,foreign key (service_id) references service(service_id) on delete cascade
);

insert into contract (contract_start_date,contract_end_date,contract_deposit,contract_total_money,employee_id,customer_id,service_id)
values ('2020-1-1','2020-1-10',1000000,10000000,2,1,3),
('2020-11-19','2020-12-10',2000000,150000000,1,3,4),
('2020-1-1','2020-1-10',1000000,10000000,5,5,2),
('2020-1-1','2020-1-10',1000000,10000000,3,4,5),
('2020-1-1','2020-1-10',1000000,10000000,2,6,6); 
create table contract_detail(
contract_detail_id int auto_increment primary key,
contract_id int,foreign key(contract_id) references contract(contract_id) on delete cascade,
attach_service_id int,foreign key (attach_service_id) references attach_service(attach_service_id) on delete cascade,
quantity int
);
