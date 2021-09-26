package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;


import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class Servletgestionusuarios
 */
@WebServlet("/Servletgestionusuarios")
public class Servletgestionusuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletgestionusuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean x;
	     int cedula_usuario;    
		 String email_usuario ;
		 String nombre_usuario;
		 String password    ;
		 String usuario; 
		UsuariosDTO lindto;/** instancia clase LineasDTO*/
		UsuariosDAO lindao;/** instancia clase LineasDAO*/
		UsuariosDTO registro;//* recibo lo que llega de la consulta lindao.consultar(lindto);*/
		
		if (request.getParameter("btnins") !=null) { /** nombre exacto del boton del index */
			cedula_usuario  /** nombre variable linea 35*/= Integer.parseInt(request.getParameter("cedula_usuario")) ;/** donde esta lo que va a atrapar?, es nombre exacto al input del index*/
			email_usuario /**nombre variable linea 34 */	=request.getParameter("email_usuario");	/** donde esta lo que va a atrapar?, es nombre exacto al input del index*/
			nombre_usuario  /**nombre variable linea 34 */	=request.getParameter("nombre_usuario");	
			password  /**nombre variable linea 34 */	    =request.getParameter("password");	
			usuario /**nombre variable linea 34 */	        =request.getParameter("usuario");	
			
			lindto= new UsuariosDTO(cedula_usuario,email_usuario,nombre_usuario ,password,usuario );
		    lindao= new UsuariosDAO();
		    x=lindao.insertarusuario(lindto);
		    if (x==true) /** if (x) es lo mismo x==true son equivalentes */ {
		    	JOptionPane.showMessageDialog(null,"Usuario registrado");
		    	response.sendRedirect("vistausuarios.jsp");
		    }
		    else {
		    	JOptionPane.showMessageDialog(null,"Usuario no registrado");
		    	response.sendRedirect("vistausuarios.jsp");
		    }
		}
		
		/* CONSULTAR UN USUARIO*/
	
		if(request.getParameter("btncon")!=null) {
			String nom,email,pass,user;
			int ced;
			cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario"));
			JOptionPane.showMessageDialog(null, cedula_usuario);
			lindto=new UsuariosDTO(cedula_usuario);/* le envio el codigo que es el que necesito*/
			lindao=new UsuariosDAO();
			registro=lindao.consultar(lindto);
			ced=registro.getCedula_usuario(); /* le asigno a la variable cod linea 68  lo que trae registro en codline*/
			email=registro.getEmail_usuario();
			nom=registro.getNombre_usuario();
			pass= registro.getPassword();
			user=registro.getUsuario();
			response.sendRedirect("vistausuarios.jsp?co="+ced+"&&no="+nom+"&&em="+email+"&&pa="+pass+"&&us="+user); /* para enviar datos x URL*/
		}
		
		
		
		
		// ACTUALIZACION TABLA DE usuarios
		
				if(request.getParameter("btnact")!=null) {
					int dat ;		
					email_usuario=request.getParameter("email_usuario");// va a capturar lo que se ingrese en el servelt nomlin
					cedula_usuario= Integer.parseInt(request.getParameter("cedula_usuario"));
					nombre_usuario=request.getParameter("nombre_usuario");
					password=  request.getParameter("password")   ;
					usuario= request.getParameter("usuario"); 
				    lindto= new UsuariosDTO(cedula_usuario, email_usuario, nombre_usuario, password, usuario); // instancio lineas DAO  le envio todos los datos
				    lindao=new UsuariosDAO(); // instanciar objeto que me permite acceder 
				    dat=lindao.actualizarusuario(lindto);
				    if (dat>0) {
				    	JOptionPane.showMessageDialog(null,"Usuario actualizado");
				    	response.sendRedirect("vistausuarios.jsp");
				    }
				    else {
				    	JOptionPane.showMessageDialog(null,"Usuario no actualizado");
				    	response.sendRedirect("vistausuarios.jsp");
				    }
				
				}
				
				 /// ELIMINAR REGISTRO TABLA usuarios
				if (request.getParameter("btneli")!=null){
					int dat;
					cedula_usuario=Integer.parseInt(request.getParameter("cedula_usuario")); // captura info del campo ingresado en cedula_usuario index
					lindto=new UsuariosDTO(cedula_usuario); // llama el constructor UsuariosDTO el que tiene solo un parametro 
			        lindao=new UsuariosDAO(); // llamar el metodo	
			        dat=lindao.eliminarusario(lindto); // nos envia el dato eliminar es el metodo llamado  de LineasDAO linea 73
				    if (dat>0) {
				    	JOptionPane.showMessageDialog(null,"Usuario eliminado");
				    	response.sendRedirect("vistausuarios.jsp");
				    }
				    else {
				    	JOptionPane.showMessageDialog(null,"Usuario no fue  eliminado");
				    	response.sendRedirect("vistausuarios.jsp");
				    }
				
				
				}
				
				
				
				
				
   }
				
}

