<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Pais"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<style>
img{
	border:0.5px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
		<c:set var="pais" value="${requestScope.getPais}"/>
		<!-- Podemos poner tambien todo con requestScope pero meh -->
		<h1>Datos de ${pais.nombre}</h1>
		<br/><br/>
		<p>Habitantes: ${pais.habitantes} </p>
		<br/><br/>
		<p>Bandera: </p>
		<img src = "${pais.bandera}" style="width:600px;height:400px;" border="0.5px">
		<br/><br/>
		<a href="">Volver</a><br/><br/>
	</div>
</body>
</html>