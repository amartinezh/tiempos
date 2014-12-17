package com.ventura.tiempos.repository.adm;

import java.util.List;
import com.ventura.tiempos.domain.adm.TypeUser;

public interface TypeUserDao {
	
	/*
	 * CREATE and UPDATE
	 */
	public void saveTypeUser(TypeUser typeuser);
	
	/*
	 * READ
	 */
	public List<TypeUser> listTypeUser();
	public TypeUser getTypeUser(String k);
    
    
	/*
	 * DELETE
	 */
	public void deleteTypeUser(String k);
}
