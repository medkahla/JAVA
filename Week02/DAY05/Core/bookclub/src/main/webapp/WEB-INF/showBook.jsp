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
		<div class="container">
			<h1> <c:out value="${book.title }" /></h1>
			<a href="/books"><button class="btn btn-secondary">Go Back</button></a>	
			<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
		</div>
		<h4>
			<c:if test="${user_id == book.poster.id }"><span class="text-danger">You</span></c:if>
			<c:if test="${user_id != book.poster.id }"><span class="text-danger"><c:out value="${book.poster.userName }"/></span></c:if>
			read about <span class="text-warning"><c:out value="${book.title }" /></span> by <span class="text-success"><c:out value="${book.author }" /></span>
		</h4>
		<hr>
		<h5>
		And here's
			<c:if test="${user_id == book.poster.id }"><span class="text-secondary">your</span></c:if>
			<c:if test="${user_id != book.poster.id }"><span class="text-secondary"><c:out value="${book.poster.userName }"/>'s</span></c:if> 
		thoughts:
		</h5>
		<div class="card">
			<div class="card-body">
				<c:out value="${book.thoughts }" />
			</div>
		</div>
		<c:if test="${user_id == book.poster.id }">
		<br>
		<div class="container d-flex justify-content-around">
			   	<a href="/books/${book.id }/edit"><button class="btn btn-outline-primary">Edit</button></a>
			   	<form action="/books/${book.id }" method="post">
				   	<input type="hidden" name="_method" value="delete">
				    <button class="btn btn-outline-danger">Delete</button>
			   	</form>
		</div>
		</c:if>
	</div>
</body>
</html>