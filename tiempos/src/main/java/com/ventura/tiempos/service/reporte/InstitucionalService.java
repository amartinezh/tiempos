package com.ventura.tiempos.service.reporte;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ventura.tiempos.domain.reporte.Flash;

public interface InstitucionalService extends Serializable {

	public List<Flash> getFlashList(List<Map<String, String>> permisos);
	
}
