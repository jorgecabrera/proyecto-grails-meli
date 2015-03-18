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
			<g:message code="Informacion del administrador" />
		</h3>
	</div>
	<br>
	<g:if test="${unAdmin != null}">
		<g:hiddenField name="id" value="${unAdmin.id}" />
		<div align="center">
			<label for="nombre2"> <g:message code="Nombre:" /></label> <label
				for="nombre"> <g:message code="${unAdmin.username}" /></label><br>
			<label for="apellido2"> <g:message code="Empresa:" /></label> <label
				for="apellido"> <g:message code="${unAdmin.empresa.nombre}" /></label><br>
			<br>
			<div align="center">
				<div align="center">
					<a class="btn"
						href="${createLink(controller:'administrador', action: 'editarAdministrador',params:[id:unAdmin.id])}">Editar</a>
					<a class="btn"
						href="${createLink(controller:'administrador', action: 'eliminarAdministrador')}">Eliminar</a>
					<a class="btn"
						href="${createLink(controller:'administrador', action: 'index')}">Volver</a>
				</div>
			</div>
		</div>
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-danger">¡OOOPs! Este administrador no
				existe...</div>
		</div>
		<div align="center">
			<g:form controller="administrador">
				<g:actionSubmit class="btn" controller="administrador"
					action="index" value="Volver" />
			</g:form>
		</div>
	</g:else>
	<br>
</body>
</html>