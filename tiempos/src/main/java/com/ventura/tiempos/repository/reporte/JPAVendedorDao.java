package com.ventura.tiempos.repository.reporte;

import java.util.List;

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
	
	public List<Flash> getFlashList() {
		// TODO Auto-generated method stub
		
		//SELECT f.cosal, f.coname, Sum(f.ckqty) As ckqty, sum(f.cpqty) as cpqty, sum(f.clord) as clord, sum(f.cldev) as cldev, Sum(f.clnet) As clnet, sum(f.cpdte) as cpdte, sum(f.clqty) as clqty FROM flash_pn As f WHERE (f.coname = 'MIX  TRUJILLO CONTRERAS CINDY' ) and f.mes = 11 And f.ano = 2014 And f.cocia = 1 And f.cocurr = 'COP' GROUP BY f.cosal, f.coname
		return null;
	}
	
}
