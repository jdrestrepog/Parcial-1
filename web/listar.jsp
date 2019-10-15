<%-- 
    Document   : listar
    Created on : 2/10/2019, 09:58:17 PM
    Author     : juan
--%>

<%@page import="java.rmi.Naming"%>
<%@page import="java.rmi.Remote"%>
<%@page import="interfaces.CalcInterface"%>
<%@page import="modelo.Alumno"%>
<%@page import="java.util.Iterator"%>
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
            <h1>Alumnos</h1>
            <br>
            <a class="btn btn-success btn-dark bg-dark" href="controlador?accion=agregaral">Agregar Alumno</a>
            <br>
            <br>

            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID alumno</th>
                        <th class="text-center">Nombre Completo</th>
                        <th class="text-center">Semestre</th>
                        <th class="text-center">ID Programa</th>
                        <th class="text-center">Estado</th>

                    </tr>
                </thead>
                <%
                    String ruta = "/Users/Shared/Juan David Rpo/Juan David Rpo/Personal/Semestre 8/Programacion Distribuida y paralela/archivo2.txt";
                    Archivo arch = new Archivo();
                    List<Alumno> list = arch.LeerFichero(ruta);
                    Iterator<Alumno> iter = list.iterator();
                    Alumno a = null;
            
                    while (iter.hasNext()) {
                        a = iter.next();

                %>
                <tbody>
                    <tr>
                        
                        <td class="text-center"><%= a.getIdentificación()%></td>
                        <td class="text-center"><%= a.getNombreCompleto()%></td>
                        <td class="text-center"><%= a.getSemestre()%></td>
                        <td class="text-center"><%= a.getId_programa()%></td>
                        <td class="text-center"><%= a.getEstado()%></td>
                      
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
