<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form(Spring Form Tags)</title>
	</head>
	<body>
		<h2><a href="customer/showForm">Customer Form</a></h2>
		
		<h2>Student Registration Form(Spring Form Tags)</h2>
		
		<form:form action="stuSignupForm" modelAttribute="student">
			First Name: <form:input type="text" path="firstName" />
			
			<br>
			<br>
			
			Last Name: <form:input type="text" path="lastName" />
			
			<br>
			<br>
			
			<input type="submit" value="Submit" />
			
		</form:form>
	</body>
</html>