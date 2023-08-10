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
    <title>Edit Expense</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
	<h1>Edit Expense "${travel.name}"</h1>
	<hr>
	<div class="container">
        <div class="row justify-content-center"> <!-- Center the row horizontally -->
            <div class="col-lg-6"> <!-- Set the column width -->
                <form:form action="/expenses/edit/${travel.id}" method="post" modelAttribute="travel">
                <input type="hidden" name="_method" value="put">
                    <form:errors path="*" class="alert alert-danger" />
                    <div class="form-group">
                        <form:label path="name">Name:</form:label>
                        <form:input path="name" class="form-control" />
                    </div>
                    <div class="form-group">
                        <form:label path="vendor">Vendor:</form:label>
                        <form:input path="vendor" class="form-control" />
                    </div>
                    <div class="form-group">
                        <form:label path="amount">Amount:</form:label>
                        <form:input type="float" path="amount" placeholder="$ " class="form-control" />
                    </div>
                    <div class="form-group">
                        <form:label path="description">Description:</form:label>
                        <form:textarea path="description" class="form-control" />
                    </div>
                    <br>
                    <button class="btn btn-success">Edit</button>
                </form:form>
            </div>
        </div>
    </div>

</body>
</html>