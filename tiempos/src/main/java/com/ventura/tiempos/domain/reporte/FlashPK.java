package com.ventura.tiempos.domain.reporte;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;

public class FlashPK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FlashPK() {
		// TODO Auto-generated constructor stub
	}
	
	@Column
	private int ano;
	@Column
	private BigDecimal cocust;
	@Column
	private String coprod;
	@Column
	private int mes;
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof FlashPK) {
			FlashPK f = (FlashPK) obj;
			if(f.getMes() != mes) {
				return false;
			}
			if(f.getAno() != ano) {
				return false;
			}
			if(f.getCocust() != cocust) {
				return false;
			}
			if(!f.getCoprod().equals(coprod)) {
				return false;
			}
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return coprod.hashCode() + ano + mes + cocust.hashCode();
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public BigDecimal getCocust() {
		return cocust;
	}

	public void setCocust(BigDecimal cocust) {
		this.cocust = cocust;
	}

	public String getCoprod() {
		return coprod;
	}

	public void setCoprod(String coprod) {
		this.coprod = coprod;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

}
