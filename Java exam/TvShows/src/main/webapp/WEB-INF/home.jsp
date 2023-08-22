<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-between">
			<h1>
				Welcome,
				<c:out value="${userIn.userName }"></c:out>
			</h1>
			<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
		</div>
		<div class="card">
			<div class="card-header d-flex justify-content-between">
				<h4>Here is the list of the tv shows:</h4>
				<a href="/shows/new">
				<button	class="btn btn-outline-secondary">Add New Show </button></a>
			</div>
			<div class="card-body">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Show</th>
							<th>Network</th>
							<th>Average Rating</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listShows}" var="oneShow">
							<tr>
								<td><a href="/shows/${oneShow.id}"> <c:out value="${oneShow.title}"/></a></td>
								<td><c:out value="${oneShow.network}"/></td>
								<td><c:out value="${oneShow.avgRate}"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>