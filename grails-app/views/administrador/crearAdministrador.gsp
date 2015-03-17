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
			<g:message code="Crear administrador" />
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
		<div align="center">
			<input class="textox" placeholder="username" type="text"
				name="nombre"><br> <br> <input class="textox"
				placeholder="password" type="text" name="password"><br>
			<br>
			<g:actionSubmit class="btn" controller="administrador" action="crear"
				value="Crear" />
			<g:actionSubmit class="btn" controller="administrador"
				action="volver" value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>