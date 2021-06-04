update customer
set customer_type_id=?,customer_name=?,customer_birthday=?,
customer_gender=?,customer_id_card=?,customer_phone=?,
customer_email=?,customer_address=?
where customer_id=?;

select * from customer where customer_id=1;

select * from customer where customer_name='Trần Thị C';

INSERT INTO employee(employee_name, employee_birthday, employee_id_card,employee_salary,employee_phone,employee_email,
employee_address,position_id,education_degree_id,division_id,username) 
VALUES ('Lê Văn Tuấn','1980-11-30',34346456,10000000,23534534,'abc@gmail','Đà Nẵng',1,2,4,'Lê Văn A');