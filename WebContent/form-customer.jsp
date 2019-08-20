<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>customer-form</title>
</head>
<body>
	<form action="CreateCustomer">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="number" name="cid" value="${customer.cid}"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="cfname" value="${customer.cfname}"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="clname" value="${customer.clname}"></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email" value="${customer.email}"></td>
			</tr>
		</table>
		<input type="submit">
	</form>
</body>
</html>