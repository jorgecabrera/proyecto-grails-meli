<!DOCTYPE html>
<html>
<head>
<meta name="layout" content="main" />
<title>Organizador de regalos</title>
</head>
<body>
	<script>
		function regalar(id) {
			window.location = "/proyecto-grails-meli/usuarios/regalar/"
					+ id
		}
	</script>
	<br>
	<div align="center">
		<h3>
			<g:message code="¡Bienvenid@! Hoy cumplen..." />
		</h3>
	</div>
	<div>
		<span id='loginLink'
			style='position: relative; margin-right: 30px; float: right'>
			<sec:ifLoggedIn>
         Logged in as <sec:username /> (<g:link controller='logout'>Logout</g:link>)
      </sec:ifLoggedIn> <sec:ifNotLoggedIn>
				<a href="${createLink(controller:'login',action: 'index')}">Login</a>
			</sec:ifNotLoggedIn>
		</span>
	</div>
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
	<div align="center">
		<a class="btn" href="${createLink(action: 'crearAdministrador', controller: 'administrador')}">Crear Administrador</a><br>
		<a class="btn" href="${createLink(action: 'verAdministradores', controller: 'administrador')}">Ver Administradores</a><br>
		<a class="btn" href="${createLink(action: 'crearEmpresa', controller: 'empresa')}">Crear Empresa</a><br>
		<a class="btn" href="${createLink(action: 'verEmpresas', controller: 'empresa')}">Ver Empresas</a><br>
		<a class="btn" href="${createLink(action: 'crearUsuario', controller: 'usuarios')}">Crear Usuario</a><br>
		<a class="btn" href="${createLink(action: 'verUsuarios', controller: 'usuarios')}">Ver Usuarios</a><br>
	</div>
	<br>
</body>
</html>