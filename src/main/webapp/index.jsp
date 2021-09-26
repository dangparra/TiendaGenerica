<!--  ESTE ES EL INDEX DEL PROYECTO TIENDA GENERICA -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="ISO-8859-1">
 <meta charset="UTF-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- media query -->
 <link  rel="stylesheet" href="Styless.css">
<title>Insert title here</title>
</head>
<body>

<header id="headercont" class="estenombrelopongoyo"> 
        <div class="cont_titulologo" id="cont_titulologo">
        <h1> Bienvenidos a la tienda Generica </h1>
        <div class="logo"> </div>  <!-- marcar donde va el logo -->
        </div>
 </header>      
  
<form action="ServletLogin" method="post">
     <p>Usuario: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name ="usu"  > </p>
     <p>Contrasena: <input type="password" name= "pass" > </p>
     <br>
     &nbsp;
      <input type="submit" name="btnLong" value ="Aceptar">
      &nbsp; &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;
      <input type="reset" name="btnLong" value= "Cancelar">
</form>
</body>
</html>