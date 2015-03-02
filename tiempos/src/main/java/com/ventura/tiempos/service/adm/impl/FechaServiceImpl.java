package com.ventura.tiempos.service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.tiempos.domain.adm.Fecha;
import com.ventura.tiempos.repository.adm.FechaDao;
import com.ventura.tiempos.service.adm.FechaService;

@Service
public class FechaServiceImpl implements FechaService {
	
	@Autowired
	private FechaDao fechaDao;

	public List<Fecha> getListFecha(Fecha fecha) {
		return fechaDao.getListFecha(fecha);
	}
	
	public void generarFecha(Fecha fecha) {
		fechaDao.generarFecha(fecha);
	}	

}
