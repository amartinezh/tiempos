package com.ventura.tiempos.repository.reporte;

import java.util.List;
import java.util.Map;

import com.ventura.tiempos.domain.reporte.Flash;

public interface FlashDao {

	public List<Flash> getFlashList(List<Map<String, String>> permisos);
	public List<Flash> getFlashListCanal(List<Map<String, String>> permisos);
	
}
