function mostrarBuscador() {
	$("#selectorRegalo").fadeOut(100, callback1);
}
function callback1() {
	$("#pipo").show();
	$("#botonModificar").html("Modificar regalo");
	$("#buscador").fadeIn(900);
	
}

function escribirUrl(url, urli, precio) {
	$("#URLregalo").val(url);
	$("#URLImagen").val(urli);
	$("#precioRegalo").val(precio);
	$("#busqueda").val("")
	$("#respuesta_api").empty()
	$("#buscador").fadeOut(250, callback2);

}
function callback2() {
	$("#selectorRegalo").fadeIn(800);
}

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
			str = str.replace("thumbnail$", item.thumbnail)
			str = str.replace("titulo$", item.title)
			str = str.replace("precio$", item.price)
			str = str.replace("precio$", item.price)
			$("#respuesta_api").append(str);
		}
		function mostrarError() {
			$("#respuesta_api").html("<tr>Se produjo un errors</tr>");
		}
		var promise = $.get("https://api.mercadolibre.com/sites/MLA/search", {
			q : $("#busqueda").val(),
			offset : 2
		});
		promise.done(mostrarResultado);
		promise.fail(mostrarError);
	}

}