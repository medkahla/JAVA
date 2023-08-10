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
    <title>Show Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>

	<div class="container">
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h2 class="mb-0">Expense Details</h2>
        <a href="/" class="btn btn-warning">Go back</a>
    </div>
    <div class="card">
        <div class="card-body">
            <p class="mb-1"><strong>Name:</strong> <c:out value="${thisExpense.name}"></c:out></p>
            <p class="mb-1"><strong>Vendor:</strong> <c:out value="${thisExpense.vendor}"></c:out></p>
            <p class="mb-1"><strong>Amount:</strong> <c:out value="${thisExpense.amount}"></c:out> $</p>
            <p class="mb-0"><strong>Description:</strong> <c:out value="${thisExpense.description}"></c:out></p>
        </div>
    </div>
</div>

</body>
</html>