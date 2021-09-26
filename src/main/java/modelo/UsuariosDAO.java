package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Conexion_BD_tienda_generica;

public class UsuariosDAO {
	Conexion_BD_tienda_generica con= new Conexion_BD_tienda_generica();
	Connection cnn =con.conexionbd();
	PreparedStatement  ps;
	ResultSet rs ; /* clase que guarda los registros  falta incluir temporal */
	UsuariosDTO usuariodto=null ;/* falta por traer*/
	
	public boolean insertarusuario(UsuariosDTO user) {
		int r;
		boolean dat =false;
		try {
			ps=cnn.prepareStatement("INSERT INTO  usuarios Values (?,?,?,?,?)");
			ps.setInt(1,user.getCedula_usuario());
			ps.setString(2,user.getEmail_usuario());
			ps.setString(3, user.getNombre_usuario());
			ps.setString(4, user.getPassword());
			ps.setString(5,user.getUsuario());
			r=ps.executeUpdate();
			if(r>0) {
				dat=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dat;
	}
	public UsuariosDTO consultar (UsuariosDTO ced ) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1,ced.getCedula_usuario());
			rs=ps.executeQuery(); /*guarda todo el registro en rs independiente del tipo de dato de cada columna */
			if(rs.next()) {  /* next metodo d result set mira si hay una fila o registro  envia true */
			usuariodto=new UsuariosDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)); /* lo que trae rs rs.getInt(1,2,3) 1,2,3 son la posicion de columna*/	
				
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	return usuariodto 	; /* retorna la consulta */
	}
	
  
	
	
	
	
	
	
//  ACTUALIZAR  LOS CAMPOS 
	public int actualizarusuario(UsuariosDTO act) {
		int x=0;		
		
			try {
				ps=cnn.prepareStatement("UPDATE usuarios SET email_usuario =?,nombre_usuario=?,password=?,usuario=? WHERE cedula_usuario=?");
				ps.setString(1, act.getEmail_usuario());			    
			    ps.setString(2,act.getNombre_usuario());
			    ps.setString(3,act.getPassword());
			    ps.setString(4, act.getUsuario());
			    ps.setInt(5,act.getCedula_usuario());
				ps.executeUpdate();
				x=ps.executeUpdate();
			   		
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return x;
		   
		}
	public int eliminarusario (UsuariosDTO elim) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM tienda_generica.usuarios WHERE cedula_usuario=?");
			ps.setInt(1,elim.getCedula_usuario());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	
	
	
	
	
}
