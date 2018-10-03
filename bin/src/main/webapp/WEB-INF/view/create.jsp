<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<spring:url value='/resources/css/app.css'/>">
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Create new Todo</title>
<style>
th{
	padding: 5px;
	text-align: right;
}
input {
	background: transparent;
	border-bottom: 5px solid black; 
}

</style>
</head>
<body>
<script src="<spring:url value='/resources/js/app.js' />"></script>
<div>
	<form:form modelAttribute="create">
		<div class="input-group">
			<label>Id</label>
			<form:input path="id" type="hidden" />
		</div>
		<div class="input-group">
			<label>Name</label>
			<form:input path="name" />
		</div>
		<div class="input-group">
			<label>Status</label>
			<form:input path="status" />
		</div> 
		<div class="input-group">
			<label>Start Date</label>
			<form:input path="startDate" type="date" />
		</div>
		<div class="input-group">
			<label>End At</label>
			<form:input path="endAt" />
		</div>
		<form:button>Save</form:button>
			<button type="button"
				onclick="window.location.href='<spring:url value="/todo" />'">Cancel</button>
	</form:form>
</div>

</body>
</html>