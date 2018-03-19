/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.howtodoinjava.demo.spring.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.howtodoinjava.demo.spring.model.Alumno;
import com.howtodoinjava.demo.spring.service.ServiceAlumnos;

/**
 *
 * @author DAW
 */
@Controller
public class ControllerAlumnos {

    @Autowired
    private ServiceAlumnos userServices;

    @GetMapping("/alumnos")
    public String listUsers(
            Locale locale, Model model) {
        model.addAttribute("alumnos", userServices.list());
        return "editUsers";
    }

    @ModelAttribute("Alumno")
    public Alumno formBackingObject() {
        return new Alumno();
    }

    @PostMapping("/addUser")
    public String addUsers(
            @ModelAttribute("Alumno") @Valid Alumno alumno, BindingResult result, Model model) {
        
        if (result.hasErrors()) {

            model.addAttribute("alumnos", userServices.list());
            return "editUsers";
        }
        userServices.save(alumno);
        return "redirect:/alumnos";
    }
    @PostMapping("/deleteUser")
    public String deleteUser(
            @ModelAttribute("Alumno") @Valid Alumno alumno, BindingResult result, Model model) {
        
        if (result.hasErrors()) {

            model.addAttribute("alumnos", userServices.list());
            return "editUsers";
        }
        userServices.delete(alumno);
        return "redirect:/alumnos";
    }
    @PostMapping("/updateUser")
    public String updateUser(
            @ModelAttribute("Alumno") @Valid Alumno alumno, BindingResult result, Model model) {
        
        if (result.hasErrors()) {

            model.addAttribute("alumnos", userServices.list());
            return "editUsers";
        }
        userServices.update(alumno);
        return "redirect:/alumnos";
    }
}
