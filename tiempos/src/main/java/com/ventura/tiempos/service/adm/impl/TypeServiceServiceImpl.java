package com.ventura.tiempos.service.adm.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.tiempos.domain.adm.TypeUser;
import com.ventura.tiempos.repository.adm.TypeUserDao;
import com.ventura.tiempos.service.adm.TypeUserService;

@Service
public class TypeServiceServiceImpl implements TypeUserService{

	@Autowired
	private TypeUserDao typeuserdao;

	@Transactional
	public void saveTypeUser(TypeUser typeuser) {
		typeuserdao.saveTypeUser(typeuser);
	}

	@Transactional(readOnly = true)
	public List<TypeUser> listTypeUser() {
		return typeuserdao.listTypeUser();
	}

	@Transactional(readOnly = true)
	public TypeUser getTypeUser(String id) {
		return typeuserdao.getTypeUser(id);
	}

	@Transactional
	public void deleteTypeUser(String id) {
		typeuserdao.deleteTypeUser(id);

	}
}