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
    <title>Dojo Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<center><h1>${dojo.name }</h1></center>
<div class="container d-flex justify-content-between">
	<h2>Ninjas in this dojo:</h2>
	<a href="/"><button class="btn btn-warning">Go Back</button></a>
</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<th>First name</th>
				<th>Last name</th>
				<th>Age</th>
			</thead>
			<tbody>
			<c:forEach items="${dojo.ninjas}" var="oneNinja" >
				<tr>
					<td>${oneNinja.firstName}</td>
					<td>${oneNinja.lastName}</td>
					<td>${oneNinja.age}</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
	</div>
</body>
</html>