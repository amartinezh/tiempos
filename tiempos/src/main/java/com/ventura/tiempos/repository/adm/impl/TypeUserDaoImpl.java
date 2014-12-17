package com.ventura.tiempos.repository.adm.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ventura.tiempos.domain.adm.TypeUser;
import com.ventura.tiempos.repository.adm.TypeUserDao;

@Repository
public class TypeUserDaoImpl implements TypeUserDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void saveTypeUser(TypeUser typeuser) {
		getSession().merge(typeuser);
	}
    
    @SuppressWarnings("unchecked")
	public List<TypeUser> listTypeUser() {
		return getSession().createCriteria(TypeUser.class).list();
	}
    
    public TypeUser getTypeUser(String id) {
		return (TypeUser) getSession().get(TypeUser.class, id);
	}

	public void deleteTypeUser(String id) {
		TypeUser typeuser = getTypeUser(id);
		if (null != typeuser) {
			getSession().delete(typeuser);
		}
	}
    
    private Session getSession() {
		Session sess = getSessionFactory().getCurrentSession();
		if (sess == null) {
			sess = getSessionFactory().openSession();
		}
		return sess;
	}

	private SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
