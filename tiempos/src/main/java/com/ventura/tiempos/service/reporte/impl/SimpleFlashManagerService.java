package com.ventura.tiempos.service.reporte.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.repository.reporte.FlashDao;
import com.ventura.tiempos.service.reporte.FlashManagerService;

@Service
public class SimpleFlashManagerService implements FlashManagerService {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FlashDao flashDao;
	
	public void setFlashDao(FlashDao flashDao) {
		this.flashDao = flashDao;
	}

	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		return flashDao.getFlashList(permisos);
	}	

}
