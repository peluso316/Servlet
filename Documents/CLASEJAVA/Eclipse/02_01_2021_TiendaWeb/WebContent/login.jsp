<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Login</title>
<link rel="Stylesheet" href="estilos/estilos.css" />
</head>
<body>
	<div>
		<h1>Login</h1>
		<form action="sverifica" method="post">
			Usuario : <input type="email" name="usuario" /> <br /> Contraseña :
			<input type="password" name="password"> <br /> <input
				type="submit" value="Confirmar Credenciales" />
		</form>
	</div>
</body>
</html>