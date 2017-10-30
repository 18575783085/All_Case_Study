<%@page import="ou.JavaBean.javaBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>c:forEach的使用</title>
  </head>
  
  <body>
  	<h1>1.遍历list集合</h1>
  		<%
  			List<String> list = new ArrayList<String>();
  			list.add("a");
  			list.add("b");
  			list.add("c");
  			list.add("d");
  			list.add("e");
  			
  			pageContext.setAttribute("list", list);
  		 %>
  		 <c:forEach items="${list }" var="list">
  		 	${list }<br/>
  		 </c:forEach>
  	
  	<h1>2.案例：遍历2到100的偶数，如果数字所在的位置是3的倍数，显示成红色样式</h1>
  		<h3>不加varStatus</h3>
  		<c:forEach begin="0" end="100" step="2" var="num">
			<c:if test="${num % 3 == 0 }">
				<span style="color:red">${num } </span>
			</c:if>
			<c:if test="${num % 3 != 0 }">
				${num }
			</c:if>	 			
  		</c:forEach>
  	<h1>3.案例：遍历1到100的整数，如果数字所在的位置是3的倍数，也是5的倍数，显示成蓝色样式</h1>	
  		<h3>加上varStatus属性</h3>
  		<c:forEach begin="1" end="100"  var="number" varStatus="status">
  			<c:if test="${status.count % 3 == 0 && status.count % 5 ==0 }">
  				<span style="color:blue">${number }</span>
  			</c:if>
  			<c:if test="${status.count % 3 != 0 || status.count % 5 != 0 }">
  				${number }
  			</c:if>
  		</c:forEach>
  		
  	<h1>4.遍历map</h1>	
  		<%
  			Map<Integer,javaBean> map = new HashMap<Integer,javaBean>();
  			map.put(1, new javaBean("刘德华",18));
  			map.put(2, new javaBean("张学友",19));
  			map.put(3, new javaBean("郭富城",20));
  			map.put(4, new javaBean("黎明",21));
  			
  			pageContext.setAttribute("map", map); 
  		 %>
  		 <!-- foreach的map遍历相当于  for(Map.entry<Integer,javaBean> entry:map.entrySet()) -->
  		 <c:forEach items="${map }" var="entry">
  		 	${entry.key }---${entry.value.username }---${entry.value.age }<br/>
  		 </c:forEach>
  	<h3>序号和JavaBean调转 keyvalue位置</h3>
  		<%
  			Map<javaBean,Integer> map1 = new HashMap<javaBean,Integer>();
  			map1.put(new javaBean("刘德华",18),1);
  			map1.put(new javaBean("张学友",19),2);
  			map1.put(new javaBean("郭富城",20),3);
  			map1.put(new javaBean("黎明",21),4);
  			
  			pageContext.setAttribute("map1", map1); 
  		 %>
  		<c:forEach items="${map1 }" var="entry">
  			${entry.key.username }---${entry.key.age }---${entry.value }<br/>
  		</c:forEach>
  	<h1 style="color:red">得出结论：varStatus.count寻找的值下数字所在的下标</h1>
  </body>
</html>
