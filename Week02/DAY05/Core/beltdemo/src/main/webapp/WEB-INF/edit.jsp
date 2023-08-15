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
		<form:form action="/cars/${car.id}/edit" method="post" modelAttribute="car">
		<input type="hidden" name="_method" value="put"/>
		<form:errors path="*" class="text-danger"/>
     	  <!-- Email input -->
		      <div class="form-outline mb-4">
		        <form:label class="form-label" path="model">Model</form:label>
		        <form:input class="form-control" path="model"/>
		      </div>
		
		      <!-- Password input -->
		      <div class="form-outline mb-4">
		        <form:label class="form-label" path="color">Color</form:label>
		        <form:input type="color" class="form-control" path="color"/>
		      </div>
            <!-- Submit button -->
		  <button type="submit" class="btn btn-primary btn-block mb-4">Add car</button>
		</form:form>
	</div>
</body>
</html>