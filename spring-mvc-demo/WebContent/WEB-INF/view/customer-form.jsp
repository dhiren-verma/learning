<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Customer Form</title>
		
		<style>
			.error {color:red}
			
			.tab {tab-size:2}
		</style>
	</head>
	<body>
		<form:form action="processCustomerForm" modelAttribute="cust">
			<pre class="tab">First Name:	<form:input path="firstName" /></pre>
			
			<pre class="tab">LastName(*):	<form:input path="lastName" />
			<form:errors path="lastName" cssClass="error" /></pre>
			
			<pre class="tab">FreePasses:	<form:input path="freePasses" />
			<form:errors path="freePasses" cssClass="error" /></pre>
			
			<pre class="tab">Postal Code:	<form:input path="postalCode" />
			<form:errors path="postalCode" cssClass="error" /></pre>
			
			<pre class="tab">Course Code:	<form:input path="courseCode" />
			<form:errors path="courseCode" cssClass="error" /></pre>
			
			<br>
			
			<input type="submit" value="Submit" />
		</form:form>
	</body>
</html>