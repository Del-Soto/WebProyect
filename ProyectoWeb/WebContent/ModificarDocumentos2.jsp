<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang=es dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <meta charset="utf-8">
    <title>Pantalla actualizar Documentos</title>
  </head>
  <body>
    <header>
      <h1>Actualizar documentos</h1>
    </header>

    <article>
      <section id="registrarDireccionSec">
        <form action="actualizarDocumentos" method="get" name="actualizarDocumentos">
          <p>Fotografía:
            <select name="documentosFotografía">
            <option value="Si">Si</option>
            <option value="No">No</option>
          </select> </p>
          <br>
          <p>Carta Compromiso:
            <select name="documentosCartaCompromiso">
            <option value="Si">Si</option>
            <option value="No">No</option>
        </select></p>
          <br>
          <p>Comprobante de Domicilio:
            <select name="direccionComprobanteDomicilio">
              <option value="Si">Si</option>
              <option value="No">No</option>
            </select>
          </p>
          <br>
          <p>identificación del Tutor:
            <select name="direccionIdentificacionT">
              <option value="Si">Si</option>
              <option value="No">No</option>
            </select>
          </p>
          <br>
          <p>identificación del Alumno:
            <select name="direccionIdentificacionA">
              <option value="Si">Si</option>
              <option value="No">No</option>
            </select>
          </p>
          <br>
          <input type="submit" name="registrar" value="registrar">
        </form>
      </section>
    </article>

  </body>
</html>
