package com.ventura.tiempos.service.adm;

import java.util.List;
import com.ventura.tiempos.domain.adm.TypeUser;

public interface TypeUserService {
	
	public void saveTypeUser(TypeUser typeuser);
	public List<TypeUser> listTypeUser();
	public TypeUser getTypeUser(int id);
	public void deleteTypeUser(int id);
	
}
