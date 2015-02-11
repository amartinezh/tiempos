package com.ventura.tiempos.repository.reporte;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

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
	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
	//	if(permisos.get(8).get("anosel").equalsIgnoreCase(permisos.get(8).get("anoact")) && permisos.get(8).get("messel").equalsIgnoreCase(permisos.get(8).get("mesact"))) {
			resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, SUM(f.ckqty) As ckqty, SUM(f.cpqty) as cpqty, SUM(f.clord) as clord, sum(f.cldev) as cldev, SUM(f.clnet) As clnet, SUM(f.cpdte) as cpdte, SUM(f.clqty) as clqty, SUM(f.clqtyb) as clqtyb, SUM(f.clnetb) as clnetb, SUM(f.clnetc) as clnetc, f.codesz as codesz FROM Flash as f WHERE "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cozon, f.codesz, f.codzbp ORDER BY f.codesz").getResultList();
	/*	} else {
			resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, SUM(f.ckqty) As ckqty, SUM(f.cpqty) as cpqty, SUM(f.clord) as clord, sum(f.cldev) as cldev, SUM(f.clnet) As clnet, SUM(f.cpdte) as cpdte, SUM(f.clqty) as clqty, SUM(f.clqtyb) as clqtyb, SUM(f.clnetb) as clnetb, SUM(f.clnetc) as clnetc, f.codesz as codesz FROM Flash_h as f WHERE "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cozon, f.codesz, f.codzbp ORDER BY f.codesz").getResultList();
		}*/
		List<Flash> resultadoss = new LinkedList<Flash>();
		String z = "";
		for(Object[] rest: resultados) {
			if(resultadoss.size() > 0 && !resultadoss.get(resultadoss.size()-1).getCodesz().equalsIgnoreCase(rest[12].toString())) {
				resultadoss.add(new Flash("000", resultadoss.get(resultadoss.size()-1).getCodesz(), (BigDecimal)rest[2], (BigDecimal)rest[3], (BigDecimal)rest[4], (BigDecimal)rest[5], new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (BigDecimal)rest[7], (BigDecimal)rest[8], (BigDecimal)rest[9], (BigDecimal)rest[10], (BigDecimal)rest[11], resultadoss.get(resultadoss.size()-1).getCodesz()));
			}		
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], (BigDecimal)rest[2], (BigDecimal)rest[3], (BigDecimal)rest[4], (BigDecimal)rest[5], new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (BigDecimal)rest[7], (BigDecimal)rest[8], (BigDecimal)rest[9], (BigDecimal)rest[10], (BigDecimal)rest[11], (String)rest[12]));
		}
		if(resultadoss.size()> 0) {
			resultadoss.add(new Flash("000", resultadoss.get(resultadoss.size()-1).getCodesz(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCkqty(), resultadoss.get(resultadoss.size()-1).getCodesz()));
		}
		return resultadoss;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListCanal(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.cotype as cotype, f.cotypedesc as cotypedesc, Sum(f.ckqty) As ckqty, sum(f.clord) as clord, sum(f.cldev) as cldev, sum(f.cpqty) as cpqty, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty FROM Flash as f WHERE "+permisos.get(7).get("canal")+" and "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cotype, f.cotypedesc").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest: resultados) {			
			resultadoss.add(new Flash((String)rest[0], (BigDecimal)rest[8], (String)rest[1], new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
		}
		return resultadoss;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListDistrito(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty FROM Flash as f WHERE "+permisos.get(7).get("canal")+" and "+permisos.get(7).get("cotype")+" and "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cozon, f.codzbp").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest: resultados) {			
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
		}
		return resultadoss;
	}

	public List<Flash> getFlashListItem(List<Map<String, String>> permisos) {
		// TODO Auto-generated method stub
		return null;
	}
}
