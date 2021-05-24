create database practice_database;
use practice_database;
create table faculty(
faculty_id int primary key not null,
faculty_name varchar(40),
phone varchar(40)
);
SET FOREIGN_KEY_CHECKS = 1;
truncate table faculty;
insert into faculty
values (1,'Địa lý và QLTN','123456'),
(2,'Công nghệ sinh học','234567'),
(3,'Toán','456789');
create table student(
student_id int primary key not null,
student_name char(40),
faculty_id int,
date_of_birth date,
place_of_birth varchar(40),
foreign key (faculty_id) references faculty(faculty_id) on delete cascade
);

insert into student
values (1,'Lê Văn Sơn',1,'1995-10-15','Quảng Nam'),
(2,'Trần Văn Hoàng',2,'1996-6-10','Đà Nẵng');
insert into student
values (3,'Nguyễn Văn Tú',3,'1998-7-21','Quảng Trị');
insert into student
values (4,'Nguyễn Văn Toàn',2,'1997-7-21','Quảng Trị');
create table project(
project_id int primary key not null,
project_name varchar(40),
expense int,
place_of_intern varchar(40)
);
insert into project
values (1,'Đào đất',20,'Vườn'),
(2,'Làm thịt heo',30,'Xưởng');
insert into project
values (3,'Nhổ cỏ',20,'Vườn')
;
create table instructor(
instructor_id int primary key not null,
instructor_name varchar(40),
salary int,
faculty_id int,
foreign key (faculty_id) references faculty(faculty_id) on delete cascade
);
insert into instructor
values (1,'Trần Sơn',10,1),
(2,'Lê Tiến',12,2);
insert into instructor
values (4,'Trần Hoàng',10,1),
(5,'Võ Hoàng',10,2);
insert into instructor(instructor_id,instructor_name)
values (3,'Nguyễn Tuấn');
create table instructor_student(
student_id int,
project_id int,
instructor_id int,
grade int,
primary key(student_id,project_id,instructor_id),
foreign key (instructor_id) references instructor(instructor_id) on delete cascade,
foreign key (student_id) references student(student_id) on delete cascade,
foreign key (project_id) references project(project_id) on delete cascade);
insert into instructor_student
values (1,1,1,1),
(2,2,2,2);
insert into instructor_student
values (3,1,1,1);