<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>	
  <body>
    <h1>客户管理系统</h1><hr>
  	<a href="${ pageContext.request.contextPath}/addCust.jsp">添加客户</a>
  	<a href="${ pageContext.request.contextPath}/ListCustServlet">查询客户列表</a>
  	<a href="${ pageContext.request.contextPath}/PageCustServlet?thispage=1">分页查询客户</a>
  </body>
</html>
