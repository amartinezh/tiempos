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
public class JPAVendedorDao implements VendedorDao {

	@PersistenceContext
	private EntityManager em = null;

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	public List<Flash> getFlashList(List<Map<String, String>> permisos) {
		@SuppressWarnings("unchecked")
		List<Object[]> resultados = em.createQuery("SELECT f.cosal, f.coname, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty FROM flash_pn As f WHERE (f.coname = 'MIX  TRUJILLO CONTRERAS CINDY' ) and f.mes = 11 And f.ano = 2014 And f.cocia = 1 And f.cocurr = 'COP' GROUP BY f.cosal, f.coname").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest: resultados) {
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], (BigDecimal)rest[2], (BigDecimal)rest[3], (BigDecimal)rest[4], (BigDecimal)rest[5], new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (BigDecimal)rest[7], (BigDecimal)rest[8], new BigDecimal(0)));
		}
		return resultadoss;
	}
	
}
