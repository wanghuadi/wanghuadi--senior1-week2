<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
</head>
<body>
	
	
	<form action="queryAll" method="post">
		价格范围:<input type="text" name="startPrice">~<input type="text" name="endPrice">
		已售百分比:<input type="text" name="startSales">~<input type="text" name="endSales">
		排序:<select name="column">
				<option value="">请选择</option>
				<option value="sales">已售百分比</option>
				<option value="price">价格</option>
			</select>
			<select name="orders">
				<option value="">请选择</option>
				<option value="asc">升序</option>
				<option value="desc">倒序</option>
			</select>
		<input type="submit" value="搜索">
	</form>
	
	<table>
		<tr>
			<td>ID</td>
			<td>商品名称</td>
			<td>秒杀价格</td>
			<td>已售百分比</td>
		</tr>
	<c:forEach items="${page.list }" var="g">
		<tr>
			<td>${g.id }</td>
			<td>${g.name }</td>
			<td>¥${g.price }</td>
			<td>${g.sales }%</td>
		</tr>
	</c:forEach>
	
	<tr>
		<td colspan="10">
			<a href="?pageNum=1">首页</a>
			<a href="?pageNum=${page.pageNum-1 < 1?page.pageNum:page.pageNum-1 }">上一页</a>
			<a href="?pageNum=${page.pageNum+1 > page.pages ?page.pageNum:page.pageNum+1  }">下一页</a>
			<a href="?pageNum=${page.pages }">尾页</a>
		</td>
	</tr>
	</table>
	
</body>
</html>