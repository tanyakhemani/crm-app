<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all-customers</title>
</head>
<body>
	<input type="button" onclick="window.location.href='form-customer.jsp'" value="Add Customer"><br><br>
	
	<c:out value="${isCustomerCreated}"></c:out><br>
	
	<table>
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Actions</th>
		</tr>
		<c:forEach items="${customers}" var="customer">
			
			<c:url var="deleteLink" value="/DeleteCustomer">
				<c:param name="cid" value="${customer.cid}"></c:param>
			</c:url>
			
			<c:url var="updateLink" value="/FormPopulateCustomer">
				<c:param name="cid" value="${customer.cid}"></c:param>
			</c:url>
			
			<tr>
				<td>${customer.cid}</td>
				<td>${customer.cfname}</td>
				<td>${customer.clname}</td>
				<td>${customer.email}</td>
				<td><input type="button" value="Update" onclick="window.location.href='${updateLink}'"></td>
				<td><input type="button" value="Delete" onclick="window.location.href='${deleteLink}'"></td>
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>

