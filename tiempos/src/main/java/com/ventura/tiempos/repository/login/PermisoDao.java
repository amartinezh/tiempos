package com.ventura.tiempos.repository.login;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.ventura.tiempos.domain.login.User;

public interface PermisoDao {
	
	@Transactional
	public List<Map<String,String>> getPermisos(User usuario);
	

}
