select sum(purchase_amount) TotalSum from orders;
select avg(purchase_amount) AverageSum from orders;
select max(purchase_amount) Max from orders;
select Min(purchase_amount) Min from orders;
select count(distinct(salesman_id)) as TotalSalesman from orders;