use quan_ly_sinh_vien;
select * from student;
SELECT *
FROM student
WHERE Status = true;

SELECT *
FROM subject
WHERE Credit < 10;

SELECT s.student_ID, s.student_name, c.class_name
FROM student s 
join class c 
on s.class_ID = c.class_ID;

SELECT S.student_ID, S.student_name, C.class_name
FROM Student S join Class C on S.class_ID = C.class_ID
WHERE C.class_name = 'A1';

SELECT S.student_ID, S.student_name, Sub.sub_name, M.Mark
FROM Student S join Mark M on S.student_ID = M.student_ID 
join Subject Sub on M.sub_ID = Sub.sub_ID;

SELECT S.student_ID, S.student_name, Sub.sub_name, M.Mark
FROM Student S join Mark M on S.student_ID = M.student_ID 
join Subject Sub on M.sub_ID = Sub.sub_ID
WHERE Sub.sub_name = 'CF';