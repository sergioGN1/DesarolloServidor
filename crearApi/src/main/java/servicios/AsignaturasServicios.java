/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.AsignaturasDAO;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Asignatura;

/**
 *
 * @author DAW
 */
public class AsignaturasServicios {
    public Long parseoId(String id){
        long idParseado = 0;
        idParseado = Long.parseLong(id);

        return idParseado;
    }
    
    public Asignatura recogidaParametros(HttpServletRequest request, HttpServletResponse response){
        Asignatura asignatura = new Asignatura();
        String nombre = null, curso = null,idr = null, ciclo = null;
        if (!"".equals(request.getParameter("nombre")) && request.getParameter("nombre")!=null) {
            nombre = request.getParameter("nombre");
            asignatura.setNombre(nombre);
        }
        if (!"".equals(request.getParameter("curso")) && request.getParameter("curso")!=null) {
            curso = request.getParameter("curso");
            asignatura.setCurso(curso);
        }
        
        if (!"".equals(request.getParameter("id")) && request.getParameter("id")!=null) {
            idr = request.getParameter("id");
            asignatura.setId(parseoId(idr));
        }
        if (!"".equals(request.getParameter("ciclo")) && request.getParameter("ciclo")!=null) {
            ciclo = request.getParameter("ciclo");
            asignatura.setCiclo(ciclo);
        }
        return asignatura;
    }
    
    public List<Asignatura> getAllAsignaturas()
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.getAllAsignaturasDBUtils();
    }
    
   /* public Asignatura getAsignaturaById(int id){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.getUserById(id);
        
    }*/
    
    public int completeDeleteAlumno(Asignatura borradoCompleto) throws SQLException{
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.completeDeleteAsignatura(borradoCompleto);
    }
    public Asignatura addAsignatura(Asignatura asignaturaNuevo)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.insertAsignaturaDBUtils(asignaturaNuevo);
    }
    
    public int updateAsignatura(Asignatura asignaturaNuevo)
    {
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.updateAsignaturaDBUtils(asignaturaNuevo);
    }
    
    public int deleteAsignatura(Asignatura asignaturaNuevo){
        AsignaturasDAO dao = new AsignaturasDAO();
        
        return dao.deleteAsignaturaDBUtils(asignaturaNuevo);
    }
}
