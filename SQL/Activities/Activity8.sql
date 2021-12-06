select customer_id,max(purchase_amount) as MaxPurchase from orders group by customer_id;
select salesman_id,order_date, max(purchase_amount) as "Max Purchase" from orders where order_date=str_to_date('2012-08-17','%Y-%m-%d') group by salesman_id,order_no;
select customer_id,order_date,max(purchase_amount) as "Max Purchase" from orders group by customer_id,order_date having max(purchase_amount) IN(2030, 3450, 5760, 6000);
