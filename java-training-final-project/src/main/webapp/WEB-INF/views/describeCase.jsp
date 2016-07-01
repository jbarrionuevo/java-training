<%-- 
    Document   : describeCase
    Created on : Jul 1, 2016, 2:41:46 PM
    Author     : federico.calarco
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <h1>  ${caseCover.getDesign()}</h1>

        <h3>Compatible devices:</h3>
        <c:forEach items="${caseCover.getCompatibleDevices()}" var="device">
            <c:out value="${device.getModel()}"/> - 
        </c:forEach>
        <br>
        <h3>Providers:</h3>
        <c:forEach items="${caseCover.getProviders()}" var="provider">
            <c:out value="${provider.getName()}"/> - 
        </c:forEach>

        <br>

        <h3>Price:</h3>
        ${caseCover.getPrice()}


    </body>
</html>
