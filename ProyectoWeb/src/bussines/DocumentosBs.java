package bussines;

import beans.Documentos;
import dao.DocumentosDao;

public class DocumentosBs {
	

	private static Integer documentoBusq;
	
	public String resgitrarDocumentos(Documentos documentos1)
	{
		
		DocumentosDao dao2 = new DocumentosDao();
		
		int id = dao2.buscarUltimoReg();
		id++;
		String res = dao2.registrarDocumentos(documentos1, id);
		return res;
		
	}
	
	public String buscarDocumentos(Documentos documentos1)
	{
		String res="";
		
		DocumentosDao dao1 = new DocumentosDao();
		Documentos documentos2 = new Documentos();
		
		documentos2= dao1.buscarDocumentos(documentos1);
				
		if((documentos2.getFotografia() != null)&&(documentos2.getCartaCompromiso() != null)&&(documentos2.getComprobanteDomicilio() != null) && (documentos2.getIdentificacion() != null)&&(documentos2.getIdentificacionTutor() != null)) 
		{
			documentoBusq=documentos2.getId();
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
	
	

	public int actualizarDocumentos(Documentos documentos2) {
		
		Documentos documentos3 = new Documentos();
		documentos3.setId(documentoBusq);
		DocumentosDao documentosDao1 = new DocumentosDao();
		int codigo=(Integer)documentosDao1.actualizarDocumentos(documentos2, documentos3);
		return codigo;
	}
	
	public String eliminarDocumentos(Documentos documentos1)
	{
		
		DocumentosDao dao2 = new DocumentosDao();
		
		String res = dao2.eliminarDocumentos(documentos1);
		
		return res;
		
	}
	
	public String consultarDocumentos(Documentos documentos1)
	{
		String res="";
		
		DocumentosDao dao1 = new DocumentosDao();
		Documentos documentos2 = new Documentos(); 
		
		documentos2= dao1.consultarDocumentos(documentos1);
				
		if((documentos2.getFotografia() != null)&&(documentos2.getCartaCompromiso() != null)&&(documentos2.getComprobanteDomicilio() != null) && (documentos2.getIdentificacion() != null)&&(documentos2.getIdentificacionTutor() != null))
		{
			res="Se encontro la siguiente coincidencia, Foto:"+documentos2.getFotografia()+"\n Carta compromiso " + documentos2.getCartaCompromiso() + "\n Comprobante de Domicilio: " + documentos2.getComprobanteDomicilio() + "\n identificacion Alumno: "+documentos2.getIdentificacion()+ "\n identificacion del tutor: "+documentos2.getIdentificacionTutor();
		}
		else
		{
			System.out.println("no existe");
			res="no existe";
		}
		
		return res;
	}

}
