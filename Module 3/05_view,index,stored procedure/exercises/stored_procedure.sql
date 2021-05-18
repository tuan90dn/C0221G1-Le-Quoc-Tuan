delimiter //

create procedure allrecords()
begin
select * from products;
end //

delimiter ;

DELIMITER $$
CREATE  PROCEDURE add_new_product(
in id int,
in product_code varchar(50),
in product_name varchar(50),
in product_price varchar(50),
in product_amount varchar(50),
in product_description varchar(50),
in product_status varchar(50)
)
begin
insert into products
values (id,product_code,product_name,product_price,product_amount,
product_description,product_status);
end //
DELIMITER ;


delimiter //
create procedure edit_product(
in search_id int,
in p_id int,
in p_product_code varchar(50),
in p_product_name varchar(50),
in p_product_price varchar(50),
in p_product_amount varchar(50),
in p_product_description varchar(50),
in p_product_status varchar(50)
)
begin
update products
set id=p_id,
product_code=p_product_code,
product_name=p_product_name,
product_price=p_product_price,
product_amount=p_product_amount,
product_description=p_product_description,
product_status=p_product_status
where id=search_id;
end //
delimiter ;

delimiter //

create procedure delete_product(in p_id int)
begin
delete from products
where id=p_id;
end //

delimiter ;

call add_new_product(7,'atuan','dep','trai','nhat','the','gioi');
call allrecords();
call edit_product(6,4,'anhtuan','dep','trai','nhat','the','gioi');
call delete_product(5);