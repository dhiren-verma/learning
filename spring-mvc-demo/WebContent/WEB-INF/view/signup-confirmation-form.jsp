<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Confirmation Form(Spring MVC Form Tags)</title>
	</head>
	<body>
		<!-- ${message} -->
		
		Hello! ${student.firstName} ${student.lastName} from ${student.standard} Standard
		<br>
		You have successfully signed up, Congratulations :)
		<br>
		<br>
		Your Favorite Subject is: ${student.favoriteSubject}
		<br>
		Your Hobbies are:
		<ul>
			<c:forEach var="temp" items="${student.hobbies}">
				<li>${temp}</li>
			</c:forEach>
		</ul>
	</body>
</html>