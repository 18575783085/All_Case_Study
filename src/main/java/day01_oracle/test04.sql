1:创建一个视图，包含20号部门的员工信息，
   字段:empno,ename,sal,job,deptno
2:创建一个序列seq_emp_no,从10开始，步进为10
3:编写SQL语句查看seq_emp_no序列的下一个数字
4:编写SQL语句查看seq_emp_no序列的当前数字
5:为emp表的ename字段添加索引:idx_emp_ename 
6:为emp表的LOWER(ename)字段添加索引:idx_emp_lower_ename
7:为emp表的sal,comm添加多列索引
8:创建myemployee表，字段:
  id NUMBER(4) ,
  nameVARCHAR2(20),
  birthday DATE,
  telephone VARCHAR2(11)
  scoreNUMBER(9,2)
  其中id作为主键，name要求不能为空,telephone需要唯一,score值必须>=0