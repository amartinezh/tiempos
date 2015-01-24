package com.ventura.tiempos.web.reporte.vendedor;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventura.tiempos.service.reporte.FlashManagerService;
import com.ventura.tiempos.service.reporte.VendedorService;
import com.ventura.tiempos.domain.reporte.Flash;

@Controller
@RequestMapping(value="/vendedor")
public class VendedorController {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private VendedorService vendedorService;
	
	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String lanzar(Map<String, Object> model) {
		return "dashboard";
	}

}
