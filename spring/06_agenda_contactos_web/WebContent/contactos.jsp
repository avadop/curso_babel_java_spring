<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Contacto,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
	padding: 5px;
}
td{
padding: 5px;
text-align: center;}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Lista de contactos</h1>
		<table border=1>
			<tr><th>Nombre</th><th>Email</th><th>Edad</th></tr>
			<%List<Contacto> contactos=(List<Contacto>)request.getAttribute("getAllContactos");
			for(Contacto c: contactos){%>
			<tr>
				<td><%=c.getNombre() %></td>
				<td><%=c.getEmail() %></td>
				<td><%=c.getEdad() %></td>
			</tr>
			<%} %>
		</table>
		<br/><br/>
		<!-- Lo siguiente funciona, pero no es correcto, necesitamos en 
		este modelo de patron, que todas las peticiones que salen del cliente
		pasen por el dispatcherServer y que las gestione a través del controler -->
		<%-- <a href="inicio.jsp">Volver</a> --%> <!-- estos comentarios para codigo -->
		<a href="toInicio">Volver</a>
	</div>
</body>
</html>