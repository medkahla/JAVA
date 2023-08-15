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
    <title>Welcome in ProjectManager</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/app.js"></script><!-- change to match your file/naming structure -->
</head>
<body>
<div class="container">
	<div class="header" style="text-align: center;">
		<h1 style="color:blue;">Project Manager</h1>
		<h5>A place for team to manage projects.</h5>
	</div>
   <div class="card text-center">
	  <div class="card-body">
	  	            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                    	    <h3>Login</h3>
                            <!-- Login form content here -->
                          			<form:form action="/login" method="post" modelAttribute="newLogin">
										<form:errors path="*" class="text-danger"/>
									      	  <!-- Email input -->
										      <div class="form-outline mb-4">
										        <form:label class="form-label" for="loginName" path="email">Email</form:label>
										        <form:input type="email" id="loginName" class="form-control" path="email"/>
										      </div>
										
										      <!-- Password input -->
										      <div class="form-outline mb-4">
										        <form:label class="form-label" for="loginPassword" path="password">Password</form:label>
										        <form:input type="password" id="loginPassword" class="form-control" path="password"/>
										      </div>
										            <!-- Submit button -->
						     				  <button type="submit" class="btn btn-primary btn-block mb-4">Log in</button>
									</form:form>
                    </div>
                    <div class="col-md-6">
                    	    <h3>Registration</h3>
                            <!-- Registration form content here -->
                           <form:form action="/register" method="post" modelAttribute="newUser">
					  			<form:errors path="*" class="text-danger"/>
						
						      <!-- First name input -->
						      <div class="form-outline mb-4">
						        <form:label class="form-label" for="registerUsername" path="firstName">First name</form:label>
						        <form:input type="text" id="registerUsername" class="form-control" path="firstName" />
						      </div>
						      <!-- Last name input -->
						      <div class="form-outline mb-4">
						        <form:label class="form-label" for="registerUsername" path="lastName">Last Name</form:label>
						        <form:input type="text" id="registerUsername" class="form-control" path="lastName" />
						      </div>
						
						      <!-- Email input -->
						      <div class="form-outline mb-4">
						        <form:label class="form-label" for="registerEmail" path="email">Email</form:label>
						        <form:input type="email" id="registerEmail" class="form-control"  path="email"/>
						      </div>
						
						      <!-- Password input -->
						      <div class="form-outline mb-4">
						        <form:label class="form-label" for="registerPassword" path="password">Password</form:label>
						        <form:input type="password" id="registerPassword" class="form-control"  path="password"/>
						      </div>
						
						      <!-- Repeat Password input -->
						      <div class="form-outline mb-4">
						        <form:label class="form-label" for="registerRepeatPassword" path="confirm">Confirm password</form:label>
						        <form:input type="password" id="registerRepeatPassword" class="form-control"  path="confirm"/>
						      </div>
						
						      <!-- Submit button -->
						      <button type="submit" class="btn btn-primary btn-block mb-3">Sign in</button>
						    </form:form>
                    </div>
                </div>
            </div>		  
	  </div>
	</div>
	
</div>

</body>
</html>