

create unique index unique_index on products(product_code);
alter table products add index composite_index(product_name,product_price);
explain select * from products where product_code=1;
explain select * from products where product_name='b' and product_price='c';
drop index product_index on products;