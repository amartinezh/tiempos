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
			resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, SUM(f.ckqty) As ckqty, SUM(f.cpqty) as cpqty, SUM(f.clord) as clord, sum(f.cldev) as cldev, SUM(f.clnet) As clnet, SUM(f.cpdte) as cpdte, SUM(f.clqty) as clqty, SUM(f.clqtyb) as clqtyb, SUM(f.clnetb) as clnetb, SUM(f.clnetc) as clnetc, f.codesz as codesz, AVG(f.clcar) as clcar"
					+ "FROM Flash as f "
					+ "WHERE "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " "
					+ "GROUP BY f.cozon, f.codesz, f.codzbp "
					+ "ORDER BY f.codesz").getResultList();
	/*	} else {
			resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, SUM(f.ckqty) As ckqty, SUM(f.cpqty) as cpqty, SUM(f.clord) as clord, sum(f.cldev) as cldev, SUM(f.clnet) As clnet, SUM(f.cpdte) as cpdte, SUM(f.clqty) as clqty, SUM(f.clqtyb) as clqtyb, SUM(f.clnetb) as clnetb, SUM(f.clnetc) as clnetc, f.codesz as codesz FROM Flash_h as f WHERE "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cozon, f.codesz, f.codzbp ORDER BY f.codesz").getResultList();
		}*/
		List<Flash> resultadoss = new LinkedList<Flash>();
		String z = "";
		//Flash total = new Flash("c", "TOTAL");
		Flash total = new Flash("c", "", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), "TOTAL", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN));
		Flash sumador = null;
		for(Object[] rest: resultados) {
			if(!rest[12].toString().isEmpty() && z.isEmpty()) {
				z = rest[12].toString().toUpperCase();
				resultadoss.add(new Flash("a", z));
				sumador = new Flash("b", "", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), z, new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN)); 
			} else if(!z.equalsIgnoreCase(rest[12].toString())) {
				//resultadoss.add(new Flash("b", resultadoss.get(resultadoss.size()-1).getCodesz(), new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[9].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[10].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[11].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), resultadoss.get(resultadoss.size()-1).getCodesz()));
				resultadoss.add(sumador);
				z = rest[12].toString().toUpperCase();
				resultadoss.add(new Flash("a", z));
				sumador = new Flash("b", "", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), z, new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN));
			}		
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[9].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[10].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[11].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)rest[12], new BigDecimal(rest[13].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
			total.sumarValores(resultadoss.get(resultadoss.size()-1));
			sumador.sumarValores(resultadoss.get(resultadoss.size()-1));
		}
		if(resultadoss.size()> 0) {
			resultadoss.add(sumador);
		}
		resultadoss.add(total);
		return resultadoss;
	}

	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListCanal(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.cotype as cotype, f.cotypedesc as cotypedesc, Sum(f.ckqty) As ckqty, sum(f.clord) as clord, sum(f.cldev) as cldev, sum(f.cpqty) as cpqty, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty, avg(f.clcar) as clcar FROM Flash as f WHERE "+permisos.get(7).get("condicioncanal")+" and "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" And " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cotype, f.cotypedesc").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		Flash total = new Flash("c", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), "TOTAL", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN));
		for(Object[] rest: resultados) {			
			resultadoss.add(new Flash((String)rest[0], new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)rest[1], new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[9].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
			total.sumarValoresCanal(resultadoss.get(resultadoss.size()-1));
		}
		resultadoss.add(total);
		return resultadoss;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListDistrito(List<Map<String, String>> permisos) {
		List<Object[]> resultados;		
		resultados = em.createQuery("SELECT f.cozon as cozon, f.codzbp as codzbp, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty, avg(f.clcar) as clcar FROM Flash as f WHERE "+permisos.get(7).get("condicionaldistitoc")+" and "+permisos.get(7).get("condicionaldistito")+" and "+permisos.get(7).get(permisos.get(8).get("messel"))+" And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" And "+ permisos.get(5).get(permisos.get(8).get("compa")) +" and " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cozon, f.codzbp").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		Flash total = new Flash("c", "TOTAL", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN));
		for(Object[] rest: resultados) {			
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[9].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
			total.sumarValoresCanal(resultadoss.get(resultadoss.size()-1));
		}
		resultadoss.add(total);
		return resultadoss;
	}

	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListItem(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.coprod as coprod, f.codesb as codesb, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty, f.codesz as codesz FROM Flash as f WHERE " + permisos.get(7).get("condicionitem") + " and "+permisos.get(7).get(permisos.get(8).get("messel"))+" and "+permisos.get(6).get(permisos.get(8).get("anosel"))+" and "+ permisos.get(5).get(permisos.get(8).get("compa")) +" and " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.coprod, f.codesb, f.codesz").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest: resultados) {			
			resultadoss.add(new Flash((String)rest[0], (String)rest[1], new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)rest[9]));
		}
		return resultadoss;
	}

	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListCliente(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.coccus as coccus, f.concus as concus, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty, f.codesz, avg(f.clcar) as clcar FROM Flash as f WHERE " + permisos.get(7).get("condicioncliente") + " and "+permisos.get(7).get(permisos.get(8).get("messel"))+" and "+permisos.get(6).get(permisos.get(8).get("anosel"))+" and "+ permisos.get(5).get(permisos.get(8).get("compa")) +" and " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.coccus, f.concus, f.codesz").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		Flash total = new Flash(new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), "TOTAL", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN),  new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN), "c", new BigDecimal(0).setScale(0, BigDecimal.ROUND_HALF_EVEN));
		for(Object[] rest: resultados) {
			resultadoss.add(new Flash(new BigDecimal(rest[0].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)(rest[1]), new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)rest[9], new BigDecimal(rest[10].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
			total.sumarValoresCanal(resultadoss.get(resultadoss.size()-1));
		}
		resultadoss.add(total);
		return resultadoss;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListTipoMarca(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.codestm as codestm, Sum(f.ckqty) As ckqty, sum(f.clord) as clord, sum(f.cpqty) as cpqty, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty, f.codesz as codesz FROM Flash as f WHERE f.cozon = '918' and f.codes04 = 'HIGIENICO TIPO A' and f.mes = 11 And "+permisos.get(6).get(permisos.get(8).get("anosel"))+" and "+ permisos.get(5).get(permisos.get(8).get("compa")) +" and " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.codestm, f.codesz").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest : resultados) {
			resultadoss.add(new Flash(new BigDecimal(rest[1].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)(rest[8]), (String)(rest[0])));
		}
		return resultadoss;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListCategoria(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.codes04 as codes04, Sum(f.ckqty) as ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty, f.codesz as codesz FROM Flash as f WHERE " + permisos.get(7).get("condicioncategorias") + " and "+permisos.get(7).get(permisos.get(8).get("messel"))+" and "+permisos.get(6).get(permisos.get(8).get("anosel"))+" and "+ permisos.get(5).get(permisos.get(8).get("compa")) + " and " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.codes04, f.codesz").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest : resultados) {
			resultadoss.add(new Flash((String)(rest[0]), new BigDecimal(rest[1].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)(rest[8])));
		}
		return resultadoss;
	}
	
	@SuppressWarnings("unchecked")
	public List<Flash> getFlashListVendedor(List<Map<String, String>> permisos) {
		List<Object[]> resultados;
		resultados = em.createQuery("SELECT f.cosal as cosal, f.coname as coname, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty FROM flash_pn as f WHERE " + permisos.get(7).get("condicionvendedores") + " and "+permisos.get(7).get(permisos.get(8).get("messel"))+" and "+permisos.get(6).get(permisos.get(8).get("anosel"))+" and "+ permisos.get(5).get(permisos.get(8).get("compa")) +" and " + permisos.get(4).get(permisos.get(8).get("nivel")) + " GROUP BY f.cosal, f.coname").getResultList();
		List<Flash> resultadoss = new LinkedList<Flash>();
		for(Object[] rest : resultados) {
			resultadoss.add(new Flash(new BigDecimal(rest[0].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), (String)(rest[1]), new BigDecimal(rest[2].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[3].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[4].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[5].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[6].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[7].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN), new BigDecimal(rest[8].toString()).setScale(0, BigDecimal.ROUND_HALF_EVEN)));
		}
		return resultadoss;
	}
}
