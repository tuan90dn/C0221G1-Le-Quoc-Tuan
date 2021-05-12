create database thuchanh_taoCSDL;
use thuchanh_taoCSDL;
drop database thuchanh_taocsdl;
create database student_management;
use student_management;
create table student(
ID int primary key,
name_student varchar(50),
age_student int);
select * from student;
create table teacher(
Id int primary key,
name_teacher varchar(50),
age_teacher int,
country varchar(50));
select * from teacher;
truncate table teacher;
drop table teacher;
drop table student;
insert into student
values 
(1,'tuan',18),
(2,'tuan',28);
alter table student
add email varchar(50);