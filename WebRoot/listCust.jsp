<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript">
	function checkAll(allC) {
		var otherCs = document.getElementsByName("delId");
		for (var i = 0; i < otherCs.length; i++) {
			otherCs[i].checked = allC.checked;
		}
	}
</script>
</head>

<body style="text-align: center">
	<h1>客户管理系统_信息列表</h1>
	<hr>
	<form
		action="${pageContext.request.contextPath }/FindCustByCondServelt"
		method="post">
		客户姓名：<input type="text" name="name" value="${param.name }">
		性别：<input type="radio" name="gender" value="男"
			<c:if test="${param.gender=='男' }">checked='checked'</c:if>>男<input
			type="radio" name="gender" value="女"
			<c:if test="${param.gender=='女' }">checked='checked'</c:if>>女
			<input type="radio" name="gender" value=""
			<c:if test="${param.gender=='' }">checked='checked'</c:if>>无论男女
		客户类型：<select name="type">
		<option value=""
				<c:if test="${param.type=='' }">selected="selected"</c:if>></option>
			<option value="钻石客户"
				<c:if test="${param.type=='钻石客户' }">selected="selected"</c:if>>钻石客户</option>
			<option value="白金客户"
				<c:if test="${param.type=='白金客户' }">selected="selected"</c:if>>白金客户</option>
			<option value="黄金客户"
				<c:if test="${param.type=='黄金客户' }">selected="selected"</c:if>>黄金客户</option>
			<option value="普通客户"
				<c:if test="${param.type=='普通客户' }">selected="selected"</c:if>>普通客户</option>
			<option value="青铜客户"
				<c:if test="${param.type=='青铜客户' }">selected="selected"</c:if>>青铜客户</option>
		</select> <input type="submit" value="查询">
	</form>
	<form action="${pageContext.request.contextPath }/BatchDelCustServlet"
		method="post">
		<table border="1" width="100%">
			<tr>
				<th><input type="checkbox" onclick="checkAll(this)" />全选</th>
				<th>客户姓名</th>
				<th>客户性别</th>
				<th>出生日期</th>
				<th>电话号码</th>
				<th>邮 箱</th>
				<th>客户爱好</th>
				<th>客户类型</th>
				<th>描 述</th>
				<th></th>
			</tr>
			<c:forEach items="${requestScope.list}" var="cust">
				<tr>
					<td><input type="checkbox" value="${cust.id }" name="delId"></td>
					<td><c:out value="${cust.name }"></c:out></td>
					<td><c:out value="${cust.gender }"></c:out></td>
					<td><c:out value="${cust.birthday}"></c:out></td>
					<td><c:out value="${cust.cellphone }"></c:out></td>
					<td><c:out value="${cust.email }"></c:out></td>
					<td><c:out value="${cust.preference }"></c:out></td>
					<td><c:out value="${cust.type }"></c:out></td>
					<td><c:out value="${cust.description }"></c:out></td>
					<td><a
						href="${pageContext.request.contextPath }/CustInfoServlet?id=${cust.id}">修改</a></td>
					<td><a
						href="${pageContext.request.contextPath }/DelCustServlet?id=${cust.id}">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<input type="submit" value="批量删除" />
	</form>
</body>
</html>
