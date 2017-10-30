<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:forTokens的使用</title>
  </head>
  
  <body>
  	<h1>1.forTokens的用法跟字符串的split方法相似，都是根据某一个条件来进行拆分</h1>
  		<c:forTokens items="www.oye.com.cn.gov.xin" delims="." var="str">
  			${str }<br/>
  		</c:forTokens>
  </body>
</html>
