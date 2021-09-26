package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion_BD_tienda_generica {
		Connection cnn;
			
			
		public Connection conexionbd() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				try {
				     cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda_generica","root","Bicolombia2021");
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




