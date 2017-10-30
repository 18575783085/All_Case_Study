<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:catch的使用</title>
  </head>
  
  <body>
  	<h1>捕获异常，并将异常信息显示到页面</h1>
  	<h3>模拟场景：char c = str.charAt(0)</h3>
  		<c:catch var="e">
  			<%
  				String str = null;
  				char c = str.charAt(0);
  			 %>
  		</c:catch>
  	<p>异常：${e }</p>
  	<h3>模拟场景：i = 1/0</h3>
  		<c:catch var="e">
  			<%
  				int i = 1/0;
  			 %>
  		</c:catch>
  	<p>异常：${e }</p>
  	<p>异常信息：${e.message }</p>
  </body>
</html>
