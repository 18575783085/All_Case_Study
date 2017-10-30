-- ----------------------------
-- mysql练习sql脚本
-- ----------------------------
create database db10;			-- 创建db10数据库
use db10;						-- 切换到db10数据库
create table dept(				-- 创建部门表
	deptno int primary key,		-- 部门编号
	deptname varchar(50),		-- 部门名称
	loc varchar(50)				-- 部门位置
);
create table emp(				-- 创建员工表
	empno int primary key,		-- 员工编号
	empname varchar(50),		-- 员工姓名
	job varchar(50),			-- 职位
	mgr int,					-- 直属上级
	hiredate date,				-- 受雇日期
	sal int,					-- 薪资
	comm int,					-- 奖金
	deptno int,					-- 所在部门编号
	foreign key(deptno) references dept(deptno)
);
-- ----------------------------
-- Records of dept 部门表数据
-- ----------------------------
INSERT INTO `dept` VALUES ('10', '会计部', '北京');
INSERT INTO `dept` VALUES ('20', '调查部', '杭州');
INSERT INTO `dept` VALUES ('30', '销售部', '上海');
INSERT INTO `dept` VALUES ('40', '营销部', '深圳');


-- ----------------------------
-- Records of emp 员工表数据
-- ----------------------------
INSERT INTO `emp` VALUES ('7369', '张无忌', '办事员', '7902', '1980-12-17', '800', null, '20');
INSERT INTO `emp` VALUES ('7499', '曹操', '推销员', '7698', '1981-02-20', '1600', '300', '30');
INSERT INTO `emp` VALUES ('7521', '杨志', '推销员', '7698', '1981-02-22', '1250', '500', '30');
INSERT INTO `emp` VALUES ('7566', '朱元璋', '经理', '7839', '1981-04-02', '2975', null, '20');
INSERT INTO `emp` VALUES ('7654', '殷天正', '推销员', '7698', '1981-09-28', '1250', '1400', '30');
INSERT INTO `emp` VALUES ('7698', '张三丰', '经理', '7839', '1981-05-01', '2850', null, '30');
INSERT INTO `emp` VALUES ('7782', '关羽', '经理', '7839', '1981-06-09', '2450', null, '10');
INSERT INTO `emp` VALUES ('7788', '宋江', '分析员', '7566', '1987-04-19', '3000', null, '20');
INSERT INTO `emp` VALUES ('7839', '韩少云', '董事长', null, '1981-11-17', '5000', null, '10');
INSERT INTO `emp` VALUES ('7844', '孙二娘', '推销员', '7698', '1981-09-08', '1500', '0', '30');
INSERT INTO `emp` VALUES ('7876', '张飞', '办事员', '7788', '1987-05-23', '1100', null, '20');
INSERT INTO `emp` VALUES ('7900', '赵云', '办事员', '7698', '1981-12-03', '950', null, '30');
INSERT INTO `emp` VALUES ('7902', '诸葛亮', '分析员', '7566', '1981-12-03', '3000', null, '20');
INSERT INTO `emp` VALUES ('7934', '夏侯惇', '办事员', '7782', '1982-01-23', '1300', null, '10');