<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es" dir="ltr">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-with, initial-scale=1.0">
    <title>Modificar Direccion</title>
  </head>
  <body>
    <header>
      <h1>Inserte los buevos datos para la direccion seleccionada</h1>
    </header>

    <article>
      <section id="modificarDireccionSec">
        <form action="modificarDireccion2" method="get" name="modificarDireccion2">
          <p>Introduzca el nombre de la calle: <input type="text" name="direccion.Calle" value=""> </p>
          <br>
          <p>Introduzca el nombre de la colonia: <input type="text" name="direccion.colinia" value=""></p>
          <br>
          <p>Introduzca el estado:
            <select name="direccionEstados">
              <option value="Aguascalientes">Aguascalientes</option>
              <option value="Baja California">Baja California</option>
              <option value="Baja California Sur">Baja California Sur</option>
              <option value="Campeche">Campeche</option>
              <option value="Coahuila de Zaragoza">Coahuila de Zaragoza</option>
              <option value="Colima">Colima</option>
              <option value="Chiapas">Chiapas</option>
              <option value="Chihuahua">Chihuahua</option>
              <option value="Ciudad de Mexico">Ciudad de Mexico</option>
              <option value="Durango">Durango</option>
              <option value="Guanajuato">Guanajuato</option>
              <option value="Guerrero">Guerrero</option>
              <option value="Hidalgo">Hidalgo</option>
              <option value="Jalisco">Jalisco</option>
              <option value="Mexico">Mexico</option>
              <option value="Michoacan de Ocampo">Michoacan de Ocampo</option>
              <option value="Morelos">Morelos</option>
              <option value="Nayarit">Nayarit</option>
              <option value="Nuevo Leon">Nuevo León</option>
              <option value="Oaxaca">Oaxaca</option>
              <option value="Puebla">Puebla</option>
              <option value="Quéretaro">Quéretaro</option>
              <option value="Quintana Roo">Quintana Roo</option>
              <option value="San Luis potosí">San Luis potosí</option>
              <option value="Sinaloa">Sinaloa</option>
              <option value="Sonora">Sonora</option>
              <option value="Tabasco">Tabasco</option>
              <option value="Tamaulipas">Tamaulipas</option>
              <option value="Tlaxcala">Tlaxcala</option>
              <option value="Veracruz de Ignacio de la Llave ">Veracruz de Ignacio de la Llave </option>
              <option value="Yucatan">Yucatan</option>
              <option value="Zacatecas">Zacatecas</option>
            </select>
          </p>
          <br>
          <p>Introduzca nombre del municipio: <input type="text" name="direccion.municipio" value=""></p>
          <br>
          <p>Introduzca su código postal: <input type="text" name="direccion.codigoPostal" value=""></p>
          <br>
          <p>Introduzca el numero interior: <input type="text" name="direccion.numeroInterior" value=""></p>
          <br>
          <p>Introduzca el numero exterior: <input type="text" name="direccion.numeroExterior" value=""></p>
          <br>


          <input type="submit" name="actualizar" value="actualizar">
        </form>
      </section>
    </article>

  </body>
</html>