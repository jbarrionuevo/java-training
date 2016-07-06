<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<h1>Inventory - Add Case</h1>
		<div class="col-md-12" style="background-color: #ccffcc;">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label class="col-lg-2 control-label">Name</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="name" size="20" placeholder="Case Name">
					</div>
					
					<label class="col-lg-2 control-label">Code</label>
					<div class="col-lg-10">
						<input type="text" class="form-control" id="code" size="20" placeholder="Case Code">
					</div>
					
					<label class="col-lg-2 control-label">Provider</label>
					<div class="col-lg-10">
						
					</div>
					
					<label class="col-lg-2 control-label">Devices</label>
					<div class="col-lg-10">
						
					</div>
					
					<label class="col-lg-2 control-label">Design</label>
					<div class="col-lg-10">
						
					</div>
					
					<label class="col-lg-2 control-label">Price</label>
					<div class="col-lg-10">
						<input type="number" class="form-control" id="code" size="20" placeholder="Case Price">
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>