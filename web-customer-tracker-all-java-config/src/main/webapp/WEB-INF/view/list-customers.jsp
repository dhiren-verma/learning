<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page import="com.customerTracker.util.SortUtil" %>

<!DOCTYPE html>
<html>
	<head>
		<title>List Customers</title>
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
				<!-- Calls the mentioned Controller Mapping on Click:  -->
				<input type="button" value="Add Customer"
						onclick="window.location.href='addCustomerForm'; return false;"
						class="add-button" />
				
				<!-- Add a Search Box: -->
				<form:form action="searchCustomer" method="GET">
					Search Customer: <input type="text" name="searchName" />
					<input type="submit" value="Search" class="add-button" />
				</form:form>
				
				<table>
					<!-- Construct a Sort Link for First Name: -->
					<c:url var="sortByFirstName" value="/customer/listCustomers">
						<c:param name="sort" value="<%= Integer.toString(SortUtil.FIRST_NAME) %>" />
					</c:url>
					
					<!-- Construct a Sort LLink for Last Name: -->
					<c:url var="sortByLastName" value="/customer/listCustomers">
						<c:param name="sort" value="<%= Integer.toString(SortUtil.LAST_NAME) %>" />
					</c:url>
					
					<!-- Construct a Sort Link for E-Mail: -->
					<c:url var="sortByEmail" value="/customer/listCustomers">
						<c:param name="sort" value="<%= Integer.toString(SortUtil.EMAIL) %>" />
					</c:url>
					
					<tr>
						<th><a href="${sortByFirstName}">First Name:</a></th>
						<th><a href="${sortByLastName}">Last Name:</a></th>
						<th><a href="${sortByEmail}">E-Mail:</a></th>
						<th>Action:</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers}">
						<!-- Construct an Update Link with Customer Id: -->
						<c:url var="updateLink" value="/customer/updateCustomerForm">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<!-- Construct a Delete Link with Customer Id: -->
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a href="${updateLink}">Update</a>
								 | 
							 	<a href="${deleteLink}"
							 			onclick="if (!(confirm('Are you sure you want to delete this Customer?'))) return false">
							 		Delete
							 	</a>
							 </td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>