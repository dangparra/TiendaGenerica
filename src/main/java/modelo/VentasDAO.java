package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Conexion_BD_tienda_generica;
public class VentasDAO {
	PreparedStatement ps=null;
	ResultSet rs=null;
	Conexion_BD_tienda_generica con= new Conexion_BD_tienda_generica();
	Connection cnn=con.conexionbd();
	VentasDTO ven;
	
	public boolean insertarventa(VentasDTO ven){
		

		boolean resultado=false;
		
		try{	
				
	    ps =cnn.prepareStatement("Insert Into ventas(cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta) value(?,?,?,?,?)");
		ps.setLong(1, ven.getCedula_cliente());
		ps.setLong(2, ven.getCedula_usuario());
		ps.setDouble(3, ven.getIvaventa());
		ps.setDouble(4, ven.getTotal_venta());
		ps.setDouble(5, ven.getValor_venta());
		resultado=ps.executeUpdate()>0;
		
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	
public  VentasDTO consultarcodventa() {
	try {
		ps=cnn.prepareStatement("SELECT MAX(codigo_venta),cedula_cliente,cedula_usuario,ivaventa,total_venta,valor_venta AS id FROM ventas");
		rs=ps.executeQuery();
		if(rs.next()) {
			
			JOptionPane.showMessageDialog(null, "En el if");
			 ven=new VentasDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
		
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return ven;
}

}

