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
	<div class="container d-flex justify-content-around">
		<h1>Welcome <c:out value="${userIn.userName }" /></h1>	
		<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
	</div>
	<div class="container">
		<table class="table table-striped">
   			<thead>
   				<tr>
   					<th>Model</th>
   					<th>Color</th>
   					<th>Driver</th>
   					<th>Actions</th>
   				</tr>
		   </thead>
		   <tbody>
				<c:forEach items="${listCars}" var="oneCar">
					<tr>
						<td>
						<a href="/cars/${oneCar.id}/show">
							${oneCar.model}
						</a>
						</td>
						<td><span class="badge badge-pill" style="color:${oneCar.color};">${oneCar.color}</span></td>
						<td>${oneCar.driver.userName}</td>
						<c:if test="${oneCar.driver.id == userIn.id}">
							<td class="d-flex justify-content-around">
							<a href="/cars/${oneCar.id}/edit">
								<button class="btn btn-outline-secondary">Edit</button>
							</a>						
							<form action="/cars/${oneCar.id}/delete" method="post">
								<input type="hidden" name="_method" value="delete">
								<button class="btn btn-outline-warning">Delete</button>
							</form>
							</td>
						</c:if>							
					</tr>
				</c:forEach>
		   </tbody>
		 </table>
	</div>
	
	<div class="container card"  style="width: 28rem;">
	<div class="card-header">
		<h3>Add a car here:</h3>
	</div>
	<div class="card-body">
	<form:form action="/cars" method="post" modelAttribute="car">
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
	
	</div>
	
	
</div>
</body>
</html>