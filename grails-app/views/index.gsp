<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
</head>
<body>
	<g:form controller="usuarios">
		<div align="center">
			<br>
			<g:actionSubmit class="btn" controller="usuarios"
				action="crearUsuario" value="Crear Usuario" />
		</div>
	</g:form>
	<g:form controller="usuarios">
		<div align="center">
			<br>
			<g:actionSubmit class="btn" controller="usuarios"
				action="modificarUsuario" value="Modificar Usuario" />
		</div>
	</g:form>
	<g:form controller="usuarios">
		<div align="center">
			<br>
			<g:actionSubmit class="btn" controller="usuarios"
				action="verUsuarios" value="Ver Usuario" />
		</div>
	</g:form>
</body>
</html>