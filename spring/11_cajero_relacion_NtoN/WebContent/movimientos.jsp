<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Cuenta, model.Movimiento, java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<style>
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
p{
	font-size: 22px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Movimientos</h1>
		<br/><br/>
		<p>Saldo de la cuenta: <%=(double)request.getAttribute("getSaldo")%></p>
		<table border=1>
			<tr><th>IDMovimiento</th><th>Tipo operacion</th><th>Fecha</th><th>Cantidad</th></tr>
			<%List<Movimiento> movimientos=(List<Movimiento>)request.getAttribute("getMovimientos");
			for(Movimiento m: movimientos){%>
			<tr>
				<td><%=m.getCuenta().getNumeroCuenta()%></td>
				<td><%=m.getOperacion() %></td>
				<td><%=m.getFecha() %></td>
				<td><%=m.getCantidad() %></td>
			</tr> 
			<%} %>
		</table>
		<br/><br/>
		<a href="toMenu">Volver</a><br/><br/>
	</div>
</body>
</html>