<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!-- 引入core标签库 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:out的使用</title>
  </head>
  
  <body>
  	<h1>1.直接输出一个固定值</h1>
  		<c:out value="我是out方法"></c:out>
  		<c:out value="可以选择性不写关闭标签" />
  		
  	<h1 style="color:red">jstl标签+el表达式使用</h1>
  	<h1>2.输出一个变量</h1>
  		<%
  			int x = 5;
  			request.setAttribute("x", x);
  		 %>
  		 <c:out value="${x }"></c:out>
  	
  	<h1>3.输出html链接</h1>
  	<h3>转义html：默认为转义，可以通过设置 escapeXml属性为false,来禁止转义</h3>
  		<c:out value="<a href='${pageContext.request.contextPath }/El/4_el.jsp'></a>"></c:out>
  		<c:out value="<a href='${pageContext.request.contextPath }/El/4_el.jsp'>跳转页面</a>" escapeXml="false"></c:out>
  		
  	<h1>4.允许输出默认值，如果给定值不存在，则输出默认值</h1>
  		<c:out value="${city }" default="佛山"></c:out>
  		<%
  			String city = "广州";
  			request.setAttribute("city", city);
  		 %>
  		 <c:out value="${city }" default="佛山"></c:out>
  </body>
</html>
