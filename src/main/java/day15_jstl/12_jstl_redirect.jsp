<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:redirect的使用</title>
  </head>
  
  <body>
  	<h1>重定向去某一页面，如果带参数，会在跳转到页面时，地址栏url？后面拼接参数</h1>
  	<c:redirect context="${pageContext.request.contextPath }" url="/index.jsp">
  		<c:param name="username" value="zhaoyun"></c:param>
  		<c:param name="age" value="15"></c:param>
  	</c:redirect>
  </body>
</html>
