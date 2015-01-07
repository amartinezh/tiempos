package com.ventura.tiempos.repository.reporte;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ventura.tiempos.domain.reporte.Flash;

@Repository
public class JPAFlashDao implements FlashDao{

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	

	/*
	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	*/	
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashList() {	
	
		//List<Flash> resultados = em.createQuery("SELECT f.cozon, f.codzbp, Sum(f.ckqty), sum(f.cpqty), sum(f.clord), sum(f.cldev), Sum(f.clnet), sum(f.cpdte), sum(f.clqty), sum(f.clqtyb), sum(f.clnetb), sum(f.clnetc), f.codesz FROM Flash as f WHERE f.mes = 11 And f.ano = 2014 And f.cocia = 1 And f.cocurr = 'COP' GROUP BY f.cozon, f.codesz, f.codzbp ORDER BY f.codesz").getResultList();
		List<Object[]> resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, SUM(f.ckqty) As ckqty, SUM(f.cpqty) as cpqty, SUM(f.clord) as clord, sum(f.cldev) as cldev, SUM(f.clnet) As clnet, SUM(f.cpdte) as cpdte, SUM(f.clqty) as clqty, SUM(f.clqtyb) as clqtyb, SUM(f.clnetb) as clnetb, SUM(f.clnetc) as clnetc, f.codesz as codesz FROM Flash as f WHERE f.mes = 11 And f.ano = 2014 And f.cocia = 1 And f.cocurr = 'COP' GROUP BY f.cozon, f.codesz, f.codzbp ORDER BY f.codesz").getResultList();
		// List<Flash> resultados = em.createQuery("select f from Flash f order by f.codzbp").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest: resultados) {			
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], (BigDecimal)rest[2], (BigDecimal)rest[3], (BigDecimal)rest[4], (BigDecimal)rest[5], (BigDecimal)rest[6], (BigDecimal)rest[7], (BigDecimal)rest[8], (BigDecimal)rest[9], (BigDecimal)rest[10], (BigDecimal)rest[11], (String)rest[12]));
		}
		return resultadoss;
		
		//return getSession().createSQLQuery("select f from Flash f order by f.codzbp").list();
	}
	
}
