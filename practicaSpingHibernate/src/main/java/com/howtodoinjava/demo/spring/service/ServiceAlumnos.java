/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.howtodoinjava.demo.spring.service;

import com.howtodoinjava.demo.spring.dao.AlumnosDAO;
import com.howtodoinjava.demo.spring.model.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DAW
 */
@Service
public class ServiceAlumnos {

    @Autowired
    private AlumnosDAO userdao;

    @Transactional(readOnly = true)
    public List<Alumno> list() {
        return userdao.list();
    }

    @Transactional
    public void save(Alumno user) {
        userdao.save(user);
    }

    @Transactional
    public void delete(Alumno alumno) {
        userdao.delete(alumno);
    }

    @Transactional
    public void update(Alumno alumno) {
        userdao.update(alumno);
    }
}
