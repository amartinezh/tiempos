package com.ventura.tiempos.repository.adm.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.tiempos.domain.adm.TypeUser;
import com.ventura.tiempos.repository.adm.TypeUserDao;

@Repository
public class TypeUserDaoImpl implements TypeUserDao{

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<TypeUser> listTypeUser() {		
		List<Object[]> resultados = em.createQuery("SELECT U.id, U.descripcion FROM TypeUser as U ORDER BY U.id").getResultList();
		List<TypeUser> list = new LinkedList<TypeUser>();
		for (Object[] obj : resultados) {
			list.add(new TypeUser(Integer.parseInt(obj[0].toString()), obj[1].toString()));
		} 
		return list;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveTypeUser(TypeUser typeuser) {
		em.persist(typeuser);
	}
    
	/*
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
	*/
}
