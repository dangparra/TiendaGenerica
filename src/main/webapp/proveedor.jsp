<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

 <link  rel="stylesheet" href="estilos/Stylegestionusuarios.css"> 
</head>
<!-- <script type="text/javascript"src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script> -->

<%
String nit;
String dir, tel, nom, ciu;
nit= request.getParameter("nit");
nom=request.getParameter("nom");
dir=request.getParameter("dir");
tel=request.getParameter("tel");
ciu = request.getParameter("ciu");

%>
<h3>
MODULO PROVEEDORES
</h3>
<br>
<body>
	<form action="Servletproveedor" method="POST" class="formulario_proveedor">
		<!-- placeholder pone en el input un nombre en la parte grafica -->
		<p>NIT: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="nit_proveedor" value="<%=nit %>"placeholder="nit_proveedor"> </p>
	    <br>
	    <p>Dirección: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dir_proveedor" value="<%=dir %>"placeholder=" Dirección proveedor"> </p> 
	   <br>
	   <br>
		<p>Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"name="nombre_proveedor" value="<%=nom %>" placeholder="Nombre proveedor"> </p>
        <br>
	    <br>
        <p>Teléfono:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="telefono_proveedor" value="<%=tel %>" placeholder="Telefono proveedor"> </p>  	
        <br>
	    <br>
	    <p>Ciudad:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="ciudad_proveedor" value="<%=ciu %>" placeholder="Ciudad proveedor"> </p>  		
		 <br>
	     <br>
	     <br>
	    &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
      &nbsp; &nbsp;&nbsp;
	
		<input type="submit" name="btnproveedor" value="Crear" > &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="consproveedor" value="Consultar"> &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="btnactproveedor" value="Actualizar"> &nbsp;&nbsp;&nbsp;&nbsp;
		 <input type="submit" name="btnelimproveedor" value="Borrar"> &nbsp;&nbsp;&nbsp;&nbsp;
			
	</form>

</body>
</html>