package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;

/**
 * Servlet implementation class Servletproductos
 */
@WebServlet("/Servletproductos")
@MultipartConfig
public class Servletproductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servletproductos() {
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
		
		
		//if(request.getParameter("cargar")!=null) {
		
		Part archivo= request.getPart("archivo");
		String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
		
		
		
		//MySQL: show variables like "secure_file_priv";
		//String tipo= archivo.getContentType();
		//JOptionPane.showMessageDialog(null, tipo);
		//String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
		
		if(request.getParameter("cargar")!= null) {
			
			
			try { 
				
				InputStream file=archivo.getInputStream();
				//JOptionPane.showMessageDialog(null, Url);
				File copia= new File(Url+"archivoPro1.csv");
				FileOutputStream escribir=new FileOutputStream(copia);
				int num= file.read();
				while (num != -1) {
					
					escribir.write(num);
					num=file.read();		
				}
				file.close();
				escribir.close();
				
				JOptionPane.showMessageDialog(null, "El archivo se cargo correctamente");
				
				
				
				boolean x;
				ProductoDAO prodao= new ProductoDAO();
				x=prodao.cargarproducto(Url+"archivoPro1.csv");
				
				if(x) {
					JOptionPane.showMessageDialog(null, "Datos cargados en la base de datos");
				}
				
				else 
				{
					JOptionPane.showMessageDialog(null, "Los Datos no se cargaron");
				}
				
				}catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error al cargar el archivo" + e);
					
				}
			}
			
		}
		
		//doGet(request, response);
	}
//Prueba

