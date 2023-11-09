--176 Second Highest Salary


--Description ---- https://leetcode.com/problems/second-highest-salary/description/


select max(e.salary) as SecondHighestSalary
from Employee e 
where e.salary < (
  select max(e2.salary)
  from Employee e2 
)