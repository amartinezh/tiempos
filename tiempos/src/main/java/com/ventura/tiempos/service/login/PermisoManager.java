package com.ventura.tiempos.service.login;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.ventura.tiempos.domain.login.User;

public interface PermisoManager extends Serializable {

	public List<Map<String,String>> getPermisos(User usuario);
	
}
