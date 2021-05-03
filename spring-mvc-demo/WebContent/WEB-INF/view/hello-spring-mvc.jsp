<!DOCTYPE html>
<html>
	<head>
		<title>SPRING MVC DEMO</title>
		<link rel="stylesheet" type="text/css" 
		  href="${pageContext.request.contextPath}/resources/css/test.css" />
		<script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
	</head>
	<body>
		<h1>Hello Spring MVC Demo!</h1>
		
		<br>
		<br>
		
		<a href="showForm">Registration Form</a>
		
		<br>
		<br>
		
		<a href="showFormV2">Registration Form(Model)</a>
		
		<br>
		<br>
		
		<a href="showFormV3">Registration Form(Request Param)</a>
		
		<br>
		<br>
		
		<a href="new/showForm">New Registration Form(Controller Request Mapping)</a>
		
		<br>
		<br>
		
		<a href="student/signupForm">Student Registration Form(Spring MVC Form Tags)</a>
		
		<br>
		<br>
		
		<a href="customer/customerForm">Customer Registration Form(Spring MVC Form Tag Validation(using Hibernate Validator))</a>
		
		<br>
		<br>
		
		<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />
		
		<br>
		<br>
		
		<input type="button" onclick="doSomeWork()" value="Check JS"/>
		
	</body>
</html>