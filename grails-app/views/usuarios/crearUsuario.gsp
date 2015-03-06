<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>

</head>
<body>
	<script type="text/template" id="stringFilaTabla" class="noVisible">
		<tr onclick="escribirUrl('permalink$')">
			<td><img src='thumbnail$' height='42' width='42'></td>
			<td>titulo$</td>
			<td>precio$</td>
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
	<g:form>
		<div align="center">
			<input class="textox" placeholder="Nombre" type="text" name="nombre"
				value="${objetoCreador.nombre}"><br> <br> <input
				class="textox" placeholder="Apellido" type="text" name="apellido"
				value="${objetoCreador.apellido}"><br> <br> <input
				class="textox" placeholder="DNI" type="text" name="dni"
				value="${objetoCreador.dni}"><br> <br> <label
				for="fechaDeCumpleanios"> <g:message
					code="usuario.fechaDeCumpleanios.label"
					default="Fecha de nacimiento" /></label>
			<calendar:datePicker years="1900-2050" dateFormat="%d/%m/%Y"
				name="fechaDeCumpleanios"
				value="${objetoCreador.fechaDeCumpleanios}" />
			<br> 

			<g:render template="templateBusqueda" model="['objetoCreador':objetoCreador]"/>





			<g:actionSubmit class="btn" controller="usuarios" action="crear"
				value="Crear" />
			<g:actionSubmit class="btn" controller="usuarios" action="volver"
				value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>