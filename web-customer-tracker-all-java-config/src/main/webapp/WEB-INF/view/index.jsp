<!-- Rather than Redirecting, lets use it as a Landing Page from where we can
use Hyperlink to access Secure Pages: -->
<!-- < response.sendRedirect("customer/listCustomers"); > -->
<!DOCTYPE html>
<html>
	<head>
		<title>Web Customer Tracker Landing Page</title>
	</head>
	<body>
		<h2>luv2code Landing Page</h2>
		<hr>
		
		<p>
			Welcome to the landing page!  This page is open to the public ... no login required :-)
		</p>
		
		<hr>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/listCustomers">Access Secure Site (requires login)</a>
		</p>
		
	</body>
</html>