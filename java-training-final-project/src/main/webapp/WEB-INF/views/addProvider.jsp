<%-- 
    Document   : addProvider
    Created on : Jul 7, 2016, 10:01:52 AM
    Author     : federico.calarco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>
        <title>ION SOLID</title>
    </head>
    <body>
        <div class="container">
            <h2>ADD NEW PROVIDER</h2>
            <div class="col-md-6" style="background-color: whitesmoke">
                <f:form action="${pageContext.request.contextPath}/logistic/addProvider" modelAttribute="Provider">

                    <div>
                        <label for="name">NAME: </label><br/>
                        <input type="text" name="name" id="name" placeholder="Provider name" required autofocus/>
                    </div>
                    <br>
                    <div>
                        <label for="inventoryUrl">URL SERVICE INVENTORY: </label><br/>
                        <input type="text" name="inventoryUrl" id="inventoryUrl" placeholder="http://localhost:8084/ProviderRest/provider/getInventory?id=1" required/>
                        <button onclick="checkInventoryService(inventoryUrl.value)" id="btnCheckService">Check Service</button> 
                    </div>

                    <br>
                    <button href="/">Cancel</button> 
                    <input type="submit"  value="Add provider"/>

                </f:form>
            </div>
            <div class="col-md-6" style="background-color: white" id="inventory">Inventory: </div>
        </div>
        <script>

            function checkInventoryService(urlService) {

                console.log(urlService);

                $.ajax({
                    type: "GET",
                    url: urlService,
                    datatype: 'text',
                    data: {},
                    success: function (inventory) {
                        $('#btnCheckService').prop('disabled', true);
                        $('#inventory').html("<span style='color:green'>Inventory charged satisfactory</span>");
                        showInventory(inventory);
                    },
                    error: function (e) {
                        alert('Error 2: ' + e);
                    }
                });
            }

            function showInventory(inventory) {
                console.log(inventory);
                console.log(inventory.inventory);

                for (var i = 0; i < inventory.inventory.length; i++) {

                    var html = "";
                    html = "<div>" + inventory.inventory[i].design + "</div>";
                    $('#inventory').append(html);
                }



            }

        </script>

    </body>
</html>
