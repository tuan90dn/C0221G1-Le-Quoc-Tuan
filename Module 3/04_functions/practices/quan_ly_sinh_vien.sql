SELECT address, COUNT(student_ID) AS 'so_luong_hoc_vien'
FROM student
GROUP BY address;

SELECT S.student_ID,S.student_name, AVG(mark)
FROM student S join mark M on S.student_ID = M.student_ID
GROUP BY S.student_ID, S.student_name;

SELECT S.student_ID,S.student_name, AVG(mark)
FROM student S join mark M on S.student_ID = M.student_ID
GROUP BY S.student_ID, S.student_name
HAVING AVG(mark) > 15;

SELECT S.student_ID, S.student_name, AVG(Mark)
FROM Student S join Mark M on S.student_ID = M.student_ID
GROUP BY S.student_ID, S.student_name
HAVING AVG(Mark) >= ALL (SELECT AVG(Mark) FROM Mark GROUP BY Mark.student_ID);