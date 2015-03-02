package com.ventura.tiempos.repository.adm;

import java.util.List;

import com.ventura.tiempos.domain.adm.Fecha;

public interface FechaDao {

	public List<Fecha> getListFecha(Fecha fecha);
	public void generarFecha(Fecha fecha);
}
