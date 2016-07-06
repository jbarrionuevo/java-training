<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory - ION Cases</title>
    </head>
    <body>
        <div class="container">
            <h1>Inventory</h1>
            <div class="col-md-12" style="background-color: #22FF05;">
                <table class="table">
                    <thead class="thead-inverse">
                        <tr>
                            <th>Code</th>
<!--                             <th>Case name</th> -->
                            <th>Quantity</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${allInventory}" var="caseStock">
                            <tr>
	                            <td>${caseStock.getKase().getCode()}</td>
<%-- 	                            <td>${caseStock.getKase.getName}</td> --%>
                                <td>${caseStock.getActualStock()}</td>
<%--                                 <td> <a href="<c:url value="/inventory/describeCase?caseId=${inventory.getId()}"/>">Show details</a></td> --%>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>