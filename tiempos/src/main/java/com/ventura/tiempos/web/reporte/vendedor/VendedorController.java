package com.ventura.tiempos.web.reporte.vendedor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ventura.tiempos.service.reporte.FlashManagerService;
import com.ventura.tiempos.service.reporte.VendedorService;
import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.domain.session.session;

@Controller
@RequestMapping(value="/vendedor")
@SessionAttributes({"user_inicio"})
public class VendedorController {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private VendedorService vendedorService;
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String lanzar(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			session ses = (session)(model.asMap().get("user_inicio"));
			List<Flash> l = new LinkedList<Flash>();
			model.addAttribute("flash", new Flash());
			model.addAttribute("flash1ist", vendedorService.getFlashList(ses.getPermisos()));
			return "institucional";		
		} else {
			return "redirect:/index/ingreso";
		}
	}

}
