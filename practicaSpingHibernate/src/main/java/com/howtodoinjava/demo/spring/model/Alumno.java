package com.howtodoinjava.demo.spring.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Alumno")
public class Alumno {

    @Id
    @GeneratedValue
    @Column(name = "Alumno_ID")
    private Long id;

    @Column(name = "Alumno_NOMBRE")
    @Size(max = 20, min = 3, message = "{user.name.invalid}")
    @NotEmpty(message = "Please Enter your name")
    private String name;

    @Column(name = "Alumno_EMAIL", unique = true)
    @Email(message = "{user.email.invalid}")
    @NotEmpty(message = "Please Enter your email")
    private String email;
    
    @Column(name = "Alumno_FECHA")
    @NotEmpty(message = "Please Enter your email")
    private Date fecha;

    public Alumno(Long id, String name, String email,Date fecha) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.fecha = fecha;
    }

    public Alumno() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
