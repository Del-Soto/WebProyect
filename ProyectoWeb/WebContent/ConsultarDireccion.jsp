<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Buscar tutor por nombre</title>
  </head>
  <body>
<%
HttpSession misesion=request.getSession();
String codigo= "";
codigo=(String)misesion.getAttribute("Respuesta");
if(codigo!=null){
	
	out.write(codigo);
	
	}else{
}

misesion.removeAttribute(codigo);
	
%>
    <header>
      <h1>Busque la direccion por su id</h1>
    </header>

    <article>
      <section id="buscaDireccionSec">
        <form action="buscaDireccion" method="get" name="buscaDireccion">
          <input type="text" name="direccionId" value="">
		  <br>

          <input type="submit" name="consultarDireccion" value="consultarDireccion">


        </form>

      </section>

    </article>

  </body>
</html>