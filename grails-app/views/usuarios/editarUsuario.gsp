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
			<g:message code="Editar usuario" />
		</h3>
	</div>
	<br>
	<g:if test="${errorMessage}">
		<div class="row" align="center">
			<div class="alert alert-danger">
				${errorMessage}
			</div>
		</div>
	</g:if>
	<g:form>
			<g:hiddenField name="id" value="${unUsuario.id}" />
		<div align="center">
			<input class="textox" placeholder="Nombre" type="text" name="nombre"
				value="${unUsuario.nombre}"><br> <br> <input
				class="textox" placeholder="Apellido" type="text" name="apellido"
				value="${unUsuario.apellido}"><br> <br> <input
				class="textox" placeholder="DNI" type="text" name="dni"
				value="${unUsuario.dni}"><br> <br> <label
				for="fechaDeCumpleanios"> <g:message
					code="usuario.fechaDeCumpleanios.label"
					default="Fecha de nacimiento" /></label>
			<calendar:datePicker years="1900-2050" dateFormat="%d/%m/%Y" name="fechaDeCumpleanios"
				value="${unUsuario.fechaDeCumpleanios}" />
			<br> <br>
			<g:actionSubmit class="btn" controller="usuarios" action="modificar"
				value="Modificar" />
		</div>
	</g:form>
	<br>
</body>
</html>