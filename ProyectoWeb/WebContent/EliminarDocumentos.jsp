<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>Eliminar documentos</title>
  </head>
  <body>
    <header>
      <h1>Elimina una documentos</h1>
    </header>

    <article>
      <section aria-label="Formulario" id="FormularioDocumentos">
      <p> introduza el id de la documentacion que quiera eliminar:
      
        <form name="eliminarDocumentos" action="eliminarDocumentos" method="get">
          <input type="text" name="documentos.id" value="">
          <br>
          <input type="submit" name="buscar" value="buscar">
          
        </form>
        </p>

      </section>

    </article>

  </body>
</html>