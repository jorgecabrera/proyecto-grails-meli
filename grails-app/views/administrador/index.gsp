<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Listado de administradores</title>
</head>
<body>
	<br>
	<g:if test="${administradores!=[]}">
		<div align="center">
			<table border="1">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${administradores}" var="unAdministrador">
						<tr>
							<td><a
								href="${createLink(action:'mostrarAdministrador',controller:'administrador',id:unAdministrador.id)}">
								${unAdministrador.username}</a></td>
							<td>
								${unAdministrador.username}
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-info">La empresa no tiene administradores</div>
		</div>
	</g:else>
	<br>
	<g:form controller="administrador" action="crearAdministrador">
		<div align="center">
			<g:actionSubmit class="btn" controller="administrador"
			 value="Crear Administrador" />
		</div>
	</g:form>
	<br>
	<script>
		function editarUsuario(id){
			window.location = "/proyecto-grails-meli/administrador/mostrarUsuario/"+id
		}	
	</script>
</body>
</html>