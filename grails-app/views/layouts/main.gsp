<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<style>
table {
    border: 1px solid black !important;
    text-align: center !important;
	width: 85% !important;
}
th, td {
    text-align: center !important;
}

.btn {
	background: #34d976;
	background-image: -webkit-linear-gradient(top, #34d976, #2bb839);
	background-image: -moz-linear-gradient(top, #34d976, #2bb839);
	background-image: -ms-linear-gradient(top, #34d976, #2bb839);
	background-image: -o-linear-gradient(top, #34d976, #2bb839);
	background-image: linear-gradient(to bottom, #34d976, #2bb839);
	-webkit-border-radius: 28;
	-moz-border-radius: 28;
	border-radius: 28px;
	font-family: Arial;
	color: #ffffff;
	font-size: 20px;
	padding: 10px 20px 10px 20px;
	text-decoration: none;
}

.btn:hover {
	background: #3cfc93;
	background-image: -webkit-linear-gradient(top, #3cfc93, #34d96e);
	background-image: -moz-linear-gradient(top, #3cfc93, #34d96e);
	background-image: -ms-linear-gradient(top, #3cfc93, #34d96e);
	background-image: -o-linear-gradient(top, #3cfc93, #34d96e);
	background-image: linear-gradient(to bottom, #3cfc93, #34d96e);
	text-decoration: none;
}

.textox {
	width: 177px;
	height: 29px;
	border: solid 2px #31E300;
	padding: 2px;
	border-radius: 5px;
	font-size: 14px;
	box-shadow: 2px 2px 18px 3px rgba(156, 156, 156, 0.89);
	background-color: #FFFFFF;
	outline: none;
	color: #474747;
}

.textox:hover {
	border: 2px solid #FF00D5;
}

.textox:focus {
	border: solid 2px #00D43C;
	box-shadow: inset 0px 1px 2px 0px #9C9C9C;
}

.textox:active {
	border: solid 2px #0043EB;
}

.font-style {
	font-family: Arial, "Helvetica Neue", Helvetica, sans-serif;
	color: #0A5C16;
	font-size: 24;
	padding: 3;
	text-shadow: 2px 1px 2px rgba(161, 161, 161, 0.9);
}

h3 {
	font-family: Arial, Helvetica, sans-serif;
	color: #275710 !important;
	margin: 0px !important
}

header {
	width: 100%;
	height: 50px;
	background: #666;
	font-size: 2em;
	text-align: center;
	clear: both;
	background-color: #9db051;
}

footer {
	width: 100%;
	height: 50px;
	background: #666;
	font-size: 2em;
	text-align: center;
	clear: both;
	background-color: #9db051;
}

#cuerpo {
	background-color: #f7f8fa;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title><g:layoutTitle default="Organizador de regalos" /></title>
<asset:stylesheet src="application.css" />
<asset:javascript src="application.js" />
</head>
<body>
	<header>
		<div align="center">
			<h1>
				<g:message code="Organizador de regalos" />
			</h1>
		</div>
	</header>
	<div id="cuerpo">
		<g:layoutBody />
		
	</div>
	<footer> </footer>
</body>
</html>
