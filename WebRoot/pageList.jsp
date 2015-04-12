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
	 function changePage(obj) {
	 	if(isNaN(obj.value)){
			alert("必须是数字");
			obj.value=${page.thispage}
			return; 	
	 	}else if(obj.value<=0 || obj.value>${page.countpage}){
				alert("页码需在有效范围内");
				obj.value=${page.thispage}
				return; 	
	 	}else{
	 		Window.location.href="${pageContext.request.contextPath }/PageCustServlet?thispage="+obj.value;
	 	}
		
	}
	
	</script>
</head>
<body style="text-align: center;">
	<h1>分页显示客户信息</h1>
	<hr>
	<table border="1" width="100%">
		<tr>
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
		<c:forEach items="${requestScope.page.list}" var="cust">
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
	共${page.countrow }条记录 共${page.countpage}页
	<a
		href="${pageContext.request.contextPath }/PageCustServlet?thispage=${page.firstpage}">首页</a>
	<a
		href="${pageContext.request.contextPath }/PageCustServlet?thispage=${page.prepage}">上一页</a>
	<!-- 分页逻辑开始 -->
	<c:if test="${page.countpage<=5 }">
		<c:set var="begin" value="1" scope="page"></c:set>
		<c:set var="end" value="${page.countpage }" scope="page"></c:set>
	</c:if>

	<c:if test="${page.countpage>5 }">
		<c:choose>
			<c:when test="${page.thispage<=3 }">
				<c:set var="begin" value="1" scope="page"></c:set>
				<c:set var="end" value="5" scope="page"></c:set>
			</c:when>
			<c:when test="${page.thispage>=page.countpage-2 }">
				<c:set var="begin" value="${page.countpage-4 }" scope="page"></c:set>
				<c:set var="end" value="${page.countpage}" scope="page"></c:set>
			</c:when>
			<c:otherwise>
				<c:set var="begin" value="${page.thispage-2 }" scope="page"></c:set>
				<c:set var="end" value="${page.thispage+2 }" scope="page"></c:set>
			</c:otherwise>
		</c:choose>
	</c:if>
	<c:forEach begin="${begin }" end="${end }" step="1" var="i">
		<c:if test="${i == page.thispage }">${i }</c:if>
		<c:if test="${i != page.thispage }">
			<a
				href="${pageContext.request.contextPath }/PageCustServlet?thispage=${i}">${i }</a>
		</c:if>

	</c:forEach>
	<!-- 分页逻辑结束 -->
	<a
		href="${pageContext.request.contextPath }/PageCustServlet?thispage=${page.nextpage}">下一页</a>
	<a
		href="${pageContext.request.contextPath }/PageCustServlet?thispage=${page.lastpage}">尾页</a>
		跳到<input type="text" value="${page.thispage }" style="width: 40px" onchange="changePage(this)"/>页
</body>
</html>
