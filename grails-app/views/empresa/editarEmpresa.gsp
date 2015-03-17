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
			<g:message code="Editar Empresa" />
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
	<form>
		<div align="center">
			<input type="hidden" name="id" value="${unaEmpresa.id}">
			<input class="textox" placeholder="Empresa" type="text" name="nombre" value="${unaEmpresa.nombre}"><br><br>
			<input class="textox" placeholder="Cuit" type="text" name="cuit" maxLength="11" minLength="11" value="${unaEmpresa.cuit}"><br><br>

			<button class="btn" onclick="${createLink(controller:'empresa', action: 'editar')}">Editar</button>
			<button class="btn" onclick="${createLink(controller:'empresa', action: 'volver')}">Volver</button>
		</div>
	</form>
	<br>
</body>
</html>