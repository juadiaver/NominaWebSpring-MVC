<%@ include file="/WEB-INF/views/include.jsp"%>

<html>
<head>
<title><fmt:message key="title" /></title>
</head>
<body style="background-color: #F2F1F1;">

	<div class="container mt-4">
		<div class="card border-info">
			<div class="card-header bg-info text-white">
				<a class="btn btn-primary" href="agregar.htm">Nuevo Registro</a>
			</div>
			<c:if test="${empty lista}">
    		La busqueda no tiene resultados
			</c:if>
			<c:if test="${not empty lista}">
			<div class="card-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>DNI</th>
							<th>NOMBRE</th>
							<th>CATEGORIA</th>
							<th>ANTIGUEDAD</th>
							<th>SEXO</th>
							<th>ACCIONES</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="empleado" items="${lista}">
							<tr>
								<td>${empleado.dni}</td>
								<td>${empleado.nombre}</td>
								<td>${empleado.categoria}</td>
								<td>${empleado.anyos}</td>
								<td>${empleado.sexo}</td>
								<td>
									<a href="editar.htm?dni=${empleado.dni}"
									class="btn btn-primary">EDITAR</a> 
									<a href="eliminar.htm?dni=${empleado.dni}" class="btn btn-danger">ELIMINAR</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
			</c:if>
		</div>
	</div>

</body>
</html>