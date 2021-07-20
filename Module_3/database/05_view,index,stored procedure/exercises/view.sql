create view products_view as
select product_code, product_name, product_price, product_status
from products;
select * from products_view;
update products_view
set product_price='c2'
where product_price='c';
drop view products_view;