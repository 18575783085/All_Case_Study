-- 1.列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
select emp.empno,emp.emppname,emp.job,emp.job,emp.mgr,emp.hiredate,emp.sal,emp.comm,emp.deptno,
dept.name,dept.loc
from emp
right JOIN dept
on emp.deptno = dept.deptno

-- 2.列出薪资比关羽高的所有员工。
SELECT  empname from emp
where sal >
(SELECT  sal from emp WHERE empname = '关羽')

-- 3.列出所有员工的姓名及其直接上级的姓名。
SELECT  e.empname,m.empname from emp e,emp m
where e.mgr = m.empno

-- 4.列出最低薪资大于1500的各种职位及从事此职位的员工人数。


-- 5.列出在销售部职位的员工的姓名，假定不知道销售部的部门编号。

-- 6.列出与曹操从事相同职位的所有员工及部门名称。

-- 7.列出薪资高于在销售部(已知部门编号为30)就职的所有员工的薪资的员工姓名和薪资、部门名称。

-- 8.列出在每个部门职位的员工数量、平均工资。

-- 9.查出至少有一个员工的部门。显示部门人数、部门编号、部门名称、部门位置。

-- 10.列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。

-- 11.列出所有职员的姓名及其部门名称，部门的人数。
