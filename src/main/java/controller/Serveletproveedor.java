package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedorDAO;
import modelo.ProveedorDTO;
import modelo.clientesDAO;
import modelo.clientesDTO;

 
/**
 * Servlet implementation class Servletclientes
 */
@WebServlet("/Servletclientes")

public class Serveletproveedor extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Serveletproveedor() {
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
		long nit_pro;
		String  dir_pro, nombre_pro, telefono_pro, ciudad_pro;
		ProveedorDTO ProDTO;
		ProveedorDAO ProDAO;
		ProveedorDTO registro;
		boolean x;

		
		//insertar un proveedor
		
		if(request.getParameter("btnproveedor")!=null) {
			nit_pro=Long.parseLong(request.getParameter("nit_proveedor"));
			dir_pro=(request.getParameter("dir_proveedor"));
			nombre_pro=(request.getParameter("nombre_proveedor"));
			telefono_pro=(request.getParameter("telefono_proveedor"));
			ciudad_pro = (request.getParameter("ciudad_proveedor"));
			ProDTO= new ProveedorDTO(nit_pro, nombre_pro, dir_pro,telefono_pro, ciudad_pro);
		    ProDAO= new ProveedorDAO();
			x=ProDAO.insertarproveedor(ProDTO);
			if (x==true) {
				JOptionPane.showMessageDialog(null, "se registró el proveedor");
			}	
			else {
				JOptionPane.showMessageDialog(null, "No se registró el proveedor");
			}
			    response.sendRedirect("proveedor.jsp");
			}
			
			//Consultar proveedor
			if(request.getParameter("consproveedor")!=null){
				Long nit;
				String dir,nom,tel, ciu;
				nit_pro=Long.parseLong(request.getParameter("nit_proveedor"));
				ProDTO=new ProveedorDTO(nit_pro);
				ProDAO=new ProveedorDAO();
				registro=ProDAO.consultar_proveedor(ProDTO);
				nit=registro.getNit_proveedor();
				dir=registro.getDir_proveedor();
				nom=registro.getNombre_proveedor();
				tel=registro.getTel_proveedor();
				ciu = registro.getCiudad_proveedor();
				response.sendRedirect("proveedor.jsp?nit="+nit+"&&dir="+dir+"&&nom="+nom+"&&tel="+tel+"&&ciu="+ciu);
				
				
			}
			
			//actualización proveedor
			
			if(request.getParameter("btnactproveedor")!=null) {
				int dat=0;
				nit_pro=Long.parseLong(request.getParameter("nit_proveedor"));
				dir_pro=request.getParameter("dir_proveedor");
				nombre_pro=request.getParameter("nombre_proveedor");
				telefono_pro=request.getParameter("telefono_proveedor");
				ciudad_pro=request.getParameter("ciudad_proveedor");
			    ProDTO= new ProveedorDTO(nit_pro, dir_pro,nombre_pro,telefono_pro,ciudad_pro);
			    ProDAO=  new ProveedorDAO();
			    dat=ProDAO.actualizar(ProDTO);
			    if(dat>0) {
			    	JOptionPane.showMessageDialog(null, "linea actualizada");
			    } else {
			    	
			    		JOptionPane.showMessageDialog(null, "linea no actualizada");
			    	}
			    response.sendRedirect("proveedor.jsp");
			}
			
			
			// Eliminar proveedor
			
			
			if(request.getParameter("btnelimproveedor")!= null) {
				int dat;
				nit_pro = Long.parseLong(request.getParameter("nit_proveedor"));
				ProDTO= new ProveedorDTO(nit_pro);
				ProDAO= new ProveedorDAO();
				dat=ProDAO.eliminar(ProDTO);
				if (dat>0) {
					JOptionPane.showMessageDialog(null, "Proveedor eliminado");
				}
				else {
					JOptionPane.showMessageDialog(null, "Proveedor no eliminado");
				}
				response.sendRedirect("proveedor.jsp");
				
			}
			
			}
				
	

}
