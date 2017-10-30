<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:choose的使用</title>
  </head>
  
  <body>
  	<h1>1.根据选择某一值输出相应的信息</h1>
  	<h3>choose格式：choose + when + otherwise 一起使用</h3>
  		<%
  			request.setAttribute("day", "3");
  		 %>
  		 <%
  			pageContext.setAttribute("day", "7");
  		 %>
  		<c:choose>
  			<c:when test="${ day == 1 }">星期一</c:when>
  			<c:when test="${ day == 2 }">星期二</c:when>
  			<c:when test="${ day == 3 }">星期三</c:when>
  			<c:when test="${ day == 4 }">星期四</c:when>
  			<c:when test="${ day == 5 }">星期五</c:when>
  			<c:otherwise>休息日</c:otherwise>
  		</c:choose>
  		<%
  			request.setAttribute("like", "wangqiu");
  		 %>
  		 <%
  			session.setAttribute("like", "zuqiu");
  		 %>
  		<c:choose>
  			<c:when test="${ like == 'lanqiu' }">篮球</c:when>
  			<c:when test="${ like == 'zuqiu' }">足球</c:when>
  			<c:when test="${ like == 'wangqiu' }">网球</c:when>
  			<c:when test="${ like == 'youyong' }">游泳</c:when>
  			<c:otherwise>十项全能</c:otherwise>
  		</c:choose>
  		
  </body>
</html>
