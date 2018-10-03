<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<spring:url value='/resources/css/app.css' />">
<meta charset="ISO-8859-1">
<title>View</title>
</head>
<body>
<div>
	<form:form modelAttribute="todo">
		<div class="input-group">
			<label>Name</label>
			<form:input path="name" readonly="true"/>
		</div>
		<div class="input-group">
			<label>Status</label>
			<form:input path="status" readonly="true"/>
		</div>
		<div class="input-group">
			<label>Start Date</label>
			<form:input path="startDate" type="date" readonly="true"/>
		</div>
		<c:if test="${not empty todo.startAt }">
			<div class="input-group">
			<label>Start Date</label>
			<form:input path="startAt" readonly="true"/>
		</div>
		</c:if>
		<c:if test="${not empty todo.endAt }">
			<div class="input-group">
				<label>End At</label>
				<form:input path="endAt" readonly="true"/>
			</div>
		</c:if>
		
	</form:form>
	
	<form:form modelAttribute="todo" action="view" method="get">
		<form:input path="id" name="id" type="hidden"/>
		<c:if test="${todo.status eq 'New' }">
			<td><button type="button" onclick="window.location.href='<spring:url value="/todo/update?id=${todo.id }" />' ">Edit</button>
		</c:if>
		<td><button class="input" type="submit" name="action" value="delete">Delete</button>
		<button type="button" onclick="window.location.href='<spring:url value="/todo" />' ">Cancel</button>
	</form:form>
</div>
<script src="<spring:url value='/resources/js/app.js' />"></script>
</body>
</html>