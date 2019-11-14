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




@WebServlet("/buscarDocumentos")

public class ConsultarDocumentos extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public ConsultarDocumentos() {
		
		super();
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
				PrintWriter out = response.getWriter();
				RequestDispatcher rd;
				HttpSession misession = request.getSession();
				
				int codigo = 0;
				
				response.setContentType("text/html");
				response.setCharacterEncoding("UTF-8");
				
				String documentosId = (String) request.getParameter("documentosId");
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
					Documentos documentos1 = new Documentos();
					DocumentosBs b1 = new DocumentosBs();
					documentos1.setId(numEntero);
					
					String resp=b1.consultarDocumentos(documentos1);
					
					if (resp!=null)
					{
						System.out.println("respuesta chida: "+resp);
						misession.setAttribute("Respuesta", resp);
						/*rd = request.getRequestDispatcher("buscarTutor.jsp");
						rd.forward(request, response);*/
						
					}
					else
					{
						System.out.println("error");
					}	
					
				}
				
			}
}
