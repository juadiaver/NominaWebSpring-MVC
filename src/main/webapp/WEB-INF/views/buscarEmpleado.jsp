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
				<form action="buscarEmpleado.htm" method="POST">
					<label>DNI</label>
					<br>
					<div class="input-group-append">
					<input type="text" name="dni" class="form-control" >
					<input type="submit" value="Buscar" class="btn btn-success">
					</div>
				</form>
				<form action="buscarEmpleadoNombre.htm" method="POST">
					<label>Nombre</label>
					<br>
					<div class="input-group-append">
					<input type="text" name="nombre" class="form-control" >
					<input type="submit" value="Buscar" class="btn btn-success">
					</div>
				</form>
				<form action="buscarEmpleadoCategoria.htm" method="POST">
					<label>Categoria</label>
					<br>
					<div class="input-group-append">
					<input type="number" name="categoria" class="form-control" >
					<input type="submit" value="Buscar" class="btn btn-success">
					</div>
				</form>
				<form action="buscarEmpleadoAntiguedad.htm" method="POST">
					<label>Antiguedad</label>
					<br>
					<div class="input-group-append">
					<input type="number" name="antiguedad" class="form-control" >
					<input type="submit" value="Buscar" class="btn btn-success">
					</div>
				</form>
				<form action="buscarEmpleadoSexo.htm" method="POST">
					<label>Sexo</label>
					<br>
					<div class="input-group-append">
					<input type="text" name="sexo" class="form-control" >
					<input type="submit" value="Buscar" class="btn btn-success">
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>