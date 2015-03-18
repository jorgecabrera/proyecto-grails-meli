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
	<g:if test="${unRegalo.precioRegalo!=0}">
		<g:form controller="usuarios">
			<g:hiddenField name="id" value="${unRegalo.usuario.id}" />
			<div align="center">
				<a href="${unRegalo.urlRegalo}" target="_blank">Ver el regalo</a><br>
				<img src='${unRegalo.urlImagen}' height='128' width='128'> <label>$
					${unRegalo.precioRegalo}
				</label><br> <br>
				<g:actionSubmit class="btn" controller="usuarios"
					action="confirmarRegalo" value="Regalar" />
				<g:actionSubmit class="btn" controller="usuarios" action="volver"
					value="Volver" />
			</div>
		</g:form>
	</g:if>
	<g:else>
		<div align="center">

			<div class="row" align="center">
				<div class="alert alert-info">El regalo se encuentra sin
					asignar, edite el usuario y asignele uno!</div>
			</div>
			<g:form controller="usuarios">
				<a href="${createLink(controller: 'usuarios', action: 'editarUsuario', id: unRegalo.usuario.id)}" class="btn">Agregar Regalo</a>
				<g:actionSubmit class="btn" controller="usuarios" action="volver"
					value="Volver" />
			</g:form>
		</div>
	</g:else>
	<br>
</body>
</html>