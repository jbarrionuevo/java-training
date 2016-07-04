<%-- 
    Document   : addOrderToProvider
    Created on : Jun 30, 2016, 10:26:39 AM
    Author     : federico.calarco
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ION SOLID</title>
    </head>
    <body>
        <h1>Add order to provider</h1>
        <div>
            <div>
                <label for="provider">Provider: </label> <br/>
                <select name="provider" id="provider" onchange="getCases(this)">
                    <option value="">Select</option>
                    <c:forEach items="${providers}" var="provider">
                        <option value="${provider.getId()}">${provider.getName()}</option>
                    </c:forEach>
                </select>
            </div>


            <div id="casesAvailables">


            </div>

        </div>

        <script>

            function getCases(provider) {

                var providerId = provider.value;
                alert(providerId);
                $.ajax({
                    type: "GET",
                    url: "${pageContext.request.contextPath}/provider/getAllCases",
                    datatype: 'json',
                    data: {providerId},
                    success: function (listCases) {
                        chargeCases(listCases);
                    },
                    error: function (e) {
                        alert('Error 2: ' + e);
                    }
                });
            }

            function chargeCases(listCases) {
                alert('Test');
                console.log(listCases);
                for (i in listCases) {
                    var id = listCases[i].id;
                    if (listCases[i].id === id) {

                    }
                    $("#casesAvailables").append(" <a>" + listCases[i].design + "</a>");
                }

            }




        </script>


    </body>        

</html>
