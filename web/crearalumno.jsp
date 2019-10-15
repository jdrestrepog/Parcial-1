<%-- 
    Document   : crearalumno
    Created on : 11/10/2019, 12:25:28 PM
    Author     : juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="mycss.css">
        <title>JSP Page</title>
        <script type="text/javascript">
                   function validarSiNumero(elemento) {
                var numero = parseInt(elemento.value, 10);
                //Validamos que se haya ingresado solo numeros
                if (isNaN(numero)) {
                    alert('Ingrese solo números.');
                    elemento.focus();
                    elemento.select();
                    return false;
                }
                //Validamos que se cumpla el rango
                if (numero < 1 || numero > 10) {
                    alert('Solo se permite el siguiente rango: 1 - 10');
                    elemento.focus();
                    return false;
                }
                return true;
            }
        </script>>
    </head>
    <body>
        <div class="container">
            <div class="col-8">
                <h1>Modificar Registro</h1>
                <form action="controlador">
                    Identificacion<br>
                    <input class="form-control" type="text" name="identificacion" onChange="validarSiNumero(this.value);" required/><br>
                    Nombre completo: <br>
                    <input class="form-control" type="text" name="nombrecompleto" required=""><br>
                    Semestre: <br>
                    <input class="form-control" type="text" name="semestre" onChange="validarSiNumero(this);"  required=""><br>
                    Programa: <br>
                    <input class="form-control" type="text" name="programa" required=""><br>
                    Estado <br>
                    <input class="form-control" type="text" name="estado" placeholder="1-Activo 0-Inactivo" required=""><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Crearal" >
                </form>
                <script src="js/jquery-3.2.1.min.js"></script>
                <script type="js/bootstrap.min.js"></script>
            </div>
        </div>
    </body>
</html>
