<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="/javascripts/checkerEmpresas.js"></script>
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
			<g:message code="Mostrando cumpleanios del dia para la empresa ${empresa }" />
		</h3>
	</div>
	<br>
	
	
		<div id="divError" class="row" align="center">
			<div id="errorMessage" class="alert alert-danger">
				
			</div>
		</div>
	
	<form>
		<div align="center">
			<g:select id="empresasid" name="idEmpresa" from="${empresas}" optionKey="nombre" optionValue="nombre" noSelection="['':'Elija su empresa']"/><br><br>

		<div align="center">
				<a id="verCumpleanios" class="btn" href=""
				>Ver cumpleanios de hoy</a>
				<a class="btn"
					href="${createLink(controller:'empresa', action: 'crearEmpresa')}">Crear nueva empresa</a>
			</div>
		</div>
	</form>
	<br>
	
	<g:if test="${regalosDeHoy!=[]}">
		<div align="center">
			<table border="1">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Apellido</th>
						<th>Imagen</th>
						<th>Link</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${regalosDeHoy}" var="unRegalo">
						<tr>
							<td onclick="regalar(${unRegalo.id})">
								${unRegalo.usuario.nombre}
							</td>
							<td onclick="regalar(${unRegalo.id})">
								${unRegalo.usuario.apellido}
							</td>
							<td onclick="regalar(${unRegalo.id})"><g:if
									test="${unRegalo.precioRegalo!=0}">
									<img src='${unRegalo.urlImagen}' height='42' width='42'>
								</g:if></td>
							<td><g:if test="${unRegalo.precioRegalo!=0}">
									<a href="	${unRegalo.urlRegalo}" target="_blank">Ver regalo</a>
								</g:if></td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-info">Hoy no hay cumpleaños...</div>
		</div>
	</g:else>
	
</body>
</html>