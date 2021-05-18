-- task 1

select *
from subject 
where credit =(select max(credit) from subject);


-- task 2

select s.sub_ID,s.sub_name,s.credit,s.Status 
from subject s
inner join mark m
on s.sub_ID = m.sub_ID
where m.mark = (select max(mark.mark) from mark);

-- task 3

select st.student_Id,st.student_name,st.address,st.phone,AVG(m.mark)
from student st
left join mark m
on st.student_Id = m.student_ID
group by st.student_Id
order by AVG(m.mark) asc;