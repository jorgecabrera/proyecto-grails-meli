<!DOCTYPE html>
<html>
<head>
<title>Organizador de regalos</title>
<meta name="layout" content="main" />
</head>
<body>
	<br>
	<div align="center">
		<table border="1">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Cumplea&ntilde;os</th>
					<th>DNI</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody id="empleadoList">
				<!-- Agregar aquí empleados -->
			</tbody>
		</table>
	</div>
	<div align="center">
		<div id="nolepongaslaputamadre" class="alert alert-danger"></div>
	</div>

	<form id="formCreate">
		<div class="form-group">
			<label>Nombre</label> <input class="form-control" type="text"
				name="nombre" id="txtnombre" />
		</div>
		<div class="form-group">
			<label>Apellido</label> <input class="form-control" type="text"
				name="apellido" id="txtapellido" />
		</div>
		<div class="form-group">
			<label>Nacimiento</label> <input class="form-control" type="text"
				name="nacimiento" id="txtnacimiento" />
		</div>
		<div class="form-group">
			<label>DNI</label> <input class="form-control" type="text" name="dni"
				id="txtdni" />
		</div>
		<div align="center">
			<input type="hidden" name="id" id="txtidEmpleado" />
			<button type="button" class="btn btn-primary" id="btnCrearModificar">Crear
				empleado</button>
			<button type="button" class="btn btn-primary" id="btnCancelar">Cancelar</button>
		</div>

	</form>
	<br>

	<script type="text/template" id="rowTemplate">
		<tr id="row#id">
			<td>#nombre</td>
			<td>#apellido</td>
			<td>#dni</td>
			<td>#cumpleanos</td>
			<td>
				<a onclick="borrar_empleado(#id)"><span class="glyphicon glyphicon-remove"></span></a>
				<a onclick="recuperar_empleado(#id)"><span class="glyphicon glyphicon-edit"></span></a>
			</td>
		</tr>
	</script>

	<script>
		function agregar_empleado_tabla(index, empleado) {
			var str = $("#rowTemplate").html();

			str = str.replace("#nombre", empleado.nombre);
			str = str.replace("#apellido", empleado.apellido);
			str = str.replace("#dni", empleado.dni);
			str = str.replace("#cumpleanos", empleado.fechaDeCumpleanios);

			// Notar que como queremos reemplazar varias veces el texto #id (se usa en al menos dos lugares)
			// tenemos que hacerlo como un "regular expression", donde la g final significa reemplazar todas
			// las veces. De lo contrario sólo se reemplazará la primera ocurrencia
			str = str.replace(/#id/g, empleado.id);

			$("#empleadoList").append(str);
		}

		function quitar_empleado_tabla(idEmpleado) {
			$("#row" + idEmpleado).remove();
		}

		function cargar_formulario(data) {
			// Colocamos en los input de formulario los datos del empleado
			$("#txtnombre").val(data.nombre);
			$("#txtapellido").val(data.apellido);
			$("#txtnacimiento").val(data.fechaDeCumpleanios);
			$("#txtidEmpleado").val(data.id);
			$("#txtdni").val(data.dni);

			// Cambiamos el texto del boton Crear a Modificar
			$("#btnCrearModificar").html("Modificar empleado")
		}

		function limpiar_formulario() {
			$("#txtnombre").val("");
			$("#txtapellido").val("");
			$("#txtnacimiento").val("");
			$("#txtidEmpleado").val("");
			$("#txtdni").val("");

			$("#btnCrearModificar").html("Crear empleado")
			$("#nolepongaslaputamadre").hide()
		}

		function cargar_tabla_empleados() {
			$.get("/proyecto-grails-meli/api/usuarios").done(function(data) {
				$("#empleadoList").empty();
				$.each(data, agregar_empleado_tabla);
				$("#nolepongaslaputamadre").hide();
			});
		}

		function crear_empleado(json) {
			var promise = $.ajax("/proyecto-grails-meli/api/usuarios", {
				method : "POST",
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify(json)
			});

			promise.done(function(empleado) {
				agregar_empleado_tabla(0, empleado);
				limpiar_formulario();
			});
			promise.fail(function(error) {
				var alfa = error.responseText
				$("#nolepongaslaputamadre").html(alfa)
				$("#nolepongaslaputamadre").show()

			});
		}

		function recuperar_empleado(idEmpleado) {
			var promise = $.ajax("/proyecto-grails-meli/api/usuarios/"
					+ idEmpleado, {
				method : "GET"
			});
			promise.done(cargar_formulario);
		}

		function borrar_empleado(idEmpleado) {
			var promise = $.ajax("/proyecto-grails-meli/api/usuarios/"
					+ idEmpleado, {
				method : "DELETE"
			});
			promise.done(function() {
				// Cuando se confirma que se borro el empleado, lo quitamos de la tabla, pero para eso
				// necesitamos poder identificar la fila, por eso agegamos un id a cada fila
				quitar_empleado_tabla(idEmpleado);
			});
		}

		function modificar_empleado(idEmpleado, json) {
			var promise = $.ajax("/proyecto-grails-meli/api/usuarios/"
					+ idEmpleado, {
				method : "PUT",
				contentType : 'application/json; charset=utf-8',
				data : JSON.stringify(json)
			});

			promise.done(function(empleado) {
				quitar_empleado_tabla(idEmpleado);
				agregar_empleado_tabla(0, empleado);
				limpiar_formulario();
			});

			promise.fail(function(error) {
				var alfa = error.responseText
				$("#nolepongaslaputamadre").html(alfa)
				$("#nolepongaslaputamadre").show()

			});
		}

		$("#btnCancelar").click(limpiar_formulario);

		$("#btnCrearModificar").click(function() {
			var json = {
				nombre : $("#txtnombre").val(),
				apellido : $("#txtapellido").val(),
				fechaDeCumpleanios : $("#txtnacimiento").val(),
				dni : $("#txtdni").val(),
			}

			// Si tenemos un id de empleado, es una modificacion
			// en aso contrario es una creacion
			if ($("#txtidEmpleado").val())
				modificar_empleado($("#txtidEmpleado").val(), json);
			else
				crear_empleado(json)
		});

		cargar_tabla_empleados();
	</script>
</body>
</html>