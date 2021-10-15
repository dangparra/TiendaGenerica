package controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;
import modelo.clientesDAO;
import modelo.clientesDTO;

/**
 * Servlet implementation class Servletventas
 */
@WebServlet("/Servletventas")
public class Servletventas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	double iva,iva1,iva2;   
	int  cant1,cant2,cant3;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servletventas() {
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
		HttpSession sesion=request.getSession();
		if(request.getParameter("confirmar")!=null) {
		long cedula,ced;
		String nom;			
		clientesDTO listado;
		cedula=Long.parseLong(request.getParameter("cedula"));
		clientesDAO clidao=new clientesDAO();
		clientesDTO clidto=new clientesDTO(cedula);
		listado=clidao.consultar_cliente(clidto);	
	    sesion.setAttribute("cliente",listado);		 
		request.getRequestDispatcher("ventas.jsp").forward(request, response);
		}
							
		if(request.getParameter("conpro")!=null) {
			
			int codpro;
			ProductoDTO listapro;
			codpro=Integer.parseInt(request.getParameter("codigo"));			
			ProductoDTO podto= new  ProductoDTO(codpro);
			ProductoDAO prodao=new ProductoDAO();
			listapro=prodao.consultarproducto(podto);
			iva= listapro.getIvacompra() ;
			sesion.setAttribute("producto",listapro);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		
		if(request.getParameter("conpro1")!=null) {
			int codpro;
			ProductoDTO listapro1;
			codpro=Integer.parseInt(request.getParameter("codigo1"));
			ProductoDTO podto= new ProductoDTO(codpro);
			ProductoDAO prodao=new ProductoDAO();
			listapro1=prodao.consultarproducto(podto);
			iva1= listapro1.getIvacompra() ;
			sesion.setAttribute("producto1",listapro1);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		if(request.getParameter("conpro2")!=null) {
			int codpro;
			ProductoDTO listapro2;
			codpro=Integer.parseInt(request.getParameter("codigo2"));
			ProductoDTO podto=new ProductoDTO(codpro);
			ProductoDAO prodao=new ProductoDAO();
			listapro2=prodao.consultarproducto(podto);
			iva2= listapro2.getIvacompra() ;
			
			sesion.setAttribute("producto2",listapro2);
			request.getRequestDispatcher("ventas.jsp").forward(request, response);
			
			
			
		} 
		double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;
		
	
		
		
		if(request.getParameter("total")!=null) {
		   double total1,total2,total3;
		
		  
			cant1=Integer.parseInt(request.getParameter("can"));
			cant2=Integer.parseInt(request.getParameter("can1"));
			cant3=Integer.parseInt(request.getParameter("can2"));
			
			tot=Double.parseDouble(request.getParameter("precio"));
			tot1=Double.parseDouble(request.getParameter("precio1"));
			tot2=Double.parseDouble(request.getParameter("precio2"));
			
			
			res=cant1*tot;
			res1=cant2*tot1;
			res2=cant3*tot2;
			total1=res*iva/100;
			total2=res1*iva1/100;
			total3=res2*iva2/100;
			totalsiniva=res+res1+res2;
			totaliva=total1+total2+total3;
			totaldesiva=totalsiniva+totaliva;
			
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n");
			//JOptionPane.showMessageDialog(null,"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n");
			//JOptionPane.showMessageDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
		    
			int i=JOptionPane.showConfirmDialog(null,"Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA  "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n" );
		     JOptionPane.showMessageDialog(null, "impriendo la i"+i);
		 
		     //if(request.getParameter("confirmar")!=null) {
		 		
		     
		     if(i==0) {
			    String  cedcli ,cedusu;
			    int cc,cu;
			    double iva,tv,vv;
			    boolean ress;			    
			    cedcli=(request.getParameter("cedula"));
			    //cedcli=Integer.parseInt(request.getParameter("cedula"));
			    cedusu=(request.getParameter("cedula_usuario"));
			   
			    iva=totaliva;
			    tv=totalsiniva;
			    vv=totaldesiva;
			    cc=Integer.parseInt(cedcli);			    
			    JOptionPane.showMessageDialog(null,cc);
			    cu=Integer.parseInt(cedusu);	
			    
			    JOptionPane.showMessageDialog(null,cu);	
			    VentasDTO ven= new VentasDTO(cc, cu, iva, tv,vv);
			    VentasDAO vendao=new VentasDAO();
			    ress=vendao.insertarventa(ven);
			    if(ress) {
			    JOptionPane.showMessageDialog(null, "Venta registrada");
			    int can;
			    int cv;
			    double iv,dtv,dvv;
			    boolean x;
			    VentasDTO venn;
			    DetalleVentaDTO dd;
			    DetalleVentaDAO dedao;
			    int codpro=Integer.parseInt(request.getParameter("codigo"));
			    VentasDAO vend=new VentasDAO();
			    venn=vend.consultarcodventa();
			  
			     can=cant1;
			     if(can>0) {
			   
				    cv=venn.getCodigo_venta();
				    iv=ven.getIvaventa();
				    dtv=ven.getTotal_venta();
				    dvv=ven.getValor_venta();
				    dd=new  DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
				    dedao=new DetalleVentaDAO();
				    x=dedao.Inserta_Cliente(dd);
				    	if(x) {
				    		JOptionPane.showMessageDialog(null, "detalle insertado");
				    	}
			     }
			     
			     
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant2;
			     if(can>0) {
					   
					    cv=venn.getCodigo();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotal_venta();
					    dvv=ven.getValor_venta();
					    dd=new DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    	if(x) {
					    		JOptionPane.showMessageDialog(null, "detalle insertado");
					    	}
					     }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     can=cant3;
			     if(can>0) {
					   
					    cv=venn.getCodigo();
					    iv=ven.getIvaventa();
					    dtv=ven.getTotal_venta();
					    dvv=ven.getValor_venta();
					    dd=new DetalleVentaDTO(can, cv, codpro, total3, iva, iva);
					    dedao=new DetalleVentaDAO();
					    x=dedao.Inserta_Cliente(dd);
					    if(x) {
					    	JOptionPane.showMessageDialog(null, "detalle insertado");
					    	response.sendRedirect("ventas.jsp");
					    }
				 }
			     else {
			    	 JOptionPane.showMessageDialog(null, "No inserto cantidad");
			     }
			     
			     
			     
			    }
			    else {
			    	JOptionPane.showMessageDialog(null, "Venta NO registrada");
			    }
			    	
		  }
		}
		
	}

	}


