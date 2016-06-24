<%-- 
    Document   : sale
    Created on : Jun 24, 2016, 4:52:42 PM
    Author     : federico.calarco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sale ${sale.getId()}</h1>
        <h1>Sale ${sale.getReceipt()}</h1>
        <h1>Customer: ${sale.getCustomer()}</h1>
        <h1>Seller: ${sale.getSeller().getFullname()}</h1>
        <h1>Status: ${sale.getStatus()}</h1>
    </body>
</html>
