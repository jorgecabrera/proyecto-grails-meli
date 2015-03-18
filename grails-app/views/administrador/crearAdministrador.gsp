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
	<g:form controller="administrador" action="crear">
		<div align="center">
			<input class="textox" placeholder="username" type="text"
				name="nombre" id="username"><br> <br> <input
				class="textox" placeholder="password" type="text" name="password"><br>
			<br>
			<div align="center">
				<g:select id="empresas.id" name="idEmpresa" from="${empresas}"
					optionKey="id" optionValue="nombre" />
				<br> <br>
			</div>
			<g:actionSubmit class="btn" onClick="return validar()" value="Crear" />
			<g:actionSubmit class="btn" controller="administrador"
				action="volver" value="Volver" />
		</div>
	</g:form>
	<br>
	<script type="text/javascript">
		function validar(){
			var nombre = $("#username").val();
			var expreg = new RegExp("^[A-Za-z]*$");
			var nombreValido = expreg.test(nombre.toString());
			if(nombreValido == false){
				alert("El nombre de usuario no es correcto");
				$("#nombreValido").val("")
				return nombreValido;
			}else return true;
		}
	</script>
</body>
</html>