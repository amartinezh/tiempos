package com.ventura.tiempos.web.reporte.institucional;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.domain.session.session;
import com.ventura.tiempos.service.reporte.InstitucionalService;

@Controller
@RequestMapping(value="/institucional")
@SessionAttributes({"user_inicio"})
public class InstitucionalController {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private InstitucionalService institucionalService;
	
	@RequestMapping(value = "/datos", method = RequestMethod.GET)
	public String lanzar(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			session ses = (session)(model.asMap().get("user_inicio"));
			List<Flash> l = new LinkedList<Flash>();
			model.addAttribute("flash", new Flash());
			model.addAttribute("flash1ist", institucionalService.getFlashList(ses.getPermisos()));
			return "vendedor";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/refrescar", method = RequestMethod.GET)
	public String actualizar(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("redireccion", "datos");
			model.addAttribute("accion", "ver");
			model.addAttribute("flash", new Flash());
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("comps", ses.getPermisos().get(0));
			model.addAttribute("nivs", ses.getPermisos().get(1));
			model.addAttribute("anos", ses.getPermisos().get(2));
			model.addAttribute("meses", ses.getPermisos().get(3));
			return "actualizar";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/ver", method = RequestMethod.POST)
	public String generaar(@ModelAttribute("flash") Flash flash, Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("messel", flash.getMes()+"");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("anosel", flash.getAno()+"");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("compa", flash.getCocia()+"");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("nivel", flash.getCocurr()+"");
			return "redirect:/agencia/reporte";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Model model,  SessionStatus status) {		 
		status.setComplete();
		return "redirect:/index/ingreso";
	}

}
