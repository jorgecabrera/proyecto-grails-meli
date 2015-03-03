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
	<g:form>
		<div align="center">
			<g:datePicker name="fechaDeCumpleanios" precision="day"
				value="${usuarioInstance?.fechaDeCumpleanios}" />
		</div>
	</g:form>
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