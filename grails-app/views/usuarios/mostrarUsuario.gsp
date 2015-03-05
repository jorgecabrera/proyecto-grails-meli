<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
</head>
<body>
	<br>
	<div align="center">
		<h3>
			<g:message code="Informacion del usuario" />
		</h3>
	</div>
	<br>
	<g:form controller="usuarios">
		<g:hiddenField name="id" value="${unUsuario.id}" />
		<div align="center">
			<label for="nombre2"> <g:message code="Nombre:" /></label> <label
				for="nombre"> <g:message code="${unUsuario.nombre}" /></label><br>
			<label for="apellido2"> <g:message code="Apellido:" /></label> <label
				for="apellido"> <g:message code="${unUsuario.apellido}" /></label><br>

			<label for="dni2"> <g:message code="DNI:" /></label> <label
				for="dni"> <g:message code="${unUsuario.dni}" /></label><br> <label
				for="fechaDeNacimiento"> <g:message
					code="Fecha de Nacimiento:" /></label> <label for="fechaDeNacimiento">
				<g:message code="${unUsuario.fechaDeCumpleanios}" />
			</label> <br> <label for="regaloActual2"> <g:message
					code="Regalo actual:" /></label> <label for="regaloActual2"> <g:message
					code="${unUsuario.regaloActual}" />
			</label><br> <br> <label><g:message
					code="Regalos anteriores" /><br> <br></label>
			<div align="center">
				<table border="1" class="table table-condensed">
					<thead>
						<tr>
							<th>Url</th>
							<th>Fecha</th>
						</tr>
					</thead>
					<tbody>
						<g:each in="${unUsuario.historialDeRegalos}" var="unRegalo">
							<tr>
								<td>
									${unRegalo.url}
								</td>
								<td>
									${unRegalo.fechaRegalado}
								</td>
							</tr>
						</g:each>
					</tbody>
				</table>
			</div>
			<br> <br>
		</div>
		<div align="center">
			<g:actionSubmit class="btn" controller="usuarios"
				action="editarUsuario" value="Editar" />
			<g:actionSubmit class="btn" controller="usuarios" action="ok"
				value=" OK " />
		</div>
	</g:form>
	<br>
</body>
</html>