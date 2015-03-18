<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Organizador de regalos" /></title>
<calendar:resources lang="es" theme="system" />
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<header>
	<div>
		<div align="center">
			<h1>
				<g:message code="Organizador de regalos" />
			</h1>
		
		
		
		</div>
		<div>
			<span id='loginLink'
				style='position: relative; margin-right: 30px; float: right; font-size: 12pt; margin-top:-1cm; color:white !important'>
				<sec:ifLoggedIn>
	        		Logged in as <sec:username /> (<g:link controller='logout' style="color: inherit">Logout</g:link>)
	      		</sec:ifLoggedIn>
	      		<sec:ifNotLoggedIn>
					<a href="${createLink(controller:'login',action: 'index')}" style="color: inherit">Login</a>
				</sec:ifNotLoggedIn>
			</span>
		</div>
	</div>
	</header>
	<div id="cuerpo" align="center">
		<g:layoutBody />

	</div>
	<footer> </footer>
</body>
</html>
