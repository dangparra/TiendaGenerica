/* ESTE ES EL ServletLogin del proyecto  TIENDA GENERICA */

package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		String u,c;
			u=request.getParameter("usu");
			c=request.getParameter("pass");
			if(u.equals("ad")&& c.equals("123")) {
				JOptionPane.showMessageDialog(null,"DATOS CORRECTOS");
				response.sendRedirect("vistagestionusuarios.jsp?dat="+u);
				
			}
		    
			else {
				JOptionPane.showMessageDialog(null,"datos incorrectos");
				response.sendRedirect("index.jsp");
				
			}

	}
	}
