<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:remove的使用</title>
  </head>
  
  <body>
  	<%
  		String str = "remove的使用方式";
  		pageContext.setAttribute("str", str);
  	 %>	
  	 <h1>删除前：${str }</h1>
  	 
  	 <c:remove var="str"></c:remove>
  	 <h1>删除后：${str }</h1>
  </body>
</html>
