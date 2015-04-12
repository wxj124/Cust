<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head> 
  <body style="text-align: center">
		<h1>客户管理系统_添加客户</h1><hr>
		<form action="${pageContext.request.contextPath }/addCustServlet" method="post">
		<table border="1">
		<tr>
			<td>客户姓名</td>
			<td><input type="text" name="name"></td>
		</tr>
		<tr>
			<td>性  别</td>
			<td><input type="radio" name="gender" value="男">男<input type="radio" name="gender" value="女">女</td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td><input type="text" name="birthday"></td>
		</tr>
		<tr>
			<td>联系电话</td>
			<td><input type="text" name="cellphone"></td>
		</tr>
		<tr>
			<td>邮  箱</td>
			<td><input type="text" name="email"></td>
		</tr>
		<tr>
			<td>爱  好</td>
			<td><input type="checkbox" name="preference" value="篮球">篮球
			<input type="checkbox" name="preference" value="足球">足球
			<input type="checkbox" name="preference" value="排球">排球
			<input type="checkbox" name="preference" value="棒球">棒球
			</td>
		</tr>
		<tr>
			<td>客户类型</td>
			<td><select name="type">
			    <option value="钻石客户">钻石客户</option>
			    <option value="白金客户">白金客户</option>
			    <option value="黄金客户">黄金客户</option>
			    <option value="普通客户">普通客户</option>
			    <option value="青铜客户">青铜客户</option></select>
			    </td>
		</tr>
		<tr>
			<td>描  述</td>
			<td><textarea name="description" rows="6" cols="40"></textarea></td>
		</tr>
		<tr>
		    <td colspan="2">
			<input type="submit" value="添加客户"></td>
		</tr>
		
		
		
		</table>
		</form>
  </body>
</html>
