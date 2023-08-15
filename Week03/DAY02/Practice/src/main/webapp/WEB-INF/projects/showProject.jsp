<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) --> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-between">
			<a href="/dashboard"><button class="btn btn-success">Go Back</button></a>
			<a href="/logout"><button class="btn btn-danger">Logout</button></a>
		</div>
		<div class="card m-5">
			<div class="card-header">
				<h1 style="color:blue;">${project.title}</h1>
			</div>
			<div class="card-body">
				<h2>This project: </h2> 
				<p>${project.title}</p>
				<h2>Description: </h2> 
				<p>${project.description}</p>
				<h2>Due Date: </h2> 
				<p>${project.dueDate}</p>
			</div>
		</div>
	</div>
	<div class="footer d-flex justify-content-around">
			<a href="/projects/${project.id}/tasks">
				<button class="btn btn-outline-secondary">Show Tasks</button>
			</a>
		<c:if test="${userIn.id == project.leader.id }">
			<a href="/projects/${project.id}/edit">
				<button class="btn btn-outline-primary">Edit</button>
			</a>
			<form action="/projects/${project.id}/delete" method="post">
				<input type="hidden" name="_method" value="delete">
				<button class="btn btn-outline-warning">Delete</button>
			</form>
		</c:if>
	</div>
</body>
</html>