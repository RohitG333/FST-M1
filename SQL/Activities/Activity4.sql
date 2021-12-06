ALTER TABLE salesman ADD grade int;
SET SQL_SAFE_UPDATES=0;
UPDATE salesman SET grade=100;
select * from salesman;
SET SQL_SAFE_UPDATES=1;