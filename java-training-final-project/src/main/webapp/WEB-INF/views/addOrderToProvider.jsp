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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ION SOLID</title>
    </head>
    <body>
        <h2>NEW ORDER</h2>
        <div class="container">

            <div class="col-md-12" style="background-color: whitesmoke">


                <div>
                    <label for="provider">Select a provider: </label>
                    <select name="provider" id="provider" onchange="getCases(this)">
                        <option value="" id="test">Select</option>
                        <c:forEach items="${providers}" var="provider">
                            <option value="${provider.getId()}">${provider.getName()}</option>
                        </c:forEach>
                    </select>
                </div>

                <br>

                <div id="casesAvailables"></div>

            </div>


            <div class="col-md-12" style="background-color: whitesmoke">
                <hr>
                <h3>ORDER</h3>
                <form id="order"></form>
                <br>
                <button id="sendOrder">Send order</button>
            </div>

        </div>

        <script>

            function getCases(provider) {

            $("#test").attr("disabled", "disabled");
            var providerId = provider.value;
            $.ajax({
            type: "GET",
                    url: "${pageContext.request.contextPath}/provider/getAllCasesByProvider",
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

            $("#casesAvailables").html('');
            var uniqueNames = [];
            for (i in listCases) {
            if (uniqueNames.indexOf(listCases[i].id) === - 1) {
            var design = listCases[i].design;
            $("#casesAvailables").append("<a onClick='addItem(" + listCases[i].id + ", \"" + design + "\")' >" + listCases[i].design + "</a><br/>");
            uniqueNames.push(listCases[i].id);
            }
            }
            }

            function addItem(caseId, design) {
            $("#order").append('<label for="' + design + '" >' + design + '</label>' + ' - <input id="' + design + '" name="' + caseId + '" type="number" value="0" min="0" max="99"> <br>');
            }

            $("#sendOrder").click(function () {
            var order = $('#order').serializeArray();
            
            $.ajax({
            type: "POST",
                    url: "${pageContext.request.contextPath}/provider/addOrder",
                    datatype: 'json',
                    data: {providerId},
                    success: function (listCases) {
                    chargeCases(listCases);
                    },
                    error: function (e) {
                    alert('Error 2: ' + e);
    }
            });
            console.log(order);
            });

        </script>


    </body>        

</html>
