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
			<g:message code="¡Regalar!" />
		</h3>
	</div>
	<br>
	<g:form controller="usuarios">
		<g:hiddenField name="id" value="${unRegalo.usuario.id}" />
		<div align="center">
			<g:actionSubmit class="btn" controller="usuarios"
				action="confirmarRegalo" value="Regalar" />
			<g:actionSubmit class="btn" controller="usuarios" action="volver"
				value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>