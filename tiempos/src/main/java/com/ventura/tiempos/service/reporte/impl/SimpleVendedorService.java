package com.ventura.tiempos.service.reporte.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.repository.reporte.VendedorDao;
import com.ventura.tiempos.service.reporte.VendedorService;

@Service
public class SimpleVendedorService implements VendedorService {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private VendedorDao vendedorDao;
	
	public void setVendedorDao(VendedorDao vendedorDao) {
		this.vendedorDao = vendedorDao;
	}
	
	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		return vendedorDao.getFlashList(permisos);
	}

}
