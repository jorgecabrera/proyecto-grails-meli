<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>

</head>
<body>
	<div align="center">
		<h3>
			<g:message code="Crear Empresa" />
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
			<input class="textox" placeholder="Empresa" type="text" id="nombre" value="${objetoCreador.nombre}"><br><br>
			<input class="textox" placeholder="Cuit" type="text" name="cuit" maxLength="11" minLength="11" value="${objetoCreador.cuit}"><br><br>
			<g:actionSubmit class="btn" onClick="return validar()" controller="empresa" action="crear"
				value="Crear" />
			<g:actionSubmit class="btn" controller="empresa" action="volver"
				value="Volver" />
		</div>
	</form>
	<br>
	<script type="text/javascript">
		function validar() {
			var nombreEmpresa = $("#nombre").val();
			var expreg = new RegExp("^[A-Za-z]*$");
			var nombreValido = expreg.test(nombreEmpresa.toString());
			if (nombreValido == false) {
				alert("El nombre de empresa no es correcto");
				$("#nombre").val("")
				return false;
			} else
				return true;
		}
	</script>
</body>
</html>