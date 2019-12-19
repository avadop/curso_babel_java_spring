<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Contacto,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
th{
	padding: 5px;
	font-size: 20px;
}
td{
	padding: 7px;	
	text-align: center;
}
a{
	font-size: 22px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Lista de contactos</h1>
		<table border=1>
			<tr><th>ID</th><th>Nombre</th><th>Email</th><th>Edad</th></tr>
			<%List<Contacto> contactos=(List<Contacto>)request.getAttribute("getAllContactos");
			for(Contacto c: contactos){%>
			<tr>
				<td><%=c.getIdContacto() %></td>
				<td><%=c.getNombre() %></td>
				<td><%=c.getEmail() %></td>
				<td><%=c.getEdad() %></td>
				<td>
				<!-- Solucion profe: GET -->
				<%--<a href="deleteContactoId?id=<%=c.getIdContacto()%>" >Eliminar</a>--%>
				<!-- Solucion Luis POST (RequestMapping) -> Mas info en funcion del controller -->
					<form action="deleteContactoId" >
						<input type="hidden" value=<%=c.getIdContacto() %> name="id"/>
						<input type="submit" value="eliminar"/>
					</form> 
				</td>
			</tr> 
			<%} %>
		</table>
		<br/><br/>
		<a href="toInicio">Volver</a> <br/><br/>
	</div>
</body>
</html>