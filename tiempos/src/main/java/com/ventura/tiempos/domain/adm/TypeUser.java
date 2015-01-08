package com.ventura.tiempos.domain.adm;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="tipo_usuarios", schema="adm")
public class TypeUser implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="adm.tipo_usuarios_id_seq")
	@SequenceGenerator(name="adm.tipo_usuarios_id_seq", sequenceName="adm.tipo_usuarios_id_seq", allocationSize=1)
    private int id;
	
	@NotEmpty(message = "Por favor ingrese la descripción")
	@Column(name = "descripcion")	
	private String descripcion;
	
	public TypeUser() {
		// TODO Auto-generated constructor stub
	}
	
	public TypeUser(int id, String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public String toString() {
        return "Descripción: " + descripcion + ";";
    }
	
}
