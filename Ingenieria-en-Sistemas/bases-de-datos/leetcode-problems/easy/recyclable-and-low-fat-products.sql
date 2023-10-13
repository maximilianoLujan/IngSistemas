--1757. Recyclable and Low Fat Products

--Description ---- https://leetcode.com/problems/recyclable-and-low-fat-products/?envType=study-plan-v2&envId=top-sql-50


select p.product_id
from Products p
where p.low_fats = 'Y' 
and p.recyclable = 'Y';