use quan_ly_sinh_vien;
select * from student
where student_name like "H%";
select * from class;
select * from class
where start_date like '%-12-%';

select * from subject
where credit between 3 and 5;
SET SQL_SAFE_UPDATES = 0;
update student
set class_ID =2
where student_name like 'Hung';

select student.student_name,subject.sub_name, mark.mark
from mark 
join student on student.student_ID=mark.student_ID
join subject on mark.sub_ID=subject.sub_ID
order by mark.mark desc,
student.student_name asc;
