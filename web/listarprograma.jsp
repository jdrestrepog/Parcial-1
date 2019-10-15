<%-- 
    Document   : listarprograma
    Created on : 11/10/2019, 12:59:07 PM
    Author     : juan
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.Programa"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Archivo"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="mycss.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
             <h1>Programa</h1>
             <br>
            <a class="btn btn-success btn-dark bg-dark" href="controlador?accion=agregarp">Agregar Programa</a>
            <br>
            <br>
           
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID Programa</th>
                        <th class="text-center">Nombre Programa</th>
                    </tr>
                </thead>
                <%
                    String ruta = "/Users/Shared/Juan David Rpo/Juan David Rpo/Personal/Semestre 8/Programacion Distribuida y paralela/archivo3.txt";
                    Archivo arch = new Archivo();
                    List<Programa> list = arch.LeerFichero2(ruta);
                    Iterator<Programa> iter = list.iterator();
                    Programa p = null;
                
                    double comision;
                    while (iter.hasNext()) {
                        p = iter.next();
                     
                        
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= p.getId_programa()        %></td>
                        <td class="text-center"><%= p.getPrograma()     %></td>   
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
