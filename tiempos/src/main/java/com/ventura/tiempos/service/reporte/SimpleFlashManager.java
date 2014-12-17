package com.ventura.tiempos.service.reporte;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.repository.reporte.FlashDao;

public class SimpleFlashManager implements FlashManager {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private FlashDao flashDao;
	
	public void setFlashDao(FlashDao flashDao) {
		this.flashDao = flashDao;
	}

	public List<Flash> getFlashList() {
		return flashDao.getFlashList();
	}	

}
