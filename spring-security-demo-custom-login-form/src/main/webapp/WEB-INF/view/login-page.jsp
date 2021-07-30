<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Spring Security - Custom Login Page</title>
		<style>
			.failed {
				color: red;
			}
		</style>
	</head>
	<body>
		<h3>My Custom Spring Security Login Form</h3>
		
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
			<c:if test="${param.error!=null}" >
				<i class="failed">Sorry! You have entered Invalid username/password</i>
			</c:if>
			
			<table>
				<tr>
					<td>User-name:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
			</table>
			
			<input type="submit" value="Login" />
			
		</form:form>
	</body>
</html>