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

@WebServlet("/modificarDocumentos")

public class ModificarDocumentos extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public ModificarDocumentos()
	{
		super();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	
			throws ServletException, IOException
			{
				PrintWriter out = response.getWriter();
				RequestDispatcher rd;
				HttpSession misession = request.getSession();
				
				int codigo = 0;
				
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				
				String documentosId = (String) request.getParameter("documentos.id");
				int numEntero = Integer.parseInt(documentosId);
		
				
				if(documentosId == null || documentosId.isEmpty())
				{
					rd = request.getRequestDispatcher("error.jsp");
					codigo = -1;
					misession.setAttribute("codigo", codigo);
					rd.forward(request, response);
					System.err.println("----> Resultado:"+codigo);
					
					
					
				}
				else
				{
					Documentos documentos1 = new  Documentos();
					documentos1.setId(numEntero);
					DocumentosBs documentosbs1 = new DocumentosBs();
					
					System.out.println("id consultado: "+numEntero);
					
					
					String resultado = documentosbs1.buscarDocumentos(documentos1);
					
					
					if (resultado == "existe") 
					{
						rd = request.getRequestDispatcher("ModificarDireccion2.jsp");
						codigo = 1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
					}
					
				}
			}

}
