<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
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
			<g:message code="Seleccionar Empresa" />
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
			<g:select id="empresasid" name="idEmpresa" from="${empresas}" optionKey="nombre" optionValue="nombre" noSelection="['':'Elija su empresa']"/><br><br>

		<div align="center">
				<a id="verCumpleanios" class="btn"
					href="${createLink(controller:'cumpleanios', action: 'verCumpleanios',id:idEmpresa)}">Ver cumpleanios de hoy</a>
				<a class="btn"
					href="${createLink(controller:'empresa', action: 'crearEmpresa')}">Crear nueva empresa</a>
			</div>
		</div>
	</form>
	<br>
	<script>
		var val = "";
		var link="";
		$('#empresasid').change(function() {

	    val = $(this).val();

	    $("#verCumpleanios").attr('href', function(i, h) {
		    if(link==""){
			    link=h;
			};
			if(val=="Elija su empresa"){
				return link;
				}
	            return link+"/"+val;

	    });
	});
	</script>
</body>
</html>