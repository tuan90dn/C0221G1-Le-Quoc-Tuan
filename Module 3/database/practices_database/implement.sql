-- part 1 ----------------
-- task 1
select i.instructor_id,i.instructor_name,f.faculty_name
from instructor i
left join faculty f 
on i.faculty_id = f.faculty_id;

-- task 2
select i.instructor_id,i.instructor_name,f.faculty_name
from instructor i
join faculty f 
on i.faculty_id = f.faculty_id
where f.faculty_name='Địa lý và QLTN';

-- task 3
select count(s.student_id)
from student s
join faculty f 
on s.faculty_id = f.faculty_id
where f.faculty_name='Công nghệ sinh học';

-- task 4
select s.student_id,s.student_name,year(curdate())-year(s.date_of_birth)
from student s
join faculty f
on s.faculty_id=f.faculty_id
where f.faculty_name ='Toán';

-- task 5

select count(i.instructor_id)
from instructor i
join faculty f 
on i.faculty_id = f.faculty_id
where f.faculty_name='Công nghệ sinh học';

-- task 6
select s.student_id,s.student_name
from student s
left join instructor_student ist
on s.student_id = ist.student_id
left join project p
on ist.project_id = p.project_id
where ist.student_id is null;

-- task 7
select f.faculty_id,f.faculty_name,count(i.instructor_id) 'so_luong_giang_vien'
from faculty f
left join instructor i
on i.faculty_id = f.faculty_id
group by f.faculty_id;

-- task 8
select f.phone
from faculty f
join student s
on s.faculty_id = f.faculty_id
where s.student_name = 'Lê Văn Sơn';

-- part 2--------
-- task 1
select p.project_id,p.project_name
from instructor i 
join instructor_student ist
on i.instructor_id = ist.instructor_id
join project p
on ist.project_id = p.project_id
where i.instructor_name = 'Trần Sơn';

-- task 2
select p.project_name
from project p
left join instructor_student ist
on ist.project_id = p.project_id
where ist.project_id is null;

-- task 3
select i.instructor_id,i.instructor_name,f.faculty_name,count(ist.student_id)
from instructor i
join faculty f
on i.faculty_id = f.faculty_id
join instructor_student ist
on ist.instructor_id = i.instructor_id
group by ist.instructor_id
having count(ist.student_id)>4;

-- task 4
select * from project 
where expense >= all (select expense from project);

-- task 5
select p.project_id,p.project_name,count(ist.student_id) 'so_sinh_vien_theo_hoc'
from project p
join instructor_student ist
on ist.project_id = p.project_id
group by project_id
having so_sinh_vien_theo_hoc>2;

-- task 6
select s.student_id,s.student_name,ist.grade
from student s
join faculty f
on s.faculty_id = f.faculty_id
join instructor_student ist
on ist.student_id = s.student_id
where f.faculty_name='Địa lý và QLTN';

-- task 7
select f.faculty_name,count(s.student_id)
from faculty f
left join student s
on s.faculty_id = f.faculty_id
group by f.faculty_id;

-- task 8
select s.student_name
from student s
join instructor_student ist
on ist.student_id = s.student_id
join project p
on ist.project_id = p.project_id
where p.place_of_intern = s.place_of_birth;

-- task 9
select s.student_id,s.student_name
from student s
left join instructor_student ist
on ist.student_id = s.student_id
where ist.student_id is null;

-- task 10

select s.student_id,s.student_name
from student s
left join instructor_student ist
on ist.student_id = s.student_id
where ist.grade = 0;





