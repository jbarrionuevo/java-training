<%-- 
    Document   : addSale2
    Created on : 27-jun-2016, 21:02:53
    Author     : fedec
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add Sale</h1>

        <f:form action="${pageContext.request.contextPath}/sales/addSalePost" modelAttribute="SaleDetail">

            <div class="form-group">
                <label for="name">Nombre: </label><br/>
                <input type="text" name="name" id="name" class="form-control" placeholder="Taller de guitarra" required autofocus/>
            </div>

        </f:form>

    </body>
</html>
