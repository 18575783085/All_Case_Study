<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:import的使用</title>
  </head>
  
  <body>
  	<c:import url="/index.jsp">
  		<c:param name="username" value="zhangfei"></c:param>
  	</c:import>
  </body>
</html>
