<!DOCTYPE html>
<html>
	<head>
		<title>Error Page</title>
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		<div id="container">
			<div id="content">
				<h3>Form Data submitted is Invalid!</h3>
				<h3>Please retry...</h3>
				<div style="clear; both;"></div>
				<p>
					<a href="${pageContext.request.contextPath}/customer/listCustomers">Back to Customer List</a>
				</p>
			</div>
		</div>
	</body>
</html>