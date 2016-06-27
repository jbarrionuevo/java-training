<%-- 
    Document   : newSale
    Created on : Jun 24, 2016, 3:55:56 PM
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
        <title>ION Cases</title>

    </head>
    <body>

        <div class="container">



            <h1>New sale</h1>

            <div class="col-md-12" style="background-color: whitesmoke">
                <f:form action="${pageContext.request.contextPath}/sales/addSalePost">

                    <div>
                        <label for="customer">Customer: </label> <br/>
                        <select name="customer" id="customer">
                            <c:forEach items="${customers}" var="customer">
                                <option value="${customer.getId()}">${customer.getName()}</option>
                            </c:forEach>
                        </select>
                        <a href="#">New Customer</a> <!-- MODAL -->
                    </div>


                    <div>
                        <label for="seller">Seller: </label><br/>
                        <select name="seller" id="seller">
                            <c:forEach items="${sellers}" var="seller">
                                <option value="${seller.getId()}">${seller.getFullname()}</option>
                            </c:forEach>
                        </select>
                        <a href="#">New Seller</a>
                    </div>

                    <div>
                        <h2>Order:</h2>

                        <a onClick="addNewItem()">Add new item</a>

                        <table class="table">
                            <thead class="thead-inverse">
                                <tr>
                                    <th>Code</th>
                                    <th>Case name</th>
                                    <th>Quantity</th>
                                </tr>
                            </thead>
                            <tbody id="orderr">
                                <c:forEach items="${orderSale}" var="order">
                                    <tr>

                                        <td>${order.key}</td>
                                        <td>case model</td>
                                        <td><input type="number" value="${order.value}" min="0" max="99" class="qtyinput"></td>

                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>

                    </div>

                    <input type="text" id="orderSale" name="orderSale2" value="array" />

                    <br>
                    <button href="/">Cancel</button> 
                    <input type="submit"  value="Add order"/>

                </f:form>

            </div>


            <div class="modal fade" id="newItemModal" >
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                            <h4 class="modal-title">Inventory</h4>
                        </div>
                        <div class="modal-body">
                            <p>Select case</p>

                            <table class="table table-hover">
                                <thead class="thead-inverse">
                                    <tr>
                                        <th>Code</th>
                                        <th>Case design</th>
                                        <th>Stock</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${inventory}" var="inventory">
                                        <tr onclick="addCaseToSale(${inventory.key.getId()})">

                                            <td>${inventory.key.getId()}</td>
                                            <td>${inventory.key.getDesign()}</td>
                                            <td>${inventory.value}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
                        </div>
                    </div><!-- /.modal-content -->
                </div><!-- /.modal-dialog -->
            </div><!-- /.modal -->


        </div>



        <script>


            var map = {};
            var array = [];
            function addNewItem() {
                $('#newItemModal').modal("show");
            }


            function addCaseToSale(idCase) {

            <c:set target="${orderSale}" property="123" value="432" />

                var item = {
                    "itemId": idCase,
                    "quantity": "1"
                };
                array.push(JSON.stringify(item));
                console.log('array:  ->' + array.length);
                $('#orderSale').val(array);

                $('#newItemModal').modal("hide");

                $('#orderr').add(
                        '<p><b>Welcome ' + idCase + '</b></>'
                        );
            }

            function noname(idCase) {
                $('#orderr').add(
                        '<p><b>Welcome ' + idCase + '</b></>'
                        );
            }

        </script>
    </body>
</html>
