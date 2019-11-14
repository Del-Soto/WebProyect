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
      <h1>Busque la documentacion por su id</h1>
    </header>

    <article>
      <section id="buscaDocumentosSec">
        <form action="buscarDocumentos" method="get" name="buscarDocumentos">
          <input type="text" name="documentosId" value="">
		  <br>

          <input type="submit" name="consultarDocumentos" value="consultarDocumentos">


        </form>

      </section>

    </article>

  </body>
</html>