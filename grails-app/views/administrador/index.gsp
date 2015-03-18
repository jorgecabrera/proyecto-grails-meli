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
						<th>Empresa</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${administradores}" var="unAdministrador">
						<tr>
							<g:if test="${unAdministrador.empresa != null}">
								<td>
									<a href="${createLink(action:'mostrarAdministrador',controller:'administrador',id:unAdministrador.id)}">
									${unAdministrador.username}</a></td>
								<td>
									${unAdministrador.empresa.nombre}
								</td>
							</g:if>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-info">La empresa no tiene
				administradores</div>
		</div>
	</g:else>
	<g:form controller="administrador" action="crearAdministrador">
		<div align="center">
			<g:actionSubmit class="btn" controller="administrador"
				value="Crear Administrador" />
			<a class="btn" href="/proyecto-grails-meli">Volver</a>
		</div>
	</g:form>
	<br>
</body>
</html>