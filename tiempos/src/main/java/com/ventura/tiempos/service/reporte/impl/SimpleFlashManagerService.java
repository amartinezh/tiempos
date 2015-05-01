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
	/*
	public List<Flash> getFlashListCanal(List<Map<String, String>> permisos) {
		return flashDao.getFlashListCanal(permisos);
	}
	
	public List<Flash> getFlashListDistrito(List<Map<String, String>> permisos) {
		return flashDao.getFlashListDistrito(permisos);
	}

	public List<Flash> getFlashListItem(List<Map<String, String>> permisos) {
		return flashDao.getFlashListItem(permisos);		
	}

	public List<Flash> getFlashListCliente(List<Map<String, String>> permisos) {
		return flashDao.getFlashListCliente(permisos);
	}
	
	public List<Flash> getFlashListTipoMarca(List<Map<String, String>> permisos) {
		return flashDao.getFlashListTipoMarca(permisos);
	}
	
	public List<Flash> getFlashListCategoria(List<Map<String, String>> permisos) {
		return flashDao.getFlashListCategoria(permisos);
	}
	
	public List<Flash> getFlashListVendedor(List<Map<String, String>> permisos) {
		return flashDao.getFlashListVendedor(permisos);
	}
	*/
}
