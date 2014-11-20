package com.ventura.tiempos.domain.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="users", schema="public") 
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty 
    @Email (message = "Por favor ingrese su correo.")
    private String id;

    @NotEmpty(message = "Por favor ingrese su contraseña.")
    private String pass;
    
    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    } 
    
    public String getPass() {
        return pass;
    }
    
    public void setPass(String pass) {
    	// Encriptar
        this.pass = pass;
    }
    
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Pass: " + pass + ";");
        return buffer.toString();
    }
}