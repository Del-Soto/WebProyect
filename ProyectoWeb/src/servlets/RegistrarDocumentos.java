package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Documentos;
import bussines.DocumentosBs;

@WebServlet("/registrarDocumentos")

public class RegistrarDocumentos extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public RegistrarDocumentos() {
		
		super();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException
			{
				PrintWriter out = response.getWriter();
				RequestDispatcher rd;
				HttpSession misession = request.getSession();
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				int codigo = 0;
				
				
				String foto = (String) request.getParameter("documentosFotografía");
				String carta = (String) request.getParameter("documentosCartaCompromiso");
				String comprobante = (String) request.getParameter("direccionComprobanteDomicilio");
				String identificacionA = (String) request.getParameter("direccionIdentificacionA");
				String identificacionT = (String) request.getParameter("direccionIdentificacionT");
				
				
				
				if(foto == null || carta == null || comprobante ==null || identificacionA == null || identificacionT== null)
				{
					/*if(respuesta == "cancelar")
					{
						rd = request.getRequestDispatcher("MenuTutor.jsp");
						codigo = -1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
					}*/
					
						rd = request.getRequestDispatcher("error.jsp");
						codigo = -1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
						System.err.println("----> Resultado:"+codigo);
			
					
				}
				else
				{
					Documentos documentos1 = new Documentos();
					DocumentosBs documentosbs = new DocumentosBs();
					
					documentos1.setCartaCompromiso(carta);
					documentos1.setComprobanteDomicilio(comprobante);
					documentos1.setFotografia(foto);
					documentos1.setIdentificacion(identificacionA);
					documentos1.setIdentificacionTutor(identificacionA);
					
					String resp = documentosbs.resgitrarDocumentos(documentos1);
					
					if(resp =="registro correctamente")
					{
						rd = request.getRequestDispatcher("exito.jsp");
						codigo = -1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
					}
					else
					{
						rd = request.getRequestDispatcher("error.jsp");
						codigo = -1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
					}
					
				}
			}

}
