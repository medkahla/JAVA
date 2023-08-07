<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="ISO-8859-1">
<title>Omikuji Show</title>
</head>
<body>
	<div class="container">
		<div class="card border-primary text-primary">
			<div class="card-header"><center><h3>Here's your Omikuji</h3></center></div>
				<div class="card-body color-primary">
						
				<center>
				<div class="card border-success text-success">
					<h4>
						In ${num} years, you will live in ${city} with ${person} as your roomate, 
						${hobby} for living. The next time you see ${thing}, you will have good luck.
						Also, ${nice}.
					</h4>
				</div>
				</center>
				</div>
			</div>
			<center><a href="/omikuji">Go Back</a></center>
	</div>
</body>
</html>