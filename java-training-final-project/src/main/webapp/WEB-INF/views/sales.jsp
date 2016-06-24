<%-- 
    Document   : addSale
    Created on : Jun 24, 2016, 11:40:36 AM
    Author     : federico.calarco
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>IONCases</title>
    </head>
    <body>
        <a href="<c:url value="/sales/addSale"/>">Add sale</a>
        <a href="<c:url value="/sales/trackStatusSale"/>">Track status sale</a>
        <a href="<c:url value="/sales/viewAllSales"/>">View last sales</a>
    </body>
</html>
