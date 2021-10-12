package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion_BD_tienda_generica {
		Connection cnn;
			
			
		public Connection conexionbd() {
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				try {
				    cnn=DriverManager.getConnection("jdbc:mariadb://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com:3306/grupo9_tienda","admin","123456789");
				     JOptionPane.showMessageDialog(null,"Conexion Base de datos Tienda_generica ok");
						
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			
			
			
		}     catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}

		return cnn;


		}}




