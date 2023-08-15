<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome in the Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
<!-- change to match your file/naming structure -->
</head>
<body>
	<div class="container">
		<div class="header d-flex justify-content-around align-items-center">
			<h1>
				Welcome "
				<c:out value="${userIn.firstName }" />
				" 🖐🖐
			</h1>
			<a href="/logout"><button class="btn btn-danger">LogOut</button></a>
		</div>
		<hr>
		<div class="container">
			<div class="card">
				<div class="card-header d-flex justify-content-between">
					<h4>Here is the list of the available projects:</h4>
					<a href="/projects/new"><button
							class="btn btn-outline-secondary">Add Project 📄</button></a>
				</div>
				<div class="card-body">
					<table class="table table-striped">
						<thead>
							<tr>
								<th>Project</th>
								<th>Leader</th>
								<th>Due Date</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
								<c:forEach items="${projectsList}" var="oneProject">
							<c:if test="${userIn.id != oneProject.leader.id && !oneProject.teamMembers.contains(userIn)}">
									<tr>
										<td>
											<a href="/projects/${oneProject.id}/show"> ${oneProject.title}</a>
										</td>
										<td>${oneProject.leader.firstName} ${oneProject.leader.lastName}</td>
										<td>
											<fmt:formatDate value="${oneProject.dueDate}" pattern="dd MMMM yyyy" />
										</td>
											<td class="d-flex justify-content-around">
											<a href="/jointheteam/${oneProject.id}">
												<button class="btn btn-outline-primary">Join the team</button>
											</a>
									</tr>
							</c:if>							
								</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>

		<hr>

		<div class="container">
			<div class="card">
				<div class="card-header">
					<h4>Your projects:</h4>
				</div>
				<div class="card-body">
										<table class="table table-striped">
						<thead>
							<tr>
								<th>Project</th>
								<th>Leader</th>
								<th>Due Date</th>
								<th>Actions</th>
							</tr>
						</thead>
						<tbody>
								<c:forEach items="${projectsList}" var="oneProject">
								<c:if test="${userIn.id == oneProject.leader.id || oneProject.teamMembers.contains(userIn)}">
									<tr>
										<td><a href="/projects/${oneProject.id}/show">
												${oneProject.title}</a></td>
										<td>${oneProject.leader.firstName}
											${oneProject.leader.lastName}</td>
										<td><fmt:formatDate value="${oneProject.dueDate}"
												pattern="dd MMMM yyyy" /></td>
										<td class="d-flex justify-content-around">
										<c:if test="${userIn.id == oneProject.leader.id}">
											<a href="/projects/${oneProject.id}/edit">
													<button class="btn btn-outline-primary">Edit</button>
											</a>
										</c:if>
										<c:if test="${oneProject.teamMembers.contains(userIn)}">
											<a href="/leavetheteam/${oneProject.id}">
													<button class="btn btn-outline-primary">Leave the team</button>
											</a>
										</c:if>
									</tr>
								</c:if>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</body>
</html>