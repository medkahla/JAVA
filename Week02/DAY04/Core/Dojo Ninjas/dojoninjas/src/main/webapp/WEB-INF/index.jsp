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
<div class="container d-flex justify-content-between">
	<h1>List of dojos:</h1>
	<a href="/ninja/add"><button class="btn btn-success">Add Ninja</button></a>
</div>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<th>Dojos</th>
				<th>Added At</th>
				<th>Nbr of Ninjas</th>
			</thead>
			<tbody>
			<c:forEach items="${dojos}" var="oneDojo" >
				<tr>
					<td><a href="/dojos/${oneDojo.id}">${oneDojo.name}</a></td>
					<td>${oneDojo.createdAt}</td>
					<td>${oneDojo.ninjas.size()}</td>
				</tr>
			</c:forEach>			
			</tbody>
		</table>
	</div>
	<hr>
	<div class="container">
		<div class="card text-center">
		  <div class="card-header">
		    <h3>Add new dojo:</h3>
		  </div>
		  <div class="card-body">
    <div class="container">
        <div class="row justify-content-center"> <!-- Center the row horizontally -->
            <div class="col-lg-6"> <!-- Set the column width -->
                <form:form action="/new" method="post" modelAttribute="dojo">
                    <form:errors path="*" class="alert alert-danger" />
                    <div class="form-group">
                        <form:label path="name">Name:</form:label>
                        <form:input path="name" class="form-control" />
                    </div>
                    <br>
                    <button class="btn btn-success">Submit</button>
                </form:form>
            </div>
        </div>
    </div>
</div>
		</div>
	</div>

</body>
</html>