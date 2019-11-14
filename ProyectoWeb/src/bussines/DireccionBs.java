package bussines;

import beans.Direccion;
import dao.DireccionDao;


public class DireccionBs {
	
	private static Integer direccionBusq;
	
	public String resgitartutor(Direccion direccion1)
	{
		
		DireccionDao dao2 = new DireccionDao();
		
		int id = dao2.buscarUltimoReg();
		id++;
		String res = dao2.registrarTutor(direccion1, id);
		return res;
		
	}
	
	public String buscarDireccion(Direccion direccion1)
	{
		String res="";
		
		DireccionDao dao1 = new DireccionDao();
		Direccion direccion2 = new Direccion();
		
		direccion2= dao1.buscarDireccion(direccion1);
				
		if ((direccion2.getCalle() != null)&&(direccion2.getColonia() != null)&&(direccion2.getMunicipio() != null)&& (direccion2.getCodigoPostal() != null) && (direccion2.getNumeroExterior() != null)&& (direccion2.getNumeroInterior() != null) && (direccion2.getEstado() != null) && (direccion2.getId() != 0)) 
		{
			direccionBusq=direccion2.getId();
			//res="Se encontro la siguiente coincidencia, Nombre:"+tutor2.getNombre()+" Primer Apellido: " + tutor2.getPrimerapellido() + " Segundo Apellido: " + tutor2.getSegundoapellido();
			//System.out.println("Prueba: "+res);
			res = "existe";
		}
		else
		{
			System.out.println("no existe");
			res="no existe";
		}
		
		return res;
	}
	
	

	public int actualizarDireccion(Direccion direccion2) {
		
		Direccion direccion3 = new Direccion();
		direccion3.setId(direccionBusq);
		DireccionDao direccionDao1 = new DireccionDao();
		int codigo=(Integer)direccionDao1.actualizarDireccion(direccion2, direccion3);
		return codigo;
	}
	
	public String eliminarDireccion(Direccion direccion1)
	{
		
		DireccionDao dao2 = new DireccionDao();
		
		String res = dao2.eliminarTutor(direccion1);
		
		return res;
		
	}
	
	public String consultarDireccion(Direccion direccion1)
	{
		String res="";
		
		DireccionDao dao1 = new DireccionDao();
		Direccion direccion2 = new Direccion();
		
		direccion2= dao1.consultarDireccion(direccion1);
				
		if((direccion2.getCalle() != null)&&(direccion2.getCodigoPostal() != null)&&(direccion2.getColonia() != null)&&(direccion2.getEstado() != null)&&(direccion2.getMunicipio() != null)&&(direccion2.getNumeroExterior() != null)&&(direccion2.getNumeroInterior() != null))
		{
			res="Se encontro la siguiente coincidencia, Calle:"+direccion2.getCalle()+"\n codigo Postal " + direccion2.getCodigoPostal() + "\n Colonia: " + direccion2.getColonia() + "\n Estado: "+direccion2.getEstado()+ "\n Municipio: "+direccion2.getMunicipio()+ "\n Numero Exterior: "+direccion2.getNumeroExterior()+ "\n Numero Interior: "+direccion2.getNumeroInterior();
		}
		else
		{
			System.out.println("no existe");
			res="no existe";
		}
		
		return res;
	}
	

}
