/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;
import servicios.AsignaturasServicios;

/**
 *
 * @author DAW
 */
@WebServlet(name = "Asignaturas", urlPatterns = {"/rest/asignaturas"})
public class Asignaturas extends HttpServlet {

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
        try {
            AsignaturasServicios as = new AsignaturasServicios();
            String accion = request.getParameter("accion");
            
            if(null == accion){
                accion = "getall";
            }
            
            switch (accion) {
                case "getall":
                    request.setAttribute("asignaturas", as.getAllAsignaturas());
                    request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
                    break;
                    
                case "insert":
                    Asignatura asig = as.recogidaParametros(request,response);
                    int filaInsertada = 0;
                    asig = as.addAsignatura(asig);
                    List<Asignatura> asignaturas = new ArrayList();
                    asignaturas.add(asig);
                    request.setAttribute("filas_insertadas", filaInsertada);
                    break;
                    
                case "update":
                    Asignatura asigUpt = as.recogidaParametros(request, response);
                    int filasActualizadas = 0;
                    
                    
                    List<Asignatura> AsignaturasUpdate = new ArrayList();
                    
                    filasActualizadas = as.updateAsignatura(asigUpt);
                    AsignaturasUpdate.add(asigUpt);
                    request.setAttribute("filas_actualizadas", filasActualizadas);
                    break;
                    
                case "delete":
                    Asignatura asigBor = as.recogidaParametros(request, response);
                    int filasBorradas = 0;
                    
                    
                    filasBorradas = as.deleteAsignatura(asigBor);
                    if(filasBorradas == -1){
                        request.setAttribute("filasBorradas",filasBorradas);
                        request.setAttribute("objetoBorrar", asigBor);
                    }else{
                        request.setAttribute("filasBorradas",filasBorradas);
                    }
                    
                    
                    request.setAttribute("filas_borradas", filasBorradas);
                    break;
                    
                    
                case "completeDelete":
                    Asignatura asignaturaDC = as.recogidaParametros(request, response);
                    int filasBorradasC = 0;
                    filasBorradasC = as.completeDeleteAlumno(asignaturaDC);
                    request.setAttribute("filas_borradas",filasBorradasC);
                    break;
                    
                    
            }
            request.setAttribute("asignaturas", as.getAllAsignaturas());
            request.getRequestDispatcher("pintarListaAsignaturas.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Asignaturas.class.getName()).log(Level.SEVERE, null, ex);
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
        AsignaturasServicios as = new AsignaturasServicios();
        List<Asignatura> asignaturas =  as.getAllAsignaturas();
        request.setAttribute("json", asignaturas);
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
        request.getAttribute("json");
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
