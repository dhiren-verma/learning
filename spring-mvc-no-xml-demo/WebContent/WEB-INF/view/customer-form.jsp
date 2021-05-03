<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
	<head>
		<title>Spring MVC Validation Demo(Hibernate Validator)</title>
		<style>
			.error {color:red}
		</style>
	</head>
	<body>
		<form:form action="custValidationForm" modelAttribute="customer">
			First Name: <form:input path="firstName" />
			
			<br>
			<br>
			
			Last Name(*): <form:input path="lastName" />
			<form:errors path="lastName" cssClass="error" />
			
			<br>
			<br>
			
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>