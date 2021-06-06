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

select * from contract;

select * from customer where customer_id in ( select customer_id from (select contract.service_id,customer.customer_id,contract.contract_id,contract_detail.attach_service_id
from contract
join customer
on contract.customer_id=customer.customer_id
join contract_detail
on contract.contract_id=contract_detail.contract_id)x);

select * from service where service_id in ( select service_id from (select contract.service_id,customer.customer_id,contract.contract_id,contract_detail.attach_service_id
from contract
join customer
on contract.customer_id=customer.customer_id
join contract_detail
on contract.contract_id=contract_detail.contract_id 
group by customer.customer_id)x)
;

select ct.customer_id,cd.contract_id, cd.attach_service_id,ct.service_id,ct.employee_id
from contract ct
join customer ctm
on ct.customer_id=ctm.customer_id
join contract_detail cd
on ct.contract_id=cd.contract_id
join attach_service ats
on ats.attach_service_id=cd.attach_service_id;