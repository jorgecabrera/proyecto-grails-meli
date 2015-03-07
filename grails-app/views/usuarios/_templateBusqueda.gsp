

<label for="regaloActual"> <g:message default="Regalo" /></label>

<div class="visible" id="selectorRegalo">
	<input class="textox" placeholder="Regalo" type="text" id="URLregalo"
		name="regalo" value="${objetoCreador.urlRegalo}">
	<g:hiddenField id="precioRegalo" name="precioRegalo" value="${objetoCreador.precioRegalo}" />
	<g:hiddenField id="URLImagen" name="urlImagen" value="${objetoCreador.urlImagen}" />
	<button type="button" class="btn" onclick="mostrarBuscador()">Asignar</button>
	<br> <br>
</div>

<div class="noVisible" id="buscador">
	<input class="textox" placeholder="Buscar" type="text" name="busqueda"
		id="busqueda">
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