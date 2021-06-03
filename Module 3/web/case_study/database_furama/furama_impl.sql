update customer
set customer_type_id=?,customer_name=?,customer_birthday=?,
customer_gender=?,customer_id_card=?,customer_phone=?,
customer_email=?,customer_address=?
where customer_id=?;

select * from customer where customer_id=1;

select * from customer where customer_name='Trần Thị C';