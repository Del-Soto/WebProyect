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

@WebServlet("/eliminarDireccion")

public class EliminarDireccion extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	public EliminarDireccion()
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
				
				String direccionId = (String) request.getParameter("direccion.id");
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
					Direccion direccion1 = new  Direccion();
					direccion1.setId(numEntero);
					DireccionBs direccionbs1 = new DireccionBs();
					
					System.out.println("id consultado: "+numEntero);
					
					
					String resultado = direccionbs1.buscarDireccion(direccion1);
					
					
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
