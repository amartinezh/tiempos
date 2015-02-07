package com.ventura.tiempos.repository.reporte;

import java.util.List;
import java.util.Map;

import com.ventura.tiempos.domain.reporte.Flash;

public interface InstitucionalDao {
	
	public List<Flash> getFlashList(List<Map<String, String>> permisos);

}
