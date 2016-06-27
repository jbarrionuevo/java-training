<%-- 
    Document   : addCaseToInventory
    Created on : Jun 27, 2016, 9:50:40 AM
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
        <h1>Add</h1>

        <div>
            <f:form action="${pageContext.request.contextPath}/inventory/add">

                <div>
                    <label for="design">Design </label><br/>
                    <input type="text" name="design" id="design" class="form-control" placeholder="" required autofocus/>
                </div>

                <div>
                    <label for="price">Price </label><br/>
                    <input type="number" name="price" id="price" class="form-control" placeholder="" required />
                </div>

            </f:form>

        </div>
    </body>
</html>
