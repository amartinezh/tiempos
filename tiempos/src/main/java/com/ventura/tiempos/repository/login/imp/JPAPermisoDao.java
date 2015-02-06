package com.ventura.tiempos.repository.login.imp;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ventura.tiempos.domain.login.User;
import com.ventura.tiempos.repository.login.PermisoDao;

@Repository
public class JPAPermisoDao implements PermisoDao {
	
	private EntityManager em = null;

    /*
     * Sets the entity manager.
     */
    @PersistenceContext
    public void setEntityManager(EntityManager em) {
        this.em = em;
    }

    
	@Transactional(readOnly = true)  
    public List<Map<String,String>> getPermisos(User usuario) {    	
    	List<Map<String, String>> permisos = new LinkedList<Map<String,String>>();
    	@SuppressWarnings("unchecked")
		List<Object> resultados = em.createQuery("SELECT P.permiso as permiso FROM Permiso as P Where P.usuario = '" + usuario.getId() + "'").getResultList();
  //  	if(usuario.getTip_usuario().getDescripcion().equalsIgnoreCase("gerente general")) {
    	permisos.add(0, generarPermisos(usuario, "cocurr", resultados));
    //	} else if(usuario.getTip_usuario().getDescripcion().equalsIgnoreCase("gerente agencia")) {
    	//	permisos.add(0, generarPermisosMoneda(usuario, "cocurr"));
    	//}
    	Map<String, String> n = new HashMap<String, String>();
    	if(usuario.getComp().getDescripcion().equalsIgnoreCase("panasa") || usuario.getComp().getDescripcion().equalsIgnoreCase("todos")) {
    		n.put("pan", "f.cocia = 1");
    	}
    	if(usuario.getComp().getDescripcion().equalsIgnoreCase("iaasa") || usuario.getComp().getDescripcion().equalsIgnoreCase("todos")) {
    		n.put("iaa", "f.cocia = 2");
    	}
    	permisos.add(1, n);
    	if(usuario.getTip_usuario().getDescripcion().equalsIgnoreCase("gerente agencia")) {
    		permisos.add(2, generarPermisos(usuario, "cozon", resultados));
    	}    	
    	return permisos;
	}    
    
	@SuppressWarnings("unused")
	private Map<String, String> generarPermisos(User usuario, String campo, List<Object> resultados) {		
    	Map<String, String> n = new HashMap<String, String>();
    	String per = "";
    	for(Object rest : resultados) {
    		if(per.isEmpty()) {
    			rest = "f." + campo + " = " + rest;
    		} else {
    			rest = " or f." + campo + " = " + rest;
    		}
    	}
    	per = "(" + per + ")";
    	n.put("permisos", per);
    	return n;
    }
	
	@SuppressWarnings("unused")
	private Map<String, String> generarPermisosMoneda(User usuario, String campo) {		
    	Map<String, String> n = new HashMap<String, String>();
    	if(usuario.getLevel().getDescripcion().equalsIgnoreCase("nacional") || usuario.getLevel().getDescripcion().equalsIgnoreCase("todos")) {    		
    		n.put("nal", "f."+campo+" = 'COP'");
    	} 
    	if(usuario.getLevel().getDescripcion().equalsIgnoreCase("exportaciones") || usuario.getLevel().getDescripcion().equalsIgnoreCase("todos")) {
    		n.put("exp", "f."+campo+" = 'USD'");
    	}
    	return n;
    }
/*	
	@SuppressWarnings("unused")
	private Map<String, String> generarPermisos(User usuario, String campo, List<Object> resultados) {		
    	Map<String, String> n = new HashMap<String, String>();
    	if(usuario.getLevel().getDescripcion().equalsIgnoreCase("nacional") || usuario.getLevel().getDescripcion().equalsIgnoreCase("todos")) {
    		for(Object rest : resultados) {
    			if(String.valueOf(rest).equalsIgnoreCase("col")) {
    				n.put("nal", "f."+campo+" = 'COP'");
    			}    		
    		}
    	} 
    	if(usuario.getLevel().getDescripcion().equalsIgnoreCase("exportaciones") || usuario.getLevel().getDescripcion().equalsIgnoreCase("todos")) {
    		for(Object rest : resultados) {
    			if(String.valueOf(rest).equalsIgnoreCase("col")) {
    				n.put("exp", "f."+campo+" = 'USD'");    				
    			}
    		}    		
    	}
    	return n;
    }
*/
}
