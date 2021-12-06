create table orders(
    order_no int primary key, purchase_amount float, order_date date,
    customer_id int, salesman_id int);

INSERT INTO orders VALUES(70001, 150.5, STR_TO_DATE('2012-10-05', '%Y-%m-%d'), 3005, 5002),
    (70009, 270.65, STR_TO_DATE('2012-09-10', '%Y-%m-%d'), 3001, 5005),
    (70002, 65.26, STR_TO_DATE('2012-10-05', '%Y-%m-%d'), 3002, 5001),
    (70004, 110.5, STR_TO_DATE('2012-08-17', '%Y-%m-%d'), 3009, 5003),
    (70007, 948.5, STR_TO_DATE('2012-09-10', '%Y-%m-%d'), 3005, 5002),
    (70005, 2400.6, STR_TO_DATE('2012-07-27', '%Y-%m-%d'), 3007, 5001),
    (70008, 5760, STR_TO_DATE('2012-08-15', '%Y-%m-%d'), 3002, 5001),
    (70010, 1983.43, STR_TO_DATE('2012-10-10', '%Y-%m-%d'), 3004, 5006),
    (70003, 2480.4, STR_TO_DATE('2012-10-10', '%Y-%m-%d'), 3009, 5003),
    (70012, 250.45, STR_TO_DATE('2012-06-27', '%Y-%m-%d'), 3008, 5002),
    (70011, 75.29, STR_TO_DATE('2012-08-17', '%Y-%m-%d'), 3003, 5007),
    (70013, 3045.6, STR_TO_DATE('2012-04-25', '%Y-%m-%d'), 3002, 5001);
SELECT * from orders;

select distinct salesman_id from orders;
select order_no, order_date from orders order by order_date;
select order_no, purchase_amount from orders order by purchase_amount DESC;
select * from orders where purchase_amount < 500;
select * from orders where purchase_amount between 1000 and 2000;