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
<title>New Show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-between align-items-center">
			<a href="/shows"><button class="btn btn-warning">GoBack</button></a>
			<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
		</div>
		<hr>
		<div class="card">
			<div class="card-header">
				<h4>Fill this form and add a new show:</h4>
			</div>
			<div class="card-body">
				<form:form action="/shows/new" method="post" modelAttribute="show">
					<form:errors path="*" class="text-danger" />
					
					<!-- Title input -->
					<div class="form-outline mb-4">
						<form:label class="form-label" path="title">Title</form:label>
						<form:input class="form-control" path="title" />
					</div>
					
					<!-- Network input -->
					<div class="form-outline mb-4">
						<form:label class="form-label" path="network">Network</form:label>
						<form:input class="form-control" path="network" />
					</div>
					
					<!-- Description input -->
					<div class="form-outline mb-4">
						<form:label class="form-label" path="description">Description</form:label>
						<form:textarea class="form-control" path="description" />
					</div>
					
					<!-- Submit button -->
					<center>
						<button type="submit" class="btn btn-success btn-block mb-4">Add Show</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>