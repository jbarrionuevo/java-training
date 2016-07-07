<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Logistic - ION Cases</title>
</head>
<body>
	<div class="container">
		<h1>Inventory - Add provider</h1>
		<div class="col-md-12" style="background-color: #ccffcc;">
			<f:form class="form-horizontal" role="form"
				action="${pageContext.request.contextPath}/logistic/addProvider"
				modelAttribute="Provider">
				<div class="form-group">
					<label class="col-lg-2 control-label">Provider</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="name" name="name"
							placeholder="Name">
					</div>
				</div>

				<button href="/">Cancel</button>
				<input type="submit" value="Create" />

				<c:if test="${SUCCESS_MESSAGE != null}">
					<div id="status_message">${SUCCESS_MESSAGE}</div>
				</c:if>
			</f:form>
			
			<a href="<c:url value="/logistic/"/>">Return</a>
		</div>
	</div>
</body>
</html>