<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" buffer="none"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>九大隐式之一：out的使用</title>
  </head>
  
  <body>
  <h1>测试一结果：不按顺序输出</h1>
  <h2>原因：out自带缓冲区，缓冲区大小默认为：8kb</h2>
  <h3>解决方案：在顶部标签(page标签里面加上:buffer="none")</h3>
  <%
  	out.println("乔丹");
  	response.getWriter().write("科比");
  	out.println("詹姆斯");
   %>
  </body>
</html>
