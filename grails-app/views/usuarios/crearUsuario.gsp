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
			<g:message code="Crear usuario" />
		</h3>
	</div>
	<br>
	<g:if test="${errorMessage}">
		<div class="row">
			<div class="alert alert-danger">
				${errorMessage}
			</div>
		</div>
	</g:if>
	<g:form>
		<div align="center">
			<input class="textox" placeholder="Nombre" type="text" name="nombre"
				value="${objetoCreador.nombre}"><br> <br> <input
				class="textox" placeholder="Apellido" type="text" name="apellido"
				value="${objetoCreador.apellido}"><br> <br> <input
				class="textox" placeholder="DNI" type="text" name="dni"
				value="${objetoCreador.dni}"><br> <br>
			<label for="fechaDeCumpleanios"> <g:message
					code="usuario.fechaDeCumpleanios.label"
					default="Fecha de cumpleaños" /></label>
			<g:datePicker name="fechaDeCumpleanios" precision="day"
				value="${objetoCreador.fechaDeCumpleanios}" />
			<br> <br>
			<g:actionSubmit class="btn" controller="usuarios" action="crear"
				value="Crear" />
			<g:actionSubmit class="btn" controller="usuarios" action="volver"
				value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>