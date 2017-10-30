<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:if的使用</title>
  </head>
  
  <body>
  	<h1>1.根据if的判断输出结果</h1>
  	<h3>为true</h3>
  		<c:if test="${sessionScope.user == null }">
  			登陆 | 注册
  		</c:if>
  		<c:if test="${sessionScope.user != null }">
  			欢迎 ${sessionScope.user } 回来 | 注销
  		</c:if>
  	<h3>为false</h3>
  		<%
  			session.setAttribute("user", "超级管理员");
  		 %>
  		<c:if test="${sessionScope.user == null }">
  			登陆 | 注册
  		</c:if>
  		<c:if test="${sessionScope.user != null }">
  			欢迎 ${sessionScope.user } 回来 | 注销
  		</c:if>
  	<h2>小测试一</h2>
  		<%
  			request.setAttribute("x", 5);
  		 %>
  		 <c:if test="${x ==6 }" var="flag">
  		 	x = 6 显示了
  		 </c:if>
  		 <c:if test="${!pageScope.flag}">
  		 	x ！= 6 
  		 </c:if>
  	
  	<h2>小测试二</h2>
  		<%
  			request.setAttribute("address", "fs");
  		 %>
  		<select name="city">
  			<option value="">请选择城市</option>
  			<option value="gz"
  				<c:if test="${address == 'gz' }">selected="selected"</c:if>
  			>广州市</option>
  			<option value="fs"
  				<c:if test="${address == 'fs' }">selected="selected"</c:if>
  			>佛山市</option>
  			<option value="sz"
  				<c:if test="${address == 'sz' }">selected="selected"</c:if>
  			>深圳市</option>
  		</select>
  </body>
</html>
