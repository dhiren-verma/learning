<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Welcome to Spring Security Demo</title>
	</head>
	<body>
		Hello: <security:authentication property="principal.username" /> with role: <security:authentication property="principal.authorities" />
		
		<h2>Welcome to Spring Security Demo!</h2>
		
		<security:authorize access="hasRole('MANAGER')">
			<hr>
			<p>
				<a href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a>
				(Only for Managers)
			</p>
		</security:authorize>
		
		<security:authorize access="hasRole('ADMIN')">
			<hr>
			<p>
				<a href="${pageContext.request.contextPath}/systems">IT Systems Meetings</a>
				(Only for Administrators)
			</p>
		</security:authorize>
		
		<hr>
		
		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
			<input type="submit" value="Logout" />
		</form:form>
	</body>
</html>