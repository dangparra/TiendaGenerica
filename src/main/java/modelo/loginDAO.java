package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import  controller.Conexion_BD_tienda_generica;

public class loginDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion_BD_tienda_generica con= new Conexion_BD_tienda_generica();
	Connection cnn= con.conexionbd();
	 public UsuariosDTO login(UsuariosDTO us){
		  
		    UsuariosDTO u=null;		    
		    try{
		    String sql="select * from usuarios where usuario=? and password=?";
		    // consulta bd
		    ps =cnn.prepareStatement(sql);
		    ps.setString(1, us.getUsuario());
			ps.setString(2, us.getPassword());
			res=ps.executeQuery();
		    
		    if(res.next()){

		       u= new UsuariosDTO(res.getInt(1),res.getString(2),res.getString(3),res.getString(4),res.getString(5));

		     }
		    }catch(SQLException ex){
		     JOptionPane.showMessageDialog(null,"Error al Consultar" +ex);
		    }
		    return u;
		    }
}
