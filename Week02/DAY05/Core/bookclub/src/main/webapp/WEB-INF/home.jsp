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
		<h1>Welcome <c:out value="${userIn.userName }" /></h1>
		<a href="/books/new"><button class="btn btn-success">Add a Book</button></a>	
		<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
	</div>
	<div class="container">
		<table class="table table-striped">
   			<thead>
   				<tr>
   					<th>Title</th>
   					<th>Author</th>
   					<th>Poster</th>
   				</tr>
		   </thead>
		   <tbody>
		   	<c:forEach items="${booksList }" var="oneBook" >
   				<tr>
		   			<td><a href="/books/${oneBook.id}">${oneBook.title}</a></td>
		   			<td>${oneBook.author}</td>
		   			<td>${oneBook.poster.userName}</td>
		   		</tr>
		   </c:forEach>
		   </tbody>
		 </table>
	</div>
</div>
</body>
</html>