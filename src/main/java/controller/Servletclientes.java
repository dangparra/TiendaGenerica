
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.clientesDAO;
import modelo.clientesDTO;

/**
 * Servlet implementation class Servletclientes
 */
@WebServlet("/Servletclientes")
public class Servletclientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletclientes() {
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
		long cc_cli;
		String  dir_cli, email_cli, nombre_cli, telefono_cli;
		clientesDTO cliDTO;
		clientesDAO cliDAO;
		clientesDTO registro;
		boolean x;

		
		//insertar un cliente
		
		if(request.getParameter("btncliente")!=null) {
			cc_cli=Long.parseLong(request.getParameter("cc_cliente"));
			dir_cli=(request.getParameter("dir_cliente"));
			email_cli =(request.getParameter("email_cliente"));
			nombre_cli=(request.getParameter("nombre_cliente"));
			telefono_cli=(request.getParameter("telefono_cliente"));
			cliDTO= new clientesDTO(cc_cli, dir_cli, email_cli, nombre_cli, telefono_cli);
		    cliDAO= new clientesDAO();
			x=cliDAO.insertarcliente(cliDTO);
			if (x==true) {
				JOptionPane.showMessageDialog(null, "se registró el cliente");
			}	
			else {
				JOptionPane.showMessageDialog(null, "No se registró el cliente");
			}
			    response.sendRedirect("clientes.jsp");
			}
			
			//Consultar un cliente
			if(request.getParameter("cons")!=null){
				Long cc;
				String dir,em,nom,tel;
				cc_cli=Long.parseLong(request.getParameter("cc_cliente"));
				cliDTO=new clientesDTO(cc_cli);
				cliDAO=new clientesDAO();
				registro=cliDAO.consultar_cliente(cliDTO);
				cc=registro.getCc_cliente();
				dir=registro.getDir_cliente();
				em=registro.getEmail_cliente();
				nom=registro.getNombre_cliente();
				tel=registro.getTelefono_cliente();
				response.sendRedirect("clientes.jsp?cc="+cc+"&&dir="+dir+"&&em="+em+"&&nom="+nom+"&&tel="+tel);
				
				
			}
			
			//actualización cliente
			
			if(request.getParameter("btnact")!=null) {
				int dat=0;
				cc_cli=Long.parseLong(request.getParameter("cc_cliente"));
				dir_cli=request.getParameter("dir_cliente");
				email_cli=request.getParameter("email_cliente");
				nombre_cli=request.getParameter("nombre_cliente");
				telefono_cli=request.getParameter("telefono_cliente");
			    cliDTO= new clientesDTO(cc_cli, dir_cli,email_cli,nombre_cli,telefono_cli);
			    cliDAO=  new clientesDAO();
			    dat=cliDAO.actualizar(cliDTO);
			    if(dat>0) {
			    	JOptionPane.showMessageDialog(null, "linea actualizada");
			    } else {
			    	
			    		JOptionPane.showMessageDialog(null, "linea no actualizada");
			    	}
			    response.sendRedirect("clientes.jsp");
			}
			
			
			// Eliminar cliente
			
			
			if(request.getParameter("btnelim")!= null) {
				int dat;
				cc_cli = Long.parseLong(request.getParameter("cc_cliente"));
				cliDTO= new clientesDTO(cc_cli);
				cliDAO= new clientesDAO();
				dat=cliDAO.eliminar(cliDTO);
				if (dat>0) {
					JOptionPane.showMessageDialog(null, "cliente eliminado");
				}
				else {
					JOptionPane.showMessageDialog(null, "cliente no eliminado");
				}
				response.sendRedirect("clientes.jsp");
				
			}
			
			}
			
	
	
	       		
		//actualización en linea
		

		
		
		

	}



