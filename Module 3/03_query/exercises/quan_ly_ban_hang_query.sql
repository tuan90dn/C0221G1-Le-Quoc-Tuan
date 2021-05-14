use quan_ly_ban_hang;
insert into customer
values (1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);

insert into `order`
values (1,1,'2006/3/21',null),
(2,2,'2006/3/23',null),
(3,1,'2006/3/16',null);

insert into product
values (1,'May giat',3),
(2,'Tu Lanh',5),
(3,'Dieu Hoa',7),
(4,'Quat',1),
(5,'Bep Dien',2);

insert into order_detail
values (1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);
select * from `order`;



select customer.c_name,product.p_name
from customer
join `order` on customer.c_ID=`order`.c_ID
join order_detail on `order`.o_ID=order_detail.o_ID
join product on product.p_ID=order_detail.p_ID;

select c.c_name
from customer c
left join `order` o on c.c_ID=o.c_ID
where o.o_ID is null;

select o.o_ID,o.o_date,sum(p.p_price*od.od_QTY)
from `order` o
join order_detail od on o.o_ID=od.o_ID
join product p on od.p_ID=p.p_ID
group by (o.o_ID) ;