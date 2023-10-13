--183. Customers Who Never Order


--Description ---- https://leetcode.com/problems/customers-who-never-order/description/


--With left join
select c.name as Customers
from Customers c
left join Orders o on c.id = o.customerId
where o.customerId IS NULL;

--with not in
select c.name as Customers
from Customers c
where c.id not in(
  select o.customerId
  from Orders o
);