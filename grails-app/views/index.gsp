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
			<g:message code="Bienvenid@!" />
		</h3>
	</div>
	<br>
	<g:form controller="usuarios">
		<div align="center">
			<g:actionSubmit class="btn" controller="usuarios"
				action="crearUsuario" value="Crear Usuario" />
			<g:actionSubmit class="btn" controller="usuarios"
				action="modificarUsuario" value="Modificar Usuario" />
			<g:actionSubmit class="btn" controller="usuarios"
				action="verUsuarios" value="Ver Usuario" />
		</div>
	</g:form>
	<br>
</body>
</html>