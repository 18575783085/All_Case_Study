-- 1.列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。
/*
列: deptname, emp.*
条件: emp.deptno=dept.deptno
 */
select d.deptname, e.* 
from dept d left join emp e 
on e.deptno=d.deptno;

-- 2.列出薪资比关羽高的所有员工。
/*
列: emp.*
表: emp
条件: sal>(关羽的薪资)
 */
-- 求出关羽的薪资:
select * 
from emp
where sal> (select sal from emp where empname='关羽');

-- 3.列出所有员工的姓名及其直接上级的姓名。
/*
列: e1.empname, (直接上级)e2.empname
表: emp e1, emp e2
条件: e1.mgr=e2.empno
 */
select e1.empname, e2.empname
from emp e1, emp e2
where e1.mgr=e2.empno;

-- 4.列出最低薪资大于1500的各种职位及从事此职位的员工人数。
/*
列: job  员工人数
表: emp
条件: 最低薪资(分组)>1500
分组条件: job
 */
--先统计每个职位从事的员工人数
select job, count(*) 员工人数 from emp group by job;

--再对分组后的数据进行筛选, 将最低工资不大于1500的职位去除
select job, min(sal) 最低工资, count(*) 员工人数 
from emp
group by job
having min(sal)>1500;

-- 5.列出在销售部的员工的姓名，假定不知道销售部的部门编号。
/*
列: empname
表: dept d, emp e
条件: d.deptname='销售部'   d.deptno=e.deptno
 */
--关联查询, 查询部门表和员工表(笛卡尔积查询)
select d.deptno, deptname, empname from dept d, emp e;
--对笛卡尔积查询后的数据进行筛选, 剔除除销售部以外的其他部门对应的记录
select d.deptno, deptname, empname from dept d, emp e where deptname='销售部';
--再次筛选, 筛选出销售部对应的员工
select d.deptno, deptname, empname from dept d, emp e where deptname='销售部' and d.deptno=e.deptno;

-- 6.列出与曹操从事相同职位的所有员工及部门名称。
/*
列: e.empname d.deptname
表: emp e, dept d
条件: job='曹操的职位'  e.deptno=d.deptno
 */
--查询所有员工及员工对应的部门名称
select e.empname, d.deptname from emp e, dept d where d.deptno=e.deptno;
--再次筛选过滤, 查询出和曹操从事相同职位的员工
select e.empname, d.deptname from emp e, dept d where d.deptno=e.deptno and e.job=(
	select job from emp where empname='曹操'
);

-- 7.列出薪资高于在销售部(已知部门编号为30)就职的所有员工的薪资的员工姓名和薪资、部门名称。
/*
列: e.empname, e.sal, d.deptname
表: emp e, dept d
条件: e.deptno=d.deptno and sal> (30号部门的最高薪资) 
 */
select d.deptname, e.*
from emp e, dept d
where e.deptno=d.deptno and e.sal > (select max(sal) from emp where deptno=30);

-- 8.列出在每个部门职位的员工数量、平均工资。
/*
列: 员工数量, 平均工资
表: emp 
分组条件: deptno
聚合函数: count(*), avg(sal)
 */
select deptno, count(*) 员工数量, avg(sal) 平均工资
from emp
group by deptno;

-- 9.查出至少有一个员工的部门。显示部门人数、部门编号、部门名称、部门位置。
/*
列: 部门人数(count(*))  d.deptno, d.deptname, d.loc
表: emp e, dept d
条件: e.deptno=d.deptno
分组条件: e.deptno
 */
--关联查询, 查询出每个员工及员工对应的部门
select e.empname, d.deptno, d.deptname, d.loc from emp e, dept d where e.deptno=d.deptno;
--根据部门分组, 并统计每个部门下的员工人数
select count(e.empname) 部门人数, d.deptno, d.deptname, d.loc from emp e, dept d where e.deptno=d.deptno group by d.deptname;

select d.*, count(*) 部门人数
from emp e, dept d
where e.deptno=d.deptno
group by e.deptno;

-- 10.列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。
/*
列: e.empno, e.empname, d.deptname
表: emp e1, emp e2, dept d
条件: e1.hiredate<e2.hiredate and e1.mgr=e2.empno and e1.deptno=d.deptno
 */
--关联查询, 查询员工对应的上级及所在的部门
select e1.empname, e1.empno, d.deptname from emp e1, emp e2, dept d where e1.mgr=e2.empno and e1.deptno=d.deptno;

--筛选过滤, 查询出受雇日期早于上级的员工
select e1.empname, e1.empno, d.deptname from emp e1, emp e2, dept d where e1.mgr=e2.empno and e1.deptno=d.deptno and e1.hiredate<e2.hiredate;

select e1.empno, e1.empname, d.deptname
from emp e1, emp e2, dept d
where e1.hiredate<e2.hiredate and e1.mgr=e2.empno and e1.deptno=d.deptno;


-- 11.列出所有职员的姓名及其部门名称，部门的人数。
/*
列: e.empname, count(*)(分组e.deptno), d.deptname
表: emp e, dept d
条件: e.deptno=d.deptno
分组条件: e.deptno
 */
--查询员工及对应的部门
select e.empname, d.deptname, d.deptno
from emp e, dept d
where e.deptno=d.deptno;

--查询部门的人数
select deptno, count(*) cnt
from emp
group by deptno

--关联查询
select e.empname, d.deptname, e.deptno, e2.cnt 部门人数
from emp e, dept d, (
	select deptno, count(*) cnt
	from emp
	group by deptno
) e2
where e.deptno=d.deptno and e.deptno=e2.deptno;



