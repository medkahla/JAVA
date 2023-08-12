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
    <title>New Ninjas</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container d-flex justify-content-between">
		<h1>Add new ninja:</h1>
		<a href="/"><button class="btn btn-warning">Go Back</button></a>
	</div>
	<div class="container">
	<form:form action="/ninja/add" method="post" modelAttribute="ninja">
                    <div class="form-group">
                        <form:label path="dojo">Dojo:</form:label>
						<form:errors path="dojo" class="text-danger" />
                        <form:select path="dojo" class="form-control">
                        	<c:forEach items="${dojos }" var="oneDojo">
                        	<form:option value="${oneDojo.id }">
                        	${oneDojo.name }
                        	</form:option>
                        	</c:forEach>	
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:label path="firstName">First name:</form:label>
                        <form:input path="firstName" class="form-control" />
                        <form:errors path="firstName" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="lastName">Last name:</form:label>
                        <form:input path="lastName" class="form-control" />
                        <form:errors path="lastName" class="text-danger" />
                    </div>
                    <div class="form-group">
                        <form:label path="age">Age:</form:label>
                        <form:input type="number" path="age" class="form-control" />
                        <form:errors path="age" class="text-danger" />
                    </div>
                    <br>
                    <button class="btn btn-success">Submit</button>
	
	</form:form>
	
	</div>

</body>
</html>