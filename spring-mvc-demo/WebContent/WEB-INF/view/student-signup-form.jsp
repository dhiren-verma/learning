<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form("Spring MVC Form Tags")</title>
	</head>
	<body>
		<h2>Enter required details:</h2>
		<br>
		<form:form action="processSignup" modelAttribute="student">
			
			First Name: <form:input type="text" path="firstName" />
			
			<br>
			<br>
			
			Last Name: <form:input type="text" path="lastName" />
			
			<br>
			<br>
			
			Standard: <form:select path="standard">
				<!-- 
				<form:option value="1st" label="First" />
				<form:option value="2nd" label="Second" />
				<form:option value="3rd" label="Third" />
				<form:option value="4th" label="Fourth" />
				<form:option value="5th" label="Fifth" />
				<form:option value="6th" label="Sixth" />
				<form:option value="7th" label="Seventh" />
				<form:option value="8th" label="Eighth" />
				<form:option value="9th" label="Ninth" />
				<form:option value="10th" label="Tenth" />
				<form:option value="11th" label="Eleventh" />
				<form:option value="12th" label="Twelfth" />
				 -->
				 
				 <!-- Loading Options from the Bean passed in Model as Model Attribute: -->
				 <!-- 
				 <form:options items="${student.standardOptions}" />
				  -->
				  
				 <!-- Loading Options from a separate Model Attribute -->
				 <form:options items="${standardOpts}" />
				 
			</form:select>
			
			<br>
			<br>
			
			Favorite Subject:
			<br>
			English <form:radiobutton path="favoriteSubject" value="English" />
			Hindi <form:radiobutton path="favoriteSubject" value="Hindi" />
			Mathematics <form:radiobutton path="favoriteSubject" value="Mathematics" />
			Science <form:radiobutton path="favoriteSubject" value="Science" />
			Social Science <form:radiobutton path="favoriteSubject" value="Social Science" />
			
			<br>
			<br>
			
			Hobbies:
			<br>
			Swimming <form:checkbox path="hobbies" value="Swimming" />
			Reading <form:checkbox path="hobbies" value="Reading" />
			Singing <form:checkbox path="hobbies" value="Singing" />
			Painting <form:checkbox path="hobbies" value="Painting" />
			
			<br>
			<br>
			
			<input type="submit" value="Submit" />
			
		</form:form>
	</body>
</html>