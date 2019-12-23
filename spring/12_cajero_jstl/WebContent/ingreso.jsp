<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Cuenta"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Ingreso</h1>
		<br/>
		<form action="ingreso" method="POST">
			Cantidad: <input type ="text" name="cantidad"/><br/><br/>
			<input type="submit" value="Ingresar"/>
		</form><br/><br/>
		<a href="toMenu">Volver</a><br/><br/>
	</div>
</body>
</html>