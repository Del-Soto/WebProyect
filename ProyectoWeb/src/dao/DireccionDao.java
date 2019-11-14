package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import beans.Direccion;



public class DireccionDao extends BDConnection{
	
	
	public String registrarTutor(Direccion direccion1, int id)
	{
		String resp="";
		try {
			
			getConnection();
			if (connection != null) {
				
				String query = "INSERT INTO direccion VALUES ((?),(?),(?),(?),(?),(?),(?),(?))";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				
				preparedStatement.setString(1, direccion1.getCalle());
				preparedStatement.setString(2, direccion1.getColonia());
				preparedStatement.setString(3, direccion1.getMunicipio());
				preparedStatement.setString(4, direccion1.getCodigoPostal());
				preparedStatement.setString(5, direccion1.getNumeroExterior());
				preparedStatement.setString(6, direccion1.getNumeroExterior());
				preparedStatement.setString(7, direccion1.getEstado());
				preparedStatement.setInt(8, id);
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
				String query ="SELECT * FROM direccion WHERE id = (SELECT MAX(id) from direccion)";
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
	
	

	public Direccion buscarDireccion(Direccion direccion1) {
		
		Direccion direccion2 = new Direccion();
		
		try {
			
			getConnection();
			if (connection != null) {
				
				String query ="SELECT * FROM direccion WHERE id = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, direccion1.getId());
				ResultSet rs = preparedStatement.executeQuery();
				
				if (rs.getRow() >= 0) {
					if (rs.next()) {
						direccion2.setCalle(rs.getNString("calle"));
						direccion2.setColonia(rs.getString(2));
						direccion2.setMunicipio(rs.getString(3));
						direccion2.setCodigoPostal(rs.getString(4));
						direccion2.setNumeroExterior(rs.getString(5));
						direccion2.setNumeroInterior(rs.getString(6));
						direccion2.setEstado(rs.getString(7));
						direccion2.setId(rs.getInt(8));
						
					}
				} else {
					direccion2.setCodigo(-1);// Error
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return direccion2;
		
		
	}
	
	
	public int actualizarDireccion(Direccion direccion2, Direccion direccion3) {
		int resultado=0;
		try {
			getConnection();
			if (connection != null) {
				String query = "UPDATE direccion SET calle = (?), colonia =(?), municipio = (?), codigoPostal =(?), numeroExterior =(?), numeroInterior =(?), estado =(?) WHERE id = (?)";
				Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setString(1, direccion2.getCalle());
				preparedStatement.setString(2, direccion2.getColonia());
				preparedStatement.setString(3, direccion2.getMunicipio());
				preparedStatement.setString(4, direccion2.getCodigoPostal());
				preparedStatement.setString(5, direccion2.getNumeroExterior());
				preparedStatement.setString(6, direccion2.getNumeroInterior());
				preparedStatement.setString(7, direccion2.getEstado());
				preparedStatement.setInt(8, direccion3.getId());
				
				Integer row = preparedStatement.executeUpdate();
				
				if (row > 0) {
					direccion2.setCodigo(1);
					System.err.println("Se actualizo la informacion correctamente");
				} else {
					direccion2.setCodigo(-1);
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
	
	public String eliminarTutor(Direccion direccion2)
	{
		String resp="";
		try
		{
			getConnection();
			if(connection != null)
			{
				String query ="DELETE FROM direccion WHERE id = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, direccion2.getId());
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
	

	public Direccion consultarDireccion(Direccion direccion1) {
		
		Direccion direccion2 = new Direccion();
		
		try {
			
			getConnection();
			if (connection != null) {
				
				String query ="SELECT * FROM direccion WHERE id = (?)";
				PreparedStatement preparedStatement = connection.prepareStatement(query);
				preparedStatement.setInt(1, direccion1.getId());
				ResultSet rs = preparedStatement.executeQuery();
				
				//System.out.println("Numero de coincidencias: " + rs.getRow());
				if (rs.getRow() >= 0) {
					if (rs.next()) {
						direccion2.setCalle(rs.getNString("calle"));
						direccion2.setColonia(rs.getString(2));
						direccion2.setMunicipio(rs.getString(3));
						direccion2.setCodigoPostal(rs.getString(4));
						direccion2.setNumeroExterior(rs.getString(5));
						direccion2.setNumeroInterior(rs.getString(6));
						direccion2.setEstado(rs.getString(7));
						direccion2.setId(rs.getInt(8));
					}
				} else {
					direccion2.setCodigo(-1);// Error
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		cerrrarConexion();
		
		return direccion2;
		
		
	}

}
