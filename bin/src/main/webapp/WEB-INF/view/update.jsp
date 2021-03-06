<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
<link rel="stylesheet"
	href="<spring:url value='/resources/css/app.css' />">
</head>
<body>
<div>
	<form:form modelAttribute="todo" method="post">
		<form:errors path="*" cssClass="error-box" />
		<div class="input-group">
			<label>Name</label>
			<form:input path="name"/>
		</div>
		<div class="input-group">
			<form:input path="status" type="hidden"/>
		</div>
		<div class="input-group">
			<label>Start Date</label>
			<form:input path="startDate" type="date"/>
		</div>
		<form:button action="update" method="post">Save</form:button>
		<button type="button" onclick="window.location.href='<spring:url value="/todo" />'">Cancel</button>
	</form:form>
</div>

	<script src="<spring:url value='/resources/js/app.js' />"></script>

</body>
</html>