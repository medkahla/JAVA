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
<title>Omikuji Form</title>
</head>
<body>
	<div class="container">
		<div class="card border-primary text-primary">
			<div class="card-header"><center><h3>Send an Omikuji</h3></center></div>
		  <div class="card-body">
				<form action="/process" method="post" class="needs-validation" novalidate="">
				
					  <div class="row mb-3">
					    <label for="validationCustom01" class="form-label">Pick a number between 5 and 25:</label>
						<div class="col-sm-2">
					    	<input name="num" type="number" class="form-control" id="validationCustom01" required="true">
						    <div class="invalid-feedback">
						      Pick any number from 5 to 25
						    </div>
						</div>
					  </div>
				
				  <div class="col-md-4">
				    <label for="validationCustom01" class="form-label">Enter the name of any city:</label>
				    <input name="city" class="form-control" id="validationCustom01" required="true">
				    <div class="valid-feedback">
				      Looks good!
				    </div>
				  </div>
				  
				  <div class="col-md-4">
				    <label for="validationCustom01" class="form-label">Enter a name of a real person:</label>
				    <input name="person" class="form-control" id="validationCustom01" required="true">
				    <div class="valid-feedback">
				      Looks good!
				    </div>
				  </div>
				  
				  <div class="col-md-4">
				    <label for="validationCustom01" class="form-label">Enter professional endeavor or hobby:</label>
				    <input name="hobby" class="form-control" id="validationCustom01" required="true">
				    <div class="valid-feedback">
				      Looks good!
				    </div>
				  </div>
				  
				  <div class="col-md-4">
				    <label for="validationCustom01" class="form-label">Enter any type of living thing:</label>
				    <input name="thing" class="form-control" id="validationCustom01" required="true">
				    <div class="valid-feedback">
				      Looks good!
				    </div>
				  </div>
				  <div class="col-md-4">
				    <label for="validationCustom01" class="form-label">Say something nice to someone:</label>
					<textarea name="nice" rows="" cols=""  id="validationTextarea" class="form-control" required></textarea>
					<div class="invalid-feedback">
				      Some nice words!
				    </div>
				  </div>
					<br>
				  <p>Send and show to a friend </p>
				  <center>
					<button class="btn btn-primary">Submit</button>
				</center>
				</form>
		  </div>
		</div>
	</div>
	
	
	
	<script type="text/javascript"> 
	var forms = document.querySelectorAll('.needs-validation')
	Array.prototype.slice.call(forms)
	  .forEach(function (form) {
	    form.addEventListener('submit', function (event) {
	      if (!form.checkValidity()) {
	        event.preventDefault()
	        event.stopPropagation()
	      }
	
	      form.classList.add('was-validated')
	    }, false)
	  })
	</script>
</body>
</html>