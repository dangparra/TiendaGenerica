package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.UsuariosDTO;
import modelo.loginDAO;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		 {
			HttpSession sesion=request.getSession();
			if(request.getParameter("loginBtn")!=null){
		           
		            String u,c;
		            UsuariosDTO usdto;
		            u=request.getParameter("usu");
		            c=request.getParameter("pass");
		            UsuariosDTO lo= new UsuariosDTO(u,c);
		            loginDAO lodao=new loginDAO();
		            usdto=lodao.login(lo);
		                   
		            //String y="pepe";
		           // sesion.setAttribute("llevadat",y );
		           
		                  if(usdto.getUsuario().equals(u) && usdto.getPassword().equals(c)){
		                     JOptionPane.showMessageDialog(null, "Datos correctos");
		                     String uss=usdto.getNombre_usuario(); 
		                     JOptionPane.showMessageDialog(null, uss);
		                     sesion.setAttribute("cedusuario",lo.getCedula_usuario());
		                     int cedus=usdto.getCedula_usuario();
		                     sesion.setAttribute("llevadato",uss );	                     
		                     sesion.setAttribute("vs",usdto);	
		                     sesion.setAttribute("cedus",usdto);
		                     request.getRequestDispatcher("vistagestionusuarios.jsp").forward(request, response);
		                     
		                 }
		            }
		            else{
		                JOptionPane.showMessageDialog(null, "Datos incorrectos");
		                response.sendRedirect("index_login.jsp");
		            }

		            }


	}

}
