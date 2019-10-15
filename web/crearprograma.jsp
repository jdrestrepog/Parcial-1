<%-- 
    Document   : crearprograma
    Created on : 11/10/2019, 01:02:11 PM
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
                    ID programa<br>
                    <input class="form-control" type="text" name="idprograma" onChange="validarSiNumero(this);" required/><br>
                    Nombre Programa <br>
                    <input class="form-control" type="text" name="nombreprograma" required=""><br>

                    <input class="btn btn-primary" type="submit" name="accion" value="crearp">
                </form>
                <script src="js/jquery-3.2.1.min.js"></script>
                <script type="js/bootstrap.min.js"></script>
            </div>
        </div>
    </body>
</html>
