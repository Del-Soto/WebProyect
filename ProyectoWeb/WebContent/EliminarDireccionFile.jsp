<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>Eliminar direccion</title>
  </head>
  <body>
    <header>
      <h1>Elimina una direccion</h1>
    </header>

    <article>
      <section aria-label="Formulario" id="FormularioDireccion">
      <p> introduza el id de la direccion que quiera eliminar:
      
        <form name="eliminarDireccion" action="eliminarDireccion" method="get">
          <input type="text" name="direccion.id" value="">
          <br>
          <input type="submit" name="buscar" value="buscar">
          
        </form>
        </p>

      </section>

    </article>

  </body>
</html>