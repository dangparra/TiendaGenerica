<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  rel="stylesheet" href="estilos/StylessProductos.css">
<title>Insert title here</title>
</head>


<body>
<% 
HttpSession objsesion=request.getSession();
String uss=(String)objsesion.getAttribute("llevausuario");
%>
<!--  <div> <%=uss%> </div> -->

<h2>MODULO PRODUCTOS</h2>

<form action="Servletproductos" method="post" enctype="multipart/form-data">

<p>Nombre del Archivo:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="file" name= "archivo" value="" placeholder="Nombre del archivo" ></p>
<br>
<br>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="cargar" value="Cargar"></p>

</form>
<!--Prueba-->

</body>

</html>