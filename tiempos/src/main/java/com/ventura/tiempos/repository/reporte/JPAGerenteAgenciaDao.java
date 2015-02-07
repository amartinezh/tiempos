package com.ventura.tiempos.repository.reporte;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ventura.tiempos.domain.reporte.Flash;

@Repository
public class JPAGerenteAgenciaDao implements GerenteAgenciaDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		List<Object[]> resultados = em.createQuery("SELECT f.cozon As cozon, f.codzbp As codzbp, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty FROM Flash as f WHERE "+ permisos.get(9).get(permisos.get(8).get("per"))+" and "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cozon, f.codzbp").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest: resultados) {
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], (BigDecimal)rest[2], (BigDecimal)rest[3], (BigDecimal)rest[4], (BigDecimal)rest[5], new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (BigDecimal)rest[7], (BigDecimal)rest[8]));
		}
		return resultadoss;
	}

}
