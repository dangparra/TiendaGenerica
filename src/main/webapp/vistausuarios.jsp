<%@page import="controller.Conexion_BD_tienda_generica"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- media query -->
 <link  rel="stylesheet" href="estilos/Stylegestionusuarios.css">
<title>Insert title here</title>
</head>
<body>
<header id="headercont" class="estenombrelopongoyo"> 
        <div class="cont_titulologo" id="cont_titulologo">
        
        <div class="logo"> </div>  <!-- marcar donde va el logo -->
        </div>
 </header>  
<h3> Modulo Gestion Usuarios</h3>

<% 
Conexion_BD_tienda_generica con=new Conexion_BD_tienda_generica();
con.conexionbd(); 
String ced="" , nombre="" ,email="",password="",usuario=""; /* declara variables que van a atrapar lo que viaja x URL*/
if(request.getParameter("co")!=null){
ced=request.getParameter("co") ; /* atrapar  la URL DEL SERVLET  LINEA 75 */
nombre=request.getParameter("no") ;
email=request.getParameter("em");
password=request.getParameter("pa");
usuario=request.getParameter("us");
}

%>
 
<form action="Servletgestionusuarios" method ="post">
 <p>Cedula:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="cedula_usuario" value="<%=ced%>" size="20"   placeholder="Cedula Usuario"> </p>
<br>
<br>

 <p>Email:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="email_usuario" size="20" value="<%=email%>"placeholder ="Email Usuario "></p>
<br>
<br>
 <p>Nombre:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="nombre_usuario" value="<%=nombre%>"size="20" placeholder ="Nombre Usuario "></p>
<br>
<br>

 <p>Password:&nbsp;&nbsp;&nbsp;<input type="text" name="password"       value="<%=password%>"  size="20" placeholder ="Password "></p>
<br>
<br>
 <p>Usuario:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="usuario"       value="<%=usuario%>"  size="20"  placeholder ="User "></p>
<br>
<br>
<br>
     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
     &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
<input type="submit" name="btnins"value="Insertar">&nbsp;&nbsp;&nbsp;&nbsp;
 
<input type="submit" name="btncon" value="Consultar">&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="btnact" value="Actualizar">&nbsp;&nbsp;&nbsp;&nbsp;
<input type="submit" name="btneli" value="Eliminar">&nbsp;&nbsp;&nbsp;&nbsp;

</form>
</body>
</html>