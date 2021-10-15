<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="css/stylesventas.css">
<!--  <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/consultar.js"></script>-->
</head>
<body>

 
<header id="contenedortitulo"   class="headerclass">
        <div class="logotitulo">
          <h1 id="titulop"  class="titulop">Ventas </h1>
          <div class="logo"></div>
        </div>
        <nav class="navbar">
    
         
              <ul>
                  <li>  <a href="clientes.jsp"> Clientes   </a> </li>
                  <li>  <a href="proveedor.jsp" >Proveedores </a> </li>
                  <li> <a href="productos.jsp" > Productos</a> </li>
                  <li> <a href="ventas.jsp" > Ventas</a> </li>
                
                <li> <a href="" > Reportes</a> </li>
                 
              </ul>
        </nav>
        
      
              
      
    
      </header>
      <section>
          <fieldset>
              <legend>Gestión Ventas</legend>
                <form action="Servletventas" method="post">
                    <input type="text" name="cedula"         value="${cliente.getCc_cliente()}" placeholder="cedula">
                    <input type="text" name="nombre"         value="${cliente.getNombre_cliente()}" placeholder="nombre">
                    <input type="text" name="cedula_usuario" value="${cedus.getCedula_usuario()}">  
                    <input type="submit" name="confirmar"  >
                   
<table>
    <tbody>
        <tr>
            <th>Codigo del producto</th>
            <th>Consultar producto</th>
            <th>Nombre del producto</th>
            <th>Cantidad de producto</th>
            <th>Precio  del producto</th>
        </tr>


        <tr>
            <td><input type="text" name="codigo" value="${producto.getCodigo_producto()}"  ></td>
            <td> <input type="submit" name="conpro" value="Buscar producto" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${producto.getNombre_producto()}"  ></td>
            <td> <input type="text" class="cantidad" id="cantidad" name="can"   ></td>
            <td> <input type="text" class="pre" id="pre" name="precio" value="${producto.getPrecio_venta()}"  ></td>
                
        </tr>
        <tr>
            <td><input type="text"    name="codigo1" value="${producto1.getCodigo_producto()}"  ></td>
            <td> <input type="submit" name="conpro1" value="Buscar producto" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${producto1.getNombre_producto()}"  ></td>
            <td> <input type="text" class="cantidad1"  id="cantidad1" name="can1"  ></td>
            <td> <input type="text" class="pre"  id="pre1" name="precio1" value="${producto1.getPrecio_venta()}"  ></td>

        </tr>
        <tr>
           <td><input type="text" name="codigo2" value="${producto2.getCodigo_producto()}"  ></td>
            <td> <input type="submit" name="conpro2" value="Buscar producto" ></td>
            <td> <input type="text" class="nombre" name="n2" value="${producto2.getNombre_producto()}"  ></td>
            <td> <input type="text" class="cantidad2" id="cantidad2" name="can2" ></td>
            <td> <input type="text" class="pre"  id="pre2" name="precio2" value="${producto2.getPrecio_venta()}"  ></td>

        </tr>
        
        <tr><td class="ult" colspan="5"><input type="submit" name="total" value="Enviar venta"></td></tr>
        
    </tbody>
    
</table>
   


<input type="text" name="cedula_cliente" value="${cliente.getCc_cliente()}">
<input type="text" name="cedula_usuario" value="${cedus.getCedula_usuario()}">                

</form>


</fieldset>

      </section>
</body>
</html>

