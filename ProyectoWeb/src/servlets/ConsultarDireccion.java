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

import beans.Direccion;
import bussines.DireccionBs;


@WebServlet("/buscaDireccion")

public class ConsultarDireccion extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public ConsultarDireccion() {
		
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
				
				String direccionId = (String) request.getParameter("direccionId");
				int numEntero = Integer.parseInt(direccionId);
				
				
				
				
				
				
				if(direccionId == null || direccionId.isEmpty())
				{
						rd = request.getRequestDispatcher("error.jsp");
						codigo = -1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
						System.err.println("----> Resultado:"+codigo);
			
					
				}
				else
				{
					Direccion direccion1 = new Direccion();
					DireccionBs b1 = new DireccionBs();
					direccion1.setId(numEntero);
					
					String resp=b1.consultarDireccion(direccion1);
					
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
