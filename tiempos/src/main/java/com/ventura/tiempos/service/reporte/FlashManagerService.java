package com.ventura.tiempos.service.reporte;

import java.io.Serializable;
import java.util.List;

import com.ventura.tiempos.domain.reporte.Flash;

public interface FlashManagerService extends Serializable {

	public List<Flash> getFlashList();
	
}
