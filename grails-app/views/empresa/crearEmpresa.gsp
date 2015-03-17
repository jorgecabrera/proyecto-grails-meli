<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>

</head>
<body>
	<script type="text/template" id="stringFilaTabla" class="noVisible">
		<tr onclick="escribirUrl('permalink$','thumbnail$','precio$','regaloIdent$')">
			<td><img src='thumbnail$' height='42' width='42'></td>
			<td>titulo$</td>
			<td>precio$</td>
			<td>regaloIdent$</td>
		</tr>
	</script>
	<br>
	<div align="center">
		<h3>
			<g:message code="Crear usuario" />
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
			<input class="textox" placeholder="Empresa" type="text" name="nombre" value="${objetoCreador.nombre}"><br><br>
			<input class="textox" placeholder="Cuit" type="text" name="cuit" maxLength="11" minLength="11" value="${objetoCreador.cuit}"><br><br>

			<g:actionSubmit class="btn" controller="empresa" action="crear"
				value="Crear" />
			<g:actionSubmit class="btn" controller="empresa" action="volver"
				value="Volver" />
		</div>
	</form>
	<br>
</body>
</html>