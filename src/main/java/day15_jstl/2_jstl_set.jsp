<%@page import="ou.JavaBean.javaBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:set的使用</title>
  </head>
  
  <body>
  	<h1>1.将数据分别存入到四大作用域中</h1>
  	<h3>注意：当不指定某一作用域中时，则输出不指定作用域的值</h3>
  		<c:set var="username" value="刘德华" scope="page"></c:set>
  		<c:set var="username" value="张学友" scope="request"></c:set>
  		<c:set var="username" value="郭富城" scope="session"></c:set>
  		<c:set var="username" value="黎明" scope="application"></c:set>
  		<c:set var="username" value="王杰"></c:set>
  	<h4>${username }</h4>
  	
  	<h1>2.修改属性的值</h1>
  	<h3>先把数据保存到某一作用域，虽然c:set不能设置对象进域，但是可以更改域中对象的属性</h3>
  		<%
  			Map<String,String> map = new HashMap<String,String>();
  			map.put("name", "赵云");
  			map.put("age", "18");
  			map.put("address", "荆州");
  			map.put("job", "项目经理");
  			
  			pageContext.setAttribute("map", map);
  		 %>
  	<h2>2.1.没修改属性前的任务信息</h2>
  	<p>${map.name }---${map['age'] }---${map["address"] }---${map.job }</p>
  	
  	<h2>2.2.修改域中的map集合中的人物属性信息</h2>
  		<c:set target="${map }" property="age" value="20"></c:set>
  		<c:set target="${map }"	property="job" value="项目总监"></c:set>
  	<p>${map.name }---${map['age'] }---${map["address"] }---${map.job }</p>
  	
  	<h1>3.修改web域中的JavaBean类中的属性</h1>
  		<%
  			javaBean jb = new javaBean();
  			jb.setUsername("马超");
  			jb.setAge(18);
  			
  			pageContext.setAttribute("user", jb);
  		 %>
  	<p>修改前：${user.username }---${user.age }</p>
  		<c:set target="${user }" property="age" value="20"></c:set>
  	<p>修改后：${user.username }---${user.age }</p>
  </body>
</html>
