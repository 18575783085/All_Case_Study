<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>九大隐式之一：pageContext的使用</title>
  </head>
  
  <body>
  	<h1>pageContext作用作用域对象</h1>
  	
  	<h2>1.作为其他八大隐式对象的入口</h2>
  	例如：<br/>
  	<ol>
  		<li>pageContext.getPage()</li>
  		<li>pageContext.getServletConfig()</li>
  		<li>pageContext.getServletContext()</li>
  		<li>pageContext.getSession()</li>
  		<li>pageContext.getRequest()</li>
  		<li>pageContext.getResponse()</li>
  		<li>pageContext.getOut()</li>
  		<li>pageContext.getException()</li>
  	</ol>
  	
  	<h2>2.1.保存到 request 作用域</h2>
  	<% 
  		pageContext.setAttribute("name", "乔丹", pageContext.REQUEST_SCOPE);
  		//相当于：request.setAttribute("name","乔丹")
  	 %>
 	 <%=
 	 	pageContext.getAttribute("name", pageContext.REQUEST_SCOPE)
 	 	//相当于：request.getAttribute("name")
 	  %>
  	<h2>2.2.保存到 Session 作用域</h2>
  	<%
  		pageContext.setAttribute("name", "科比", pageContext.SESSION_SCOPE);
  		//相当于：session.setAttribute("name","科比")
  	 %>
  	 <%=
  	 	pageContext.getAttribute("name", pageContext.SESSION_SCOPE)
  	 	//相当于：session.getAttribute("name")
  	  %>
  	<h2>2.3.保存到 Application(ServletContext)作用域</h2>
  	<%
  		pageContext.setAttribute("name", "詹姆斯",pageContext.APPLICATION_SCOPE);
  		//相当于：application.setAttribute("name","詹姆斯")
  	 %>
  	 <%=
  	 	pageContext.getAttribute("name", pageContext.APPLICATION_SCOPE)
  	 	//相当于：application.getAttribute("name")
  	  %>
  	 <h2>2.4.保存到 page 作用域</h2>
  	 <%
  	 	pageContext.setAttribute("name", "艾佛森");
  	  %>
  	  <%=
  	  	pageContext.getAttribute("name")
  	   %>
  	   
  	 <h1>在四大域汇总搜寻属性</h1>
  	 <h3 style="color:red">从小域到大域：pageContext域 ---> request域 ---> session域 ---> application域</h3>
  	 <h4>findAttribute(name)方法：在所有域中寻找该属性名的值，如果不指定作用域的情况下，默认寻找最小作用域中该属性名的值</h4>
  	 <%=
  	  	pageContext.findAttribute("name")
  	  %>
  	   
  	 <h3>移除某一域中的属性：removeAttribute</h3>
  	 <%
  	   	pageContext.removeAttribute("name",pageContext.PAGE_SCOPE);
  	   %>
  	   <%=
  	 	  pageContext.findAttribute("name")
  	  	%>
  </body>
</html>
