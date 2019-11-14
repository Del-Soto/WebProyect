package dao;

import java.sql.*;

public class BDConnection {
	

	protected Connection connection = null;
	
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/Web?useTimezone=true&serverTimezone=UTC", "root", "1234");
			System.err.println("-->Conexionexitosa");
		}
		catch (SQLException ex) {
	    	 System.err.println("-->SQL errorConexionexitosa");
	    	 ex.printStackTrace();
	     } catch (ClassNotFoundException e) {
	    	 System.err.println("-->E errorConexionexitosa");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public  void cerrrarConexion() {
		try {
		if(connection!=null) {
			connection.close();
		}
		}catch(SQLException sqle) {
			sqle.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
