<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h1>Nuevo contacto</h1><br/>
		<form action="addContacto" method="POST">
			<div class="formulario">
				Nombre: <input type ="text" name="nombre"/><br/></br>
				Email: <input type ="text" name="email"/><br/><br/>
				Edad: <input type ="text" name="edad"/><br/><br/>
			</div>
			<input type="submit" value="Crear contacto"/>
		</form>
		<br/><br/>
		<a href="toInicio">Volver</a>
	</div>
</body>
</html>