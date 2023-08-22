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
			<a href="/shows"><button class="btn btn-success">Go Back</button></a>
			<a href="/logout"><button class="btn btn-danger">Logout</button></a>
		</div>
		<div class="card m-5">
			<div class="card-header">
				<h1 style="color: blue;">${show.title}</h1>
			</div>
			<div class="card-body">
				<h2>This show:</h2>
				<p>${show.title}</p>
				<h2>Description:</h2>
				<p>${show.description}</p>
				<h2>Posted by:</h2>
				<p>${show.poster.userName}</p>
			</div>
		</div>
	</div>
	<div class="footer d-flex justify-content-around">
		<c:if test="${userIn.id == show.poster.id }">
			<a href="/shows/${show.id}/edit">
				<button class="btn btn-outline-primary">Edit</button>
			</a>
			<form action="/show/${show.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete">
				<button class="btn btn-outline-warning">Delete</button>
			</form>
		</c:if>
	</div>

	<hr>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Rater</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${listRates}" var="oneRate">
					<tr>
						<td>${oneRate.poster.userName}</td>
						<td>${oneRate.rate}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<br><hr><br>
		<div class="container card" style="width: 28rem;">
		    <div class="card-header">
				<h3>Leave a rate:</h3>
		    </div>
		    <div class="card-body">
			    <form:form action="/shows/${show.id}" method="post" modelAttribute="rate">
					<form:input class="form-control" type="number" path="rate"/>
					<center>
						<button class="btn btn-outline-primary">Add</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>