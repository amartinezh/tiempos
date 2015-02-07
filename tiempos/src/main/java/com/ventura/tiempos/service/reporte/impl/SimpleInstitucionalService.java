package com.ventura.tiempos.service.reporte.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.repository.reporte.InstitucionalDao;
import com.ventura.tiempos.service.reporte.InstitucionalService;
import com.ventura.tiempos.service.reporte.VendedorService;

@Service
public class SimpleInstitucionalService implements InstitucionalService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private InstitucionalDao institucionalDao;
	
	public void setInstitucionalDao(InstitucionalDao institucionalDao) {
		this.institucionalDao = institucionalDao;
	}
	
	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		return institucionalDao.getFlashList(permisos);
	}
	
}
