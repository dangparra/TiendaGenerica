package modelo;
 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Conexion_BD_tienda_generica;

public class ProveedorDAO {
	Conexion_BD_tienda_generica con= new Conexion_BD_tienda_generica();
	Connection cnn= con.conexionbd();
	PreparedStatement ps;
	ResultSet rs ;
	ProveedorDTO ProDTO=null;
	
	
	// INSERTAR PROVEEDOR
	
	public boolean insertarproveedor(ProveedorDTO proveedor) {
		int u;
		boolean dat = false;
		
		
		try {
			ps=cnn.prepareStatement("INSERT INTO proveedores (nitproveedor,nombre_proveedor,direccion_proveedor, telefono_proveedor, ciudad_proveedor ) values(?,?,?,?,?)");
		    ps.setLong(1, proveedor.getNit_proveedor());
		    ps.setString(2, proveedor.getNombre_proveedor());
		    ps.setString(3, proveedor.getDir_proveedor());
		    ps.setString(4, proveedor.getTel_proveedor());
		    ps.setString(5, proveedor.getCiudad_proveedor());
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
	
	//CONSULTAR PROVEEDOR
	
	public ProveedorDTO consultar_proveedor(ProveedorDTO nit) {
		//clientesDTO cliDTO = null;
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
		    ps.setLong(1, nit.getNit_proveedor());
			rs = ps.executeQuery();
			if(rs.next()) {
				ProDTO= new ProveedorDTO(rs.getLong(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
			}
			else {
				return null;
			}
			
		    
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ProDTO;
		
	}
	
	// ACTUALIZAR PROVEEDOR
	
	public int actualizar(ProveedorDTO proveedor) {
		int x=0;
		
		try {
			ps =cnn.prepareStatement("UPDATE proveedores SET ciudad_proveedor=?, direccion_proveedor=?, nombre_proveedor=?, telefono_proveedor=?   WHERE nitproveedor=?");	
			
			
			ps.setString(1, proveedor.getCiudad_proveedor());
			ps.setString(2, proveedor.getDir_proveedor());
			ps.setString(3, proveedor.getNombre_proveedor());
			ps.setString(4, proveedor.getTel_proveedor());
			ps.setLong(5, proveedor.getNit_proveedor());
			x=ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
				return x;
		
	}
	
	//ELIMINAR PROVEEDOR
	
	public int eliminar(ProveedorDTO nit) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores where nitproveedor=?");
            ps.setLong(1, nit.getNit_proveedor());		
            x=ps.executeUpdate();
            
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		
		return x;
		
	}
	

	
	
}
