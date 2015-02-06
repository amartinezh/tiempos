package com.ventura.tiempos.service.reporte.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.repository.reporte.GerenteAgenciaDao;
import com.ventura.tiempos.service.reporte.GerenteAgenciaService;

@Service
public class SimpleGerenteAgenciaService implements GerenteAgenciaService {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private GerenteAgenciaDao gerenteAgenciaDao;
	
	public void setGerenteAgenciaDao(GerenteAgenciaDao gerenteAgenciaDao) {
		this.gerenteAgenciaDao = gerenteAgenciaDao;
	}
	
	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		return gerenteAgenciaDao.getFlashList(permisos);
	}	

}
