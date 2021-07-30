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
		<form:form action="${pageContext.request.contextPath}/authenticateTheUser" method="POST">
			<c:if test="${param.error!=null}" >
				<i class="failed">Sorry! You have entered Invalid username/password</i>
			</c:if>
			
			<p>
				User-name: <input type="text" name="username" /><br/>
			</p>
			<p>
				Password: <input type="password" name="password" /><br/>
			</p>
			
			<input type="submit" value="Login" />
		</form:form>
	</body>
</html>