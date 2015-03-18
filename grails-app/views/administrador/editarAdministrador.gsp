<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>

</head>
<body>
	<div align="center">
		<h3>
			<g:message code="Editar Administrador" />
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
		<g:hiddenField name="id" value="${unAdmin.id}" />
		<div align="center">
			<input class="textox" placeholder="username" type="text"
				name="username"><br> <br> <input class="textox"
				placeholder="password" type="text" name="password"><br> <br>
			<g:actionSubmit class="btn" controller="administrador"
				action="modificarAdministrador" value="Modificar" />
		</div>
	</g:form>
	<br>
</body>
</html>