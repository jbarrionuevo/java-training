<%-- 
    Document   : newSale
    Created on : Jun 24, 2016, 3:55:56 PM
    Author     : federico.calarco
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>New sale</h1>

        <div>
            <f:form action="${pageContext.request.contextPath}/sales/addSale" >

                <label for="name">Customer: </label><br/>
                <input type="text" name="name" id="name" value="" class="form-control" required autofocus/><br/><br/>

                <label for="name">Seller: </label><br/>
                <input type="text" name="name" id="name" value="" class="form-control" required autofocus/><br/><br/>

                <label for="name">Order </label><br/>
                <input type="text" name="name" id="name" value="" class="form-control" required autofocus/><br/><br/>

                <br>
                <button href="/">Cancel</button> 
                <input type="submit"  value="Save"/>

            </f:form>

        </div>
    </body>
</html>
