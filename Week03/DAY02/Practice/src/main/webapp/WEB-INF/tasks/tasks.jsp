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
    <title>Tasks List</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<div class="container d-flex justify-content-around align-items-center">
		<a href="/dashboard"><button class="btn btn-warning">GoBack</button></a>
		<h2>Welcome</h2><h1 class="text-primary"> " <c:out value="${userIn.firstName }"  /> "</h1><h5>(Project leader: <span class="text-primary">" <c:out value="${thisProject.leader.firstName}"/> "</span>)</h5>	
		<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
	</div>

	<div class="container">
	<div class="card">
		<div class="card-header d-flex align-items-center">
		<h3>For this project: </h3> <h2 class="text-info"><c:out value="${thisProject.title}"/></h2> 
		</div>
		<div class="card-body">
			<table class="table table-striped">
   			<thead>
   				<tr>
   					<th>ID</th>
   					<th>Description</th>
   					<th>Due Date</th>
   					<th>Poster</th>
   					<th>Added at</th>
   				</tr>
		   </thead>
		   <tbody>
				<c:forEach items="${listTasks}" var="oneTask">
					<tr>
						<th>${oneTask.id}</th>
						<td>${oneTask.description}</td>
						<td><fmt:formatDate value="${oneTask.dueDate}" pattern="dd MMMM yyyy" /></td>
						<td>${oneTask.poster.firstName}</td>
						<td>${oneTask.createdAt}</td>						
					</tr>
				</c:forEach>
		   </tbody>
		 </table>
		</div>
	</div>
	</div><br>
	<c:if test="${userIn.id == thisProject.leader.id || thisProject.teamMembers.contains(userIn)}">
	<div class="container card"  style="width: 28rem;">
	<div class="card-header">
		<h3>Add a new task:</h3>
	</div>
	<div class="card-body">
		<form:form action="/projects/${thisProject.id}/tasks" method="post" modelAttribute="task">
			<form:errors path="*" class="text-danger"/>

			      <div class="form-outline mb-4">
			        <form:label class="form-label" path="description">Description</form:label>
			        <form:input class="form-control" path="description"/>
			      </div>

			      <div class="form-outline mb-4">
			        <form:label class="form-label" path="dueDate">Due Date</form:label>
			        <form:input type="date" class="form-control" path="dueDate"/>
			      </div>
			      
		  <button type="submit" class="btn btn-primary btn-block mb-4">Add task</button>
		</form:form>
	  </div>	
	</div>
	</c:if>
	
	
</div>
</body>
</html>