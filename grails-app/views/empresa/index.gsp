<html>
	<head>

	</head>
	<body>
		<g:select 
		    noSelection="${['null':'Select One...']}"
		    from='${empresas}'
		    name="${empresa.cuil}"
			value="${empresa.nombre}"/>
	</body>
</html>