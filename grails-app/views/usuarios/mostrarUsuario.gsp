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
			<g:message code="Informacion del usuario" />
		</h3>
	</div>
	<br>
	<g:if test="${unUsuario!=null}">
		<form>
			<g:hiddenField name="id" value="${unUsuario.id}" />
			<div align="center">
				<label for="nombre2"> <g:message code="Nombre:" /></label> <label
					for="nombre"> <g:message code="${unUsuario.nombre}" /></label><br>
				<label for="apellido2"> <g:message code="Apellido:" /></label> <label
					for="apellido"> <g:message code="${unUsuario.apellido}" /></label><br>

				<label for="dni2"> <g:message code="DNI:" /></label> <label
					for="dni"> <g:message code="${unUsuario.dni}" /></label><br>
				<label for="fechaDeNacimiento"> <g:message
						code="Fecha de Nacimiento:" /></label> <label for="fechaDeNacimiento">
					<g:message code="${unUsuario.fechaDeCumpleanios}" />
				</label> <br>
				<g:if test="${unUsuario.regaloActual.precioRegalo!=0}">
					<a href="${unUsuario.regaloActual.urlRegalo}" target="_blank">Proximo
						regalo</a>
					<br>
					<br>
				</g:if>
				<g:else>
					<div class="row" align="center">
						<div class="alert alert-info">El regalo se encuentra sin
							asignar, edite el usuario y asignele uno!</div>
					</div>
				</g:else>
				<g:if test="${unUsuario.historialDeRegalos!=null}">
					<label><g:message code="Regalos" /></label>
					<br>
					<br>
					<div align="center">
						<table border="1" class="table table-condensed">
							<thead>
								<tr>
									<th>Url</th>
									<th>Fecha</th>
									<th>Imagen</th>
									<th>Precio</th>
								</tr>
							</thead>
							<tbody>
								<g:each in="${unUsuario.historialDeRegalos}" var="unRegalo">
									<g:if test="${unRegalo.regalado}">
										<tr>
											<td><a href="	${unRegalo.urlRegalo}" target="_blank">Regalo</a>
											</td>
											<td>
												${unRegalo.fechaRegalado}
											</td>
											<td><img src='${unRegalo.urlImagen}' height='42'
												width='42'></td>
											<td>
												${unRegalo.precioRegalo}
											</td>
										</tr>
									</g:if>
								</g:each>
							</tbody>
						</table>
					</div>
				</g:if>
				<g:else>
					<div class="row" align="center">
						<div class="alert alert-info">El usuario nunca ha recibido
							regalos</div>
					</div>
				</g:else>


			</div>
			<div align="center">
			<sec:ifAnyGranted roles="ROLE_ADMIN">
		
				<a class="btn"
					href="${createLink(controller:'usuarios', action: 'editarUsuario',params:[id:unUsuario.id])}">Editar</a>
					</sec:ifAnyGranted>
				<a class="btn"
					href="${createLink(controller:'usuarios', action: 'ok')}">Ok</a>
			</div>
		</form>
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-danger">¡OOOPs! Este usuario no
				existe...</div>
		</div>
		<div align="center">
			<g:form controller="usuarios">
				<g:actionSubmit class="btn" controller="usuarios" action="index"
					value="Volver" />
			</g:form>
		</div>
	</g:else>
	<br>
</body>
</html>