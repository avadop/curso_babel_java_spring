<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
a{
	font-size: 22px;
}
p{
font-size: 18px;}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Eliminar contacto</h1>
		<form action="deleteContacto" method="POST">
			<p>Introduce el email del contacto que deseas eliminar</p>
			Email: <input type ="text" name="email"/><br/><br/>
			<input type="submit" value="Borrar"/>
		</form>
		<br/><br/>
		<a href="toInicio">Volver</a><br/><br/>
	</div>
</body>
</html>