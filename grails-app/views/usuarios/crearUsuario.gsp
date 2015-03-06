<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>

</head>
<body>
	<script>
		function mostrarBuscador() {
			$("#selectorRegalo").fadeOut(100, callback1);
		}
		function callback1() {
			$("#buscador").fadeIn(900);
		}
	</script>
	<script>
		function escribirUrl(url) {
			$("#URLregalo").val(url);
			$("#busqueda").val("")
			$("#respuesta_api").empty()
			$("#buscador").fadeOut(250, callback2);

		}
		function callback2() {
			$("#selectorRegalo").fadeIn(800);
		}
	</script>
	<script type="text/javascript">
		function buscar() {
			if ($("#busqueda").val() != "") {
				$("#tablaBuscador").fadeIn(1000);
				$("#respuesta_api").empty()
				function mostrarResultado(data) {
					$.each(data.results, agregarResultado)
				}
				function agregarResultado(index, item) {
					var str = $("#stringFilaTabla").html()
					str = str.replace("permalink$", item.permalink)
					str = str.replace("thumbnail$", item.thumbnail)
					str = str.replace("titulo$", item.title)
					str = str.replace("precio$", item.price)
					$("#respuesta_api").append(str);
				}
				function mostrarError() {
					$("#respuesta_api").html("<tr>Se produjo un errors</tr>");
				}
				var promise = $.get(
						"https://api.mercadolibre.com/sites/MLA/search", {
							q : $("#busqueda").val(),
							offset : 2
						});
				promise.done(mostrarResultado);
				promise.fail(mostrarError);
			}

		}
	</script>
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
			<br> <label for="regaloActual"> <g:message
					default="Regalo" /></label>

			<div class="visible" id="selectorRegalo">
				<input class="textox" placeholder="Regalo" type="text"
					id="URLregalo" name="regalo" value="${objetoCreador.urlRegalo}">
				<button type="button" class="btn" onclick="mostrarBuscador()">Asignar</button>
				<br> <br>
			</div>

			<div class="noVisible" id="buscador">
				<input class="textox" placeholder="Buscar" type="text"
					name="busqueda" id="busqueda">
				<button type="button" class="btn" onclick="buscar()">Buscar</button>
				<br> <br>
				<div class="noVisible" id="tablaBuscador">
					<table>
						<thead>

						</thead>
						<tbody id="respuesta_api">



						</tbody>



					</table>
				</div>

			</div>





			<g:actionSubmit class="btn" controller="usuarios" action="crear"
				value="Crear" />
			<g:actionSubmit class="btn" controller="usuarios" action="volver"
				value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>