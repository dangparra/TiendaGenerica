package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Conexion_BD_tienda_generica;

public class ProductoDAO {
	
	Conexion_BD_tienda_generica con=new Conexion_BD_tienda_generica();
	Connection cnn=con.conexionbd();
PreparedStatement ps =null;
	
	ResultSet rs=null;
	ProductoDTO prodto;	
	
	public ProductoDTO consultarproducto(ProductoDTO pro) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			ps.setInt(1, pro.getCodigo_producto());
			rs=ps.executeQuery();
			if(rs.next()){
			 prodto=new ProductoDTO(rs.getInt(1), rs.getDouble(2), rs.getInt(3), rs.getString(4), rs.getDouble(5),rs.getDouble(6));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
				  
		return prodto;  
	  }

		
	
	
	public boolean cargarproducto(String Url) {
		JOptionPane.showMessageDialog(null," en dao"+ Url);
		boolean resul=false;
		try {
			
		ps =cnn.prepareStatement("load data infile '" +Url+ "' into table productos fields terminated by ';' lines terminated by '\r\n';");
			
		resul=ps.executeUpdate()>0;
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al momento de cargar el producto"+e);
			//e.printStackTrace();
			
		}
		return resul;
	}
	
	
	


}
