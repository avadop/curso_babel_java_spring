<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Pelicula,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Lista de peliculas</h1>
		<table>
			<tr><th>Titulo</th><th>Duracion</th></tr>
			<!-- Recorremos la lista que obtubimos con el request.
			El request devuelve un objecto, por eso hacemos el casting -->
			<%List<Pelicula> peliculas=(List<Pelicula>)request.getAttribute("peliculas");
			for(Pelicula p: peliculas){%>
			<tr>
				<td><%=p.getTitulo() %></td>
				<td><%=p.getDuracion() %></td>
			</tr>
			<%} %>
		</table>
	</div>
</body>
</html>