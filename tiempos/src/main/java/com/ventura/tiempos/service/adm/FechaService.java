package com.ventura.tiempos.service.adm;

import java.util.List;

import com.ventura.tiempos.domain.adm.Fecha;

public interface FechaService {
	
	public List<Fecha> getListFecha(Fecha fecha);
	public void generarFecha(Fecha fecha);
	
}
