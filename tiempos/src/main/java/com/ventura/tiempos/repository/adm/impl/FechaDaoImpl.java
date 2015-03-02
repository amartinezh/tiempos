package com.ventura.tiempos.repository.adm.impl;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.tiempos.domain.adm.Fecha;
import com.ventura.tiempos.domain.adm.TypeUser;
import com.ventura.tiempos.repository.adm.FechaDao;

@Repository
public class FechaDaoImpl implements FechaDao{

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional(readOnly = true)
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Fecha> getListFecha(Fecha fecha) {		
		List<Object[]>  list = em.createQuery("SELECT f "
				+ "FROM Fecha as f "
				+ "WHERE date_part('month', f.fecha) = "+fecha.getMes()+" and date_part('year', f.fecha) = "+fecha.getAno()).getResultList();
		List<Fecha> listaFecha = new LinkedList<Fecha>();
		for(Object[] obj : list) {
			listaFecha.add(new Fecha(new Date(obj[0].toString()), 0));
		}
		return listaFecha;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	@SuppressWarnings({ "unused", "deprecation", "unchecked" })	
	public void generarFecha(Fecha fecha) {
		//List<Object[]> resultados = em.createQuery("SELECT date_trunc('day', dd)::date as fecha FROM generate_series('"+fecha.getAno()+"/01/01'::timestamp, '"+fecha.getAno()+"/12/31'::timestamp, '1 day'::interval) dd").getResultList();
		//List<Object[]> resultados = em.createQuery("SELECT dd as fecha FROM generate_series('"+fecha.getAno()+"-01-01', '"+fecha.getAno()+"-12-31', '1 day'::interval) dd").getResultList();
		//Query q = em.createQuery("INSERT INTO adm.fechas(fecha, campo) SELECT dd as fecha, 0 as campo FROM generate_series('"+fecha.getAno()+"/01/01', '"+fecha.getAno()+"/12/31', '1 day'::interval) dd");
		//q.executeUpdate();
		SQLQuery q2 = (SQLQuery) em.createQuery("INSERT INTO adm.fechas(fecha, campo) SELECT dd as fecha, 0 as campo FROM generate_series('"+fecha.getAno()+"/01/01', '"+fecha.getAno()+"/12/31', '1 day'::interval) dd");
		q2.executeUpdate();
/*		
		for(Object[] obj: resultados) {
			Fecha fe  = em.find(Fecha.class, new Date(obj[0].toString()));
			if(fe == null) {
				em.persist(new Fecha(new Date(obj[0].toString()), 0));
			}
		}*/
	}
	
}
