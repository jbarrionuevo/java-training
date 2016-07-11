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

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-serialize-object/2.5.0/jquery.serialize-object.min.js"></script>

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
            var id = provider.value;
            $.ajax({
            type: "GET",
                    url: "${pageContext.request.contextPath}/provider/getAllCasesByProvider",
                    datatype: 'text',
                    data: {id},
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




            $.fn.serializeObject = function()
            {
            var o = {};
            var a = this.serializeArray();
            $.each(a, function() {
            if (o[this.name] !== undefined) {
            if (!o[this.name].push) {
            o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
            } else {
            o[this.name] = this.value || '';
            }
            });
            return o;
            };
            
            

            var data = JSON.stringify($('#order').serializeObject());
            
//            var order = $('#order');
//            var data = order.serializeObject();
            console.log(data);
            $.ajax({
            type: "POST",
                    url: "${pageContext.request.contextPath}/provider/addPost",
                    data: {data},
                    success: function (cond) {
                    alert(cond);
                    },
                    error: function (e) {
                    alert('Error 23: ' + e);
                    }
            });
            });

        </script>


    </body>        

</html>
