<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FruityLoops</title>

<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
	<div class="card text-white bg-secondary">
	  <div class="card-header"><h2>Fruit Store</h2></div>
	  <div class="card-body">
	  <div class="container">
	    <table class="table table-striped table-bordered">
		  <thead>
		    <tr>
		      <th scope="col" class="text-white">Fruit</th>
		      <th scope="col" class="text-white">Price</th>
		    </tr>
		  </thead>
		  <tbody>
		  <c:forEach var="fruit" items="${fruits}">
		    <tr>
		      <td class="text-white">${fruit.name}</td>
		      <td class="text-white">${fruit.price}</td>
		    </tr>
		  </c:forEach>		    
		  </tbody>
		</table>
		</div>
	  </div>
	</div>
</div>
</body>
</html>