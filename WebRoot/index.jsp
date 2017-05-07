<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html>
  <head>   
    <title>用户主页</title>   
  </head>
  
  <body>
    欢迎回来${sessionScope.user },<a href="${pageContext.request.contextPath }/LogoutServlet">【安全退出】</a><br>
    <a href="${pageContext.request.contextPath }/GetOnlineServlet">【查看在线人数】</a>
  </body>
</html>
