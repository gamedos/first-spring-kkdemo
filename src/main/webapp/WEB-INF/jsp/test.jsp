<<<<<<< HEAD
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- 引入jstl--%>
<%@include file="common/tag.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@include file="common/header.jsp"%>
</head>
<body>


	<%-- 页面显示部分 --%>
	<div class="container">
		<div class="popover-title">
			http://www.kkmh.com/web/tags/${tags}?count=50&page=${curpage}
		</div>
		<div>
			<ul  class="pagination">
				<li><a href="<%=request.getContextPath()%>/test/test?page=${prepage}">上一页</a></li>
				<li><a href="<%=request.getContextPath()%>/test/test?page=${nextpage}">下一页</a></li>
			</ul>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>title</th>
							<th>comicsCount</th>
							<th>likes</th>
							<th>authName</th>
							<th>createdAt</th>
							<th>updatedAt</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${kkTopics}">
							<tr>
								<td>${sk.id}</td>
								<td>${sk.title}</td>
								<td>${sk.comicsCount}</td>
								<td>${sk.likes}</td>
								<td>${sk.authName}</td>
								<td>${sk.createdAt}</td>
								<td>${sk.updatedAt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>



</body>
=======
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%-- 引入jstl--%>
<%@include file="common/tag.jsp"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<%@include file="common/header.jsp"%>
</head>
<body>


	<%-- 页面显示部分 --%>
	<div class="container">
		<div class="popover-title">
			http://www.kkmh.com/web/tags/${tags}?count=50&page=${curpage}
		</div>
		<div>
			<ul  class="pagination">
				<li><a href="<%=request.getContextPath()%>/test/test?page=${prepage}">上一页</a></li>
				<li><a href="<%=request.getContextPath()%>/test/test?page=${nextpage}">下一页</a></li>
			</ul>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>列表</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>id</th>
							<th>title</th>
							<th>comicsCount</th>
							<th>likes</th>
							<th>authName</th>
							<th>createdAt</th>
							<th>updatedAt</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="sk" items="${kkTopics}">
							<tr>
								<td>${sk.id}</td>
								<td>${sk.title}</td>
								<td>${sk.comicsCount}</td>
								<td>${sk.likes}</td>
								<td>${sk.authName}</td>
								<td>${sk.createdAt}</td>
								<td>${sk.updatedAt}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>



</body>
>>>>>>> branch 'master' of https://github.com/gamedos/first-spring-kkdemo.git
</html>