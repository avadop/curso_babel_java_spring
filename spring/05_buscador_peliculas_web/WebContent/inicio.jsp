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
		<form action="verPeliculas" method="POST">
			Tematica: <input type ="text" name="tematica"/><br/><br/>
			<input type="submit" value="Peliculas"/>
		</form>
		<br/><br/>
		<!--  se llama al GET implicitamente, no se puede poner -->
		<a href="verPeliculas">Ver todas Peliculas</a>
	</div>
</body>
</html>