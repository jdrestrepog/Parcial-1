/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Alumno;
import modelo.Archivo;
import modelo.Programa;

/**
 *
 * @author juan
 */
public class controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        String acceso;

        if (accion.equalsIgnoreCase("listara")) {
            RequestDispatcher vista = request.getRequestDispatcher("listar.jsp");
            vista.forward(request, response);
        } 
        else if (accion.equalsIgnoreCase("listarp")) {
            RequestDispatcher vista = request.getRequestDispatcher("listarprograma.jsp");
            vista.forward(request, response);
        }else if (accion.equalsIgnoreCase("Crearal")) {
            String identificacion = request.getParameter("identificacion");
            String nombrecompleto = request.getParameter("nombrecompleto");
            int semestre = Integer.parseInt(request.getParameter("semestre"));
            int programa = Integer.parseInt(request.getParameter("programa"));
            int estado1 = Integer.parseInt(request.getParameter("estado"));
            
            boolean estado = false;
            
            if (estado1 == 1) {
                estado = true;
            }else if (estado1 == 0) {
                estado = false;
            }


            Alumno a = new Alumno();

            a.setIdentificación(identificacion);
            a.setNombreCompleto(nombrecompleto);
            a.setSemestre(semestre);
            a.setId_programa(programa);
            a.setEstado(estado);

            String ruta = "/Users/Shared/Juan David Rpo/Juan David Rpo/Personal/Semestre 8/Programacion Distribuida y paralela/archivo2.txt";
            // Insertar y poner en un archivo
            Archivo arch = new Archivo();
            arch.EscribeFichero(ruta, a);
            
            RequestDispatcher vista = request.getRequestDispatcher("listar.jsp");
            vista.forward(request, response);
            
        } else if (accion.equalsIgnoreCase("agregaral")) {
            RequestDispatcher vista = request.getRequestDispatcher("crearalumno.jsp");
            vista.forward(request, response);
        }
        else if (accion.equalsIgnoreCase("agregarp")) {
            RequestDispatcher vista = request.getRequestDispatcher("crearprograma.jsp");
            vista.forward(request, response);
        }else if (accion.equalsIgnoreCase("crearp")) {
            
            int idprograma = Integer.parseInt(request.getParameter("idprograma"));
            String programa = request.getParameter("nombreprograma");
 

            Programa p = new Programa();
            
            p.setId_programa(idprograma);
            p.setPrograma(programa);


            String ruta = "/Users/Shared/Juan David Rpo/Juan David Rpo/Personal/Semestre 8/Programacion Distribuida y paralela/archivo3.txt";
            // Insertar y poner en un archivo
            Archivo arch = new Archivo();
            arch.EscribeFichero2(ruta, p);
            
            RequestDispatcher vista = request.getRequestDispatcher("listarprograma.jsp");
            vista.forward(request, response);
            
        } 
        

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
