<%-- 
    Document   : inventory
    Created on : 26-jun-2016, 20:48:23
    Author     : fedec
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="<c:url value="/inventory/showAll"/>">View inventory</a>
        <a href="<c:url value="/inventory/add"/>">Add case </a>
        <a href="<c:url value="/inventory/viewAllSales"/>">Upload stock</a>
        <a href="<c:url value="/inventory/addOrderToProvider"/>">Add order to provider</a>
        <a href="<c:url value="/inventory/addProvider"/>">Add Provider</a>
    </body>
</html>
