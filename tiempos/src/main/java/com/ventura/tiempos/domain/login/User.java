package com.ventura.tiempos.domain.login;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.ventura.tiempos.domain.adm.Company;
import com.ventura.tiempos.domain.adm.Level;
import com.ventura.tiempos.domain.adm.TypeUser;

@Entity
@Table(name="usuarios", schema="adm") 
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @NotEmpty(message = "Por favor ingrese usuario.")
    private String id;

    @Column(name = "pass")
    @NotEmpty(message = "Por favor ingrese su contraseña.")    
    private String pass;
    
    @ManyToOne
    private TypeUser tip_usuario;
      
    @ManyToOne
    private Level level;
    
    @ManyToOne
    private Company comp;
    
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
   
    public TypeUser getTip_usuario() {
    	return tip_usuario;
   	}
    
    public void setTip_usuario(TypeUser tip_usuario) {
		this.tip_usuario = tip_usuario;
	}
    
    public Level getLevel() {
		return level;
	}
    
    public Company getComp() {
		return comp;
	}
    
    public void setLevel(Level level) {
		this.level = level;
	}
    
    public void setComp(Company comp) {
		this.comp = comp;
	}
  
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("Pass: " + pass + ";");
        return buffer.toString();
    }
}