package com.ventura.tiempos.service.reporte;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ventura.tiempos.domain.reporte.Flash;

public interface FlashManagerService extends Serializable {

	public List<Flash> getFlashList(List<Map<String, String>> permisos);
	public List<Flash> getFlashListCanal(List<Map<String, String>> permisos);
	public List<Flash> getFlashListDistrito(List<Map<String, String>> permisos);
	public List<Flash> getFlashListItem(List<Map<String, String>> permisos);
	public List<Flash> getFlashListCliente(List<Map<String, String>> permisos);
	public List<Flash> getFlashListTipoMarca(List<Map<String, String>> permisos);
	public List<Flash> getFlashListCategoria(List<Map<String, String>> permisos);
	
}
