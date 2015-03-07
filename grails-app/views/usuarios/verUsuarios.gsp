<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
</head>
<body>
	<script>
function editarUsuario(id){
	window.location = "/proyecto-grails-meli/usuarios/mostrarUsuario/"+id
}
</script>
	<br>
	<div align="center">
		<h3>
			<g:message code="Usuarios" />
		</h3>
	</div>
	<br>
	<g:if test="${usuarios!=[]}">
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
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-info">No existen usuarios aún...</div>
		</div>
	</g:else>
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