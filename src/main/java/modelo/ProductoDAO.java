package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import com.mysql.cj.xdevapi.PreparableStatement;

import controller.Conexion_BD_tienda_generica;

public class ProductoDAO {
	
	Conexion_BD_tienda_generica con=new Conexion_BD_tienda_generica();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
		
	
	
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
