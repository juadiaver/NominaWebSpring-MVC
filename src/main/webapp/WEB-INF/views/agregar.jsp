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
				<h4>Crear Empleado</h4>
			</div>
			<div class="card-body">
				<form method="POST">
					<label>Dni</label>
					<input type="text" name="dni" class="form-control" value="">
					<label>Nombre</label>
					<input type="text" name="nombre" class="form-control" value="">
					<label>Categoria</label>
					<input type="number" name="categoria" class="form-control" value="">
					<label>Antiguedad</label>
					<input type="number" name="anyos" class="form-control" value="">
					<label>Sexo</label>
					<input type="text" name="sexo" class="form-control" value="">
					<br>
					<input type="submit" value="Crear" class="btn btn-success">
					<a href="mostrar.htm" class="btn btn-success">Regresar</a>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>