<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<script type="text/javascript"src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>
<body>
<%
String ced;
String dir, email, tel, nom;
ced= request.getParameter("cc");
dir=request.getParameter("dir");
email=request.getParameter("em");
nom=request.getParameter("nom");
tel=request.getParameter("tel");

%>

<label> Clientes</label>
	<form action="Servletclientes.java" method="POST">
		<!-- placeholder pone en el input un nombre en la parte grafica -->
		<input type="text" name="cc_cliente" value="<%=ced %>"placeholder="cc cliente">
	    <input type="text" name="dir_cliente" value="<%=dir %>"placeholder="Dirección cliente"> 
	    <input type="text"name="email_cliente" value="<%=email %>"placeholder= "email cliente"> 
		<input type="text"name="nombre_cliente" value="<%=nom %>"placeholder="Nombre cliente">
        <input type="text" name="telefono_cliente" value="<%=tel %>"placeholder="Telefono cliente">  		
		<input type="submit" name="btncliente" value="insertar" >
		<input type="submit" name="cons" value="consultar">
		<input type="submit" name="btnact" value="actualizar">
		 <input type="submit" name="btnelim" value="eliminar">
			
	</form>

</body>
</html>