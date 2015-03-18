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
			<g:message code="Empresas" />
		</h3>
	</div>
	<br>
	<g:if test="${empresas!=[]}">
		<div align="center">
			<table border="1">
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Cuit</th>
							<th>Empleados</th>
					</tr>
				</thead>
				<tbody>
					<g:each in="${empresas}" var="empresa">

						<tr>
							<td>
								<a href="${createLink(action:'editarEmpresa', controller:'empresa', id:empresa.id)}">
									${empresa.nombre}
								</a>
							</td>
							<td>
								${empresa.cuit}
							</td>
							<td>
								<g:if test="${empresa.empleados!=[]}">
									<table border="1">
										<thead>
											<tr>
												<th>Nombre</th>
												<th>Apellido</th>
												<th>DNI</th>
												<th>Fecha de Nacimiento</th>
											</tr>
										</thead>
										<tbody>
											<g:each in="${empresa.empleados}" var="unUsuario">
												<tr onclick="editarUsuario(${unUsuario.id})">
													<td>
														${unUsuario.nombre}
													</td>
													<td>
														${unUsuario.apellido}
													</td>
													<td>
														${unUsuario.dni}
													</td>
													<td>
														${unUsuario.fechaDeCumpleanios}
													</td>
												</tr>
											</g:each>
										</tbody>
									</table>
								</g:if>
							</td>
						</tr>
					</g:each>
				</tbody>
			</table>
		</div>
	</g:if>
	<g:else>
		<div class="row" align="center">
			<div class="alert alert-info">No existen empresas aún...</div>
		</div>
	</g:else>
	<g:form controller="empresa">
		<div align="center">
			<g:actionSubmit class="btn" controller="empresa" action="volver"
				value="Volver" />
		</div>
	</g:form>
	<br>
</body>
</html>