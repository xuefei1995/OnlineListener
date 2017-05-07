<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>   
    <title>用户登录</title>   
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/LoginServlet" method="post">
    	用户名<input type="text" name="username"><br>
    	<input type="submit" value="登录">
    </form>
  </body>
</html>
