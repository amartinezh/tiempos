package com.ventura.tiempos.domain.adm;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fechas", schema = "adm")
public class Fecha {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fecha")
	private Date fecha;

	@Column(name = "campo")
	private int campo;
	
	private int ano;
	
	private int mes;

	public int getAno() {
		return ano;
	}

	public int getMes() {
		return mes;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public Fecha() {
		// TODO Auto-generated constructor stub
	}
	
	public Fecha(Date fecha, int campo) {
		this.fecha = fecha;
		this.campo = campo;
	}

	@Override
	public String toString() {
		return "Fecha [fecha=" + fecha + ", campo=" + campo + "]";
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getFecha() {
		return fecha;
	}

	public int getCampo() {
		return campo;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public void setCampo(int campo) {
		this.campo = campo;
	}

}
