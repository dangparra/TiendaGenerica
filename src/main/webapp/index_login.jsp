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
 <link  rel="stylesheet" href="estilos/Style_login.css">
<title>Insert title here</title>
</head>
<body>

<header id="headercont" class="estenombrelopongoyo"> 
        <div class="cont_titulologo" id="cont_titulologo">
        <h1> Bienvenidos a la tienda Generica </h1>
        <div class="logo"> </div>  <!-- marcar donde va el logo -->
        </div>
 </header> 
<form action="Login" method="post">
 <div class="container">
     <p class="heading"> Login </p>
     <div class="box">
          <p> Usuario: </p>
          <div>
              <input type="text" name="usu" id="" placeholder ="Enter your Name">
          </div>     
     </div>
     <div class ="box">
          <p> Constraseña:  </p>
          <div>
               <input type="password" name ="pass" id ="" placeholder="Enter your Password">
          </div>         
     </div>
     <input type="submit" name="loginBtn" value ="Aceptar">
     <button class ="loginBtn">Login</button>
     <p class="text"> Don't have an account? &#128526  <a href="#"> Sign up </a> </p>
     
 </div>
 </form> 
 </body>       
  </html>  
