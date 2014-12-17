package com.ventura.tiempos.repository.reporte;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.tiempos.domain.reporte.Flash;


@Repository
public class JPAFlashDao implements FlashDao{

	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashList() {		
		return em.createQuery("SELECT cozon as cozon, codzbp as codzbp, Sum(ckqty) As ckqty, sum(cpqty) as cpqyu, sum(clord) as clord, sum(cldev) as cldev, Sum(clnet) As clnet, sum(cpdte) as cpdte, sum(clqty) as clqty, sum(clqtyb) as clqtyb, sum(clnetb) as clnetb, sum(clnetc) as clnetc, codesz as codesz FROM Flash WHERE mes = 11 And ano = 2014 And cocia = 1 And cocurr = 'COP' GROUP BY cozon, codesz, codzbp ORDER BY codesz").getResultList();
	}
	
}
