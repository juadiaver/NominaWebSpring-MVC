<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/WEB-INF/views/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<div class="container mt-4 col-lg-4">
		<div class="card border-info">
			<div class="card-header bg-info">
				<h4>Buscar Empleado</h4>
			</div>
			<div class="card-body">
				<form method="POST">
					<label>DNI</label>
					<input type="text" name="dni" class="form-control" >
					<br>
					<input type="submit" value="Ver" class="btn btn-success">
					<a href="index.jsp" class="btn btn-success">Regresar</a>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>