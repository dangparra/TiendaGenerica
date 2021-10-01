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
String ced;
String dir, email, tel, nom;
ced= request.getParameter("cc");
dir=request.getParameter("dir");
email=request.getParameter("em");
nom=request.getParameter("nom");
tel=request.getParameter("tel");

%>
<h3>
MODULO CLIENTES
</h3>
<br>
<body>
	<form action="Servletclientes" method="POST" class="formulario_clientes">
		<!-- placeholder pone en el input un nombre en la parte grafica -->
		<p>Cedula Cliente: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="cc_cliente" value="<%=ced %>"placeholder="cc_cliente"> </p>
	    <br>
	    <p>Dirección: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="dir_cliente" value="<%=dir %>"placeholder=" Dirección cliente"> </p> 
	   <br>
	   <br>
	    <p>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"name="email_cliente" value="<%=email %>" placeholder= "email cliente"> </p>
		<br>
	    <br>
		<p>Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text"name="nombre_cliente" value="<%=nom %>" placeholder="Nombre cliente"> </p>
        <br>
	    <br>
        <p>Teléfono:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="telefono_cliente" value="<%=tel %>" placeholder="Telefono cliente"> </p>  		
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
	
		<input type="submit" name="btncliente" value="insertar" > &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="cons" value="consultar"> &nbsp;&nbsp;&nbsp;&nbsp;
		<input type="submit" name="btnact" value="actualizar"> &nbsp;&nbsp;&nbsp;&nbsp;
		 <input type="submit" name="btnelim" value="eliminar"> &nbsp;&nbsp;&nbsp;&nbsp;
			
	</form>

</body>
</html>