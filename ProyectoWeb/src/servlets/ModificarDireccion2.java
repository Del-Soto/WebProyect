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

@WebServlet("/modificarDireccion2")

public class ModificarDireccion2 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	public ModificarDireccion2()
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
				
				String calle = (String) request.getParameter("direccion.Calle");
				String colonia = (String) request.getParameter("direccion.colinia");
				String municipio = (String) request.getParameter("direccion.municipio");
				String codigoPostal = (String) request.getParameter("direccion.codigoPostal");
				String numeroExterior = (String) request.getParameter("direccion.numeroExterior");
				String numeroInterior = (String) request.getParameter("direccion.numeroInterior");
				String estado = (String) request.getParameter("direccionEstados");
		
				
				if(calle == null || colonia == null || municipio ==null || codigoPostal == null || numeroExterior== null || numeroInterior == null || estado == null)
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
					DireccionBs direccionbs1 = new DireccionBs();
					
					direccion1.setCalle(calle);
					direccion1.setCodigoPostal(codigoPostal);
					direccion1.setColonia(colonia);
					direccion1.setEstado(estado);
					direccion1.setMunicipio(municipio);
					direccion1.setNumeroExterior(numeroExterior);
					direccion1.setNumeroInterior(numeroExterior);
					
					
					
					int resultado = direccionbs1.actualizarDireccion(direccion1);
					
					System.out.println("el resultado"+resultado);
					
					if (resultado == 1) 
					{
						rd = request.getRequestDispatcher("exito.jsp");
						codigo = 1;
						misession.setAttribute("codigo", codigo);
						rd.forward(request, response);
					}
					
				}
			}

}