package com.ventura.tiempos.web.reporte;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventura.tiempos.service.reporte.FlashManagerService;
import com.ventura.tiempos.service.reporte.impl.SimpleFlashManagerService;
import com.ventura.tiempos.domain.reporte.Flash;


@Controller
@RequestMapping(value="/flash")
public class FlashController {
		
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private FlashManagerService flashManagerService;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String lanzar(Map<String, Object> model) {
		List<Flash> l = new LinkedList<Flash>();
		model.put("flash", new Flash());
		model.put("flash1ist", flashManagerService.getFlashList());
		return "dashboard";
	}
	
	@RequestMapping(value = "/salir", method = RequestMethod.GET)
	public String salir(Map<String, Object> model) {
		return "redirect:/index/ingreso";
	}

}
