<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
</head>
<body>
	<script>
function editarUsuario(id){
	alert(id)
	//window.location = ""
}
</script>
	<br>
	<div align="center">
		<h3>
			<g:message code="Ver usuarios" />
		</h3>
	</div>
	<br>
	<div align="center">
		<table border="1">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Fecha de Nacimiento</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${usuarios}" var="unUsuario">

					<tr onclick="editarUsuario(${unUsuario.id})">
						<td>
							${unUsuario.nombre}
						</td>
						<td>
							${unUsuario.apellido}
						</td>
						<td>
							${unUsuario.dni}
						</td>
						<td>
							${unUsuario.fechaDeCumpleanios}
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>
	<br>
	<g:form controller="usuarios">
		<div align="center">
			<g:actionSubmit class="btn" controller="usuarios" action="volver"
				value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>