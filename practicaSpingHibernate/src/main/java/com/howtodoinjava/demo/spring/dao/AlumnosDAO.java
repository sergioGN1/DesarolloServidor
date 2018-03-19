/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.howtodoinjava.demo.spring.dao;

import com.howtodoinjava.demo.spring.model.Alumno;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DAW
 */
@Repository
public class AlumnosDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Alumno> list() {
        @SuppressWarnings("unchecked")
        List<Alumno> listaAlumnos = (List<Alumno>) sessionFactory.getCurrentSession().createQuery("from Alumno").list();
        return listaAlumnos;

    }

    public void save(Alumno alumno) {
        sessionFactory.getCurrentSession().save(alumno);
    }

    public void delete(Alumno alumno){
        sessionFactory.getCurrentSession().delete(alumno);
    }
    
    public void update(Alumno alumno){
        sessionFactory.getCurrentSession().update(alumno);
    }
}
