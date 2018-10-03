<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>M-TODO</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style type="text/css">
.input{
	border: none;
    background: white;
	height: 20px;
	}
	.input {
	border: none;
	background: none;
	height: 20px;
}

.New1 {
	background: white;
}

.New2 {
	background: #CD853F;
}

.Done {
	background: #FFD700;
}

.In-progress {
	background: #00FFFF;
}

.Canceled {
	background: #A52A2A;
}
</style>
</head>
<body>
<div>
	<button type="button" onclick="window.location.href='<spring:url value="/todo/create/" />' ">Create</button>
</div>
	<table class="table">
		<tr>
			<th>No.</th>
			<th>Name</th>
			<th>Status</th>
			<th>Start Date</th>
			<th>Start At</th>
			<th>Ended At</th>
			<th>Action</th>
		</tr>
	<c:forEach var="todo" items="${list}">
		<tr>
			<td>${todo.id }</td>
			<td>${todo.name}</td>
			<td>${todo.status }</td>
			<td>${todo.startDate }</td>
			<td>${todo.startAt }</td>
			<td>${todo.endAt }</td>
			<c:if test="${todo.status eq 'New' }">
				<form:form action="todo/start?id=${todo.id }" method="post">
					<input type="hidden" name="id" value="${todo.id }">
					<td><button class="input" type="submit">Start</button></td>
				</form:form>
			</c:if>
			<c:if test="${todo.status eq 'New'}">
				<form:form action="todo/cancel?id=${todo.id }" method="post">
					<input type="hidden" name="id" value="${todo.id }">
					<td><button class="input" type="submit">Cancel</button>
				</form:form>
			</c:if>
			<c:if test="${todo.status eq 'In-progress' }">
				<form:form action="todo/end?id=${todo.id }" method="post">
					<input type="hidden" name="id" value="${todo.id }">
					<td><button class="input" type="submit">End</button></td>
				</form:form>
			</c:if>			
			<c:if test="${todo.status eq 'New' or todo.status eq 'In-progress' or todo.status eq 'Done'or todo.status eq 'Canceled'}">
						<form:form action="todo/view?id=${todo.id }" method="post">
						<input type="hidden" name="id" value="${todo.id}">
						<td><button class="input" type="submit">View</button></td>
						</form:form>
					</c:if> 
					<c:if test="${todo.status eq 'New'}">
						<form:form action="todo/update?id=${todo.id }" method="get">
						<input type="hidden" name="id" value="${todo.id}">
						<td><button class="input" type="submit">Update</button></td>
						</form:form>
					</c:if> 
					<c:if test="${todo.status eq 'New' or todo.status eq 'Cancel' or todo.status eq 'Done' or todo.status eq 'Canceled'}">
						<form:form action="todo/delete?id=${todo.id }" method="post">
						<input type="hidden" name="id" value="${todo.id}">
							<td><button class="input" type="submit">Delete</button></td>
						</form:form>
					</c:if>
	</c:forEach>
	</table>
</body>
</html>