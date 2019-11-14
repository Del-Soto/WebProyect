package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Documentos;


public class DocumentosDao extends BDConnection{
	
	
	public String registrarDocumentos(Documentos documentos1, int id)
	{
		String resp="";
		try {
			
			getConnection();
			if (connection != null) {
				
				String query = "INSERT INTO documento VALUES ((?),(?),(?),(?),(?),(?))";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, documentos1.getFotografia());
				preparedStatement.setString(2, documentos1.getCartaCompromiso());
				preparedStatement.setString(3, documentos1.getComprobanteDomicilio());
				preparedStatement.setString(4, documentos1.getIdentificacion());
				preparedStatement.setString(5, documentos1.getIdentificacionTutor());
				preparedStatement.setInt(6, id);
				int resultado = preparedStatement.executeUpdate();
				if (resultado >= 1) {
					System.out.println("Se insertaron " + resultado + " columnas");
					resp="registro correctamente";
				} else {
					System.err.println("No se logro insertr ningun registro");
					resultado=-1;
					resp="registro incorrectamente";
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return resp;
	}
	
	public int buscarUltimoReg()
	{
		int id=0;
		try
		{
			getConnection();
			if(connection != null)
			{
				String query ="SELECT * FROM documento WHERE id = (SELECT MAX(id) from documento)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				ResultSet rs = preparedStatement.executeQuery();
				if (rs.getRow() >= 0) 
				{
					if (rs.next()) 
					{
						id=rs.getInt("id");
						
					}
				} 
				
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return id;
	}
	
	

	public Documentos buscarDocumentos(Documentos documentos1) {
		
		Documentos documentos2 = new Documentos();
		
		try {
			
			getConnection();
			if (connection != null) {
				
				String query ="SELECT * FROM documento WHERE id = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, documentos1.getId());
				ResultSet rs = preparedStatement.executeQuery();
				
				if (rs.getRow() >= 0) {
					if (rs.next()) {
						documentos2.setFotografia(rs.getNString("fotografia"));
						documentos2.setCartaCompromiso(rs.getString(2));
						documentos2.setComprobanteDomicilio(rs.getString(3));
						documentos2.setIdentificacion(rs.getString(4));
						documentos2.setIdentificacionTutor(rs.getString(5));
						
					}
				} else {
					documentos2.setCodigo(-1);// Error
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return documentos2;
		
		
	}
	
	
	public int actualizarDocumentos(Documentos documentos2, Documentos documentos3) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "UPDATE documento SET fotografia = (?), cartaCompromiso =(?), comprobantedeDomicilio = (?), identificacion =(?), identificacionTutor =(?) WHERE id = (?)";
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, documentos2.getFotografia());
				preparedStatement.setString(2, documentos2.getCartaCompromiso());
				preparedStatement.setString(3, documentos2.getComprobanteDomicilio());
				preparedStatement.setString(4, documentos2.getIdentificacion());
				preparedStatement.setString(5, documentos2.getIdentificacionTutor());
				
				Integer row = preparedStatement.executeUpdate();
				
				if (row > 0) {
					documentos2.setCodigo(1);
					System.err.println("Se actualizo la informacion correctamente");
				} else {
					documentos2.setCodigo(-1);
					System.err.println("No se puedo realizar la actualizacion");
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultado;
	}
	
	public String eliminarDocumentos(Documentos documentos2)
	{
		String resp="";
		try
		{
			getConnection();
			if(connection != null)
			{
				String query ="DELETE FROM documento WHERE id = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, documentos2.getId());
				int resultado = preparedStatement.executeUpdate();
				if (resultado >= 1)
				{
					System.out.println("Se elimino correctamente el registro ");
					resp="se elimino correctamente";
				} else 
				{
					System.err.println("No se logro eliminar el registro");
					resultado=-1;
					resp="no se elimino incorrectamente";
				}
				
			}
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return resp;
	}
	

	public Documentos consultarDocumentos(Documentos documentos1) {
		
		Documentos documentos2 = new Documentos();
		
		try {
			
			getConnection();
			if (connection != null) {
				
				String query ="SELECT * FROM documento WHERE id = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, documentos1.getId());
				ResultSet rs = preparedStatement.executeQuery();
				
				//System.out.println("Numero de coincidencias: " + rs.getRow());
				if (rs.getRow() >= 0) {
					if (rs.next()) {
						documentos2.setFotografia(rs.getNString("fotografia"));
						documentos2.setCartaCompromiso(rs.getString(2));
						documentos2.setComprobanteDomicilio(rs.getString(3));
						documentos2.setIdentificacion(rs.getString(4));
						documentos2.setIdentificacionTutor(rs.getString(5));
					}
				} else {
					documentos2.setCodigo(-1);// Error
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return documentos2;
		
		
	}

}
