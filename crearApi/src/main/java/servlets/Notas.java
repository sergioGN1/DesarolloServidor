/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nota;
import servicios.AlumnosServicios;
import servicios.AsignaturasServicios;
import servicios.NotasServicios;

/**
 *
 * @author DAW
 */
@WebServlet(name = "Notas", urlPatterns = {"/rest/notas"})
public class Notas extends HttpServlet {

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
        NotasServicios ns = new NotasServicios();
        AlumnosServicios aas = new AlumnosServicios();
        AsignaturasServicios asigSer = new AsignaturasServicios();
        String accion = request.getParameter("accion");

        if (null == accion) {
            accion = "getall";
        }

        switch (accion) {
            case "selectNota":
                Nota selectNota = ns.recogidaParametros(request, response);
                request.setAttribute("alumnos", aas.getAllAlumnos());
                request.setAttribute("asignaturas", asigSer.getAllAsignaturas());
                request.setAttribute("notasAlumno", ns.getAllNotasSelect(selectNota));
                request.setAttribute("alumnoId", selectNota.getId_alumno());
                request.setAttribute("asignaturaId", selectNota.getId_asignatura());
                request.getRequestDispatcher("pintarNotas.jsp").forward(request, response);
                break;
                
            case "getall":
                request.setAttribute("alumnos", aas.getAllAlumnos());
                request.setAttribute("asignaturas", asigSer.getAllAsignaturas());
                request.setAttribute("notas", ns.getAllNotas());
                request.getRequestDispatcher("pintarNotas.jsp").forward(request, response);
                break;

            case "insert":
                Nota insertNota = ns.recogidaParametros(request, response);
                insertNota = ns.addNota(insertNota);
                List<Nota> notas = new ArrayList();
                notas.add(insertNota);
                if(insertNota == null){
                    request.setAttribute("filas_insertadas", 0);
                }   else {
                    request.setAttribute("filas_insertadas", 1);
                }
                request.setAttribute("alumnos", aas.getAllAlumnos());
                request.setAttribute("asignaturas", asigSer.getAllAsignaturas());
                request.getRequestDispatcher("pintarNotas.jsp").forward(request, response);
                break;

            case "update":
                Nota notaUpt = ns.recogidaParametros(request, response);
                int filasActualizadas = 0;

                List<Nota> NotasUpdate = new ArrayList();

                filasActualizadas = ns.updateNota(notaUpt);
                NotasUpdate.add(notaUpt);
                request.setAttribute("alumnos", aas.getAllAlumnos());
                request.setAttribute("asignaturas", asigSer.getAllAsignaturas());
                request.setAttribute("filas_actualizadas", filasActualizadas);
                request.getRequestDispatcher("pintarNotas.jsp").forward(request, response);
                break;

            case "delete":
                Nota notaBor = ns.recogidaParametros(request, response);
                int filasBorradas = 0;
                filasBorradas = ns.deleteNota(notaBor);
                request.setAttribute("alumnos", aas.getAllAlumnos());
                request.setAttribute("asignaturas", asigSer.getAllAsignaturas());
                request.setAttribute("filas_borradas", filasBorradas);
                request.getRequestDispatcher("pintarNotas.jsp").forward(request, response);
                break;

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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp); //To change body of generated methods, choose Tools | Templates.
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
