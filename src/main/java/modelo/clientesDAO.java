package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import controller.Conexion_BD_tienda_generica;

public class clientesDAO {
	Conexion_BD_tienda_generica con= new Conexion_BD_tienda_generica();
	Connection cnn= con.conexionbd();
	PreparedStatement ps;
	ResultSet rs ;
	clientesDTO cliDTO=null;
	
	
	// INSERTAR CLIENTE
	
	public boolean insertarcliente(clientesDTO cliente) {
		int u;
		boolean dat = false;
		
		
		try {
			ps=cnn.prepareStatement("INSERT INTO clientes (cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) values(?,?,?,?,?)");
		    ps.setLong(1, cliente.getCc_cliente());
		    ps.setString(2, cliente.getDir_cliente());
		    ps.setString(3, cliente.getEmail_cliente());
		    ps.setString(4, cliente.getNombre_cliente());
		    ps.setString(5, cliente.getTelefono_cliente());
		    //devuelve un entero 1 con información o 0 sin información
		    u=ps.executeUpdate();
		    if (u>0){
		    	dat=true;
		    }
		    
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dat;
		
	}
	
	//CONSULTAR CLIENTE
	
	public clientesDTO consultar_cliente(clientesDTO cc) {
		//clientesDTO cliDTO = null;
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
		    ps.setLong(1, cc.getCc_cliente());
			rs = ps.executeQuery();
			if(rs.next()) {
				cliDTO= new clientesDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
			}
			else {
				return null;
			}
			
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cliDTO;
		
	}
	
	// ACTUALIZAR CLIENTE
	
	public int actualizar(clientesDTO cliente) {
		int x=0;
		
		try {
			ps =cnn.prepareStatement("UPDATE clientes SET direccion_cliente=?, email_cliente=?, nombre_cliente=?, telefono_cliente=?   WHERE cedula_cliente=?");	
			
			
			ps.setString(1, cliente.getDir_cliente());
			ps.setString(2, cliente.getEmail_cliente());
			ps.setString(3, cliente.getNombre_cliente());
			ps.setString(4, cliente.getTelefono_cliente());
			ps.setLong(5, cliente.getCc_cliente());
			x=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				return x;
		
	}
	
	//ELIMINAR CLIENTE
	
	public int eliminar(clientesDTO cc) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM clientes where cedula_cliente=?");
            ps.setLong(1, cc.getCc_cliente());		
            x=ps.executeUpdate();
            
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return x;
		
	}
	
	
/* public ArrayList<clientesDTO> consulta_general(){
		   ArrayList<clientesDTO> lista=new ArrayList<>();
		try {
			ps=cnn.prepareStatement("SELECT* FROM clientes");
			rs=ps.executeQuery();
			while(rs.next()) {
				cliDTO= new clientesDTO(rs.getLong(1), rs.getString(4));
			    lista.add(cliDTO);
			}
			return lista;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return lista;
		   
	}
*/

}
