<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Logistic - ION Solid</title>
</head>
<body>
	<a href="<c:url value="/logistic/allInventory"/>">View all inventory</a>
    <a href="<c:url value="/logistic/addCase"/>">Add case </a>
<%--     <a href="<c:url value="/logistic/viewAllSales"/>">Upload stock</a> --%>
    <a href="<c:url value="/logistic/addOrderToProvider"/>">Add order to provider</a>
    <a href="<c:url value="/logistic/addProvider"/>">Add Provider</a>
	<a href="<c:url value="/logout" />">Logout</a>
</body>
</html>