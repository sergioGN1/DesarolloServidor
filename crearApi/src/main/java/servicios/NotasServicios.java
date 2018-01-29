/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import dao.NotasDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Nota;

/**
 *
 * @author DAW
 */
public class NotasServicios {
    public Long parseo(String var) {
        long idParseado = 0;
        idParseado = Long.parseLong(var);

        return idParseado;
    }

    public int parseoInt(String var) {
        int entero = 0;
        entero = Integer.parseInt(var);

        return entero;
    }

    public Nota recogidaParametros(HttpServletRequest request, HttpServletResponse response) {
        Nota nota = new Nota();
        String id_alumno = null;
        String id_asignatura = null;
        String notaNum = null;
        if (!"".equals(request.getParameter("alumnosP")) && request.getParameter("alumnosP") != null) {
            id_alumno = request.getParameter("alumnosP");
            nota.setId_alumno(parseoInt(id_alumno));
        }
        if (!"".equals(request.getParameter("asignaturasP")) && request.getParameter("asignaturasP") != null) {
            id_asignatura = request.getParameter("asignaturasP");
            nota.setId_asignatura(parseoInt(id_asignatura));
        }

        if (!"".equals(request.getParameter("valorNota")) && request.getParameter("valorNota") != null) {
            notaNum = request.getParameter("valorNota");
            nota.setNota(parseoInt(notaNum));
        }
        return nota;
    }

    public List<Nota> getAllNotas()
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.getAllNotasDBUtils();
    }
    
    public int getAllNotasSelect(Nota selectNota)
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.getAllNotasSelectDBUtils(selectNota);
    }
    
   /* public Nota getNotaById(int id){
        NotasDAO dao = new NotasDAO();
        
        return dao.getUserById(id);
        
    }*/
    public Nota addNota(Nota insertNota)
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.insertNotaDBUtils(insertNota);
    }
    
    public int updateNota(Nota notaAct)
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.updateNotaDBUtils(notaAct);
    }
    
    public int deleteNota(Nota notaDel)
    {
        NotasDAO dao = new NotasDAO();
        
        return dao.deleteNotaDBUtils(notaDel);
    }
}
