<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>   
    <title>在线人数</title>   
  </head>
  
  <body>
    <table align="center" border="1" width="900px">
    	<tr>
    	<td>编号</td>
    	<td>姓名</td>
		<td>登录时间</td>
		<td>最后访问时间</td>
		<td>ip</td>
		<td>操作</td>
    	</tr>
    	<c:forEach items="${requestScope.userlist }" var="msg" varStatus="num">
	    	<tr>
	    	<td>${num.count }</td>
	    	<td>${msg.name }</td>
	    	<td>${msg.logintime }</td>
	    	<td>${msg.lasttime }</td>
	    	<td>${msg.ip }</td>
	    	<td><a href="${pageContext.request.contextPath }/KickoutServlet?sessionid=${msg.sessionid}">踢人</a></td>    	
	    	</tr>
    	</c:forEach>
    </table>
  </body>
</html>
