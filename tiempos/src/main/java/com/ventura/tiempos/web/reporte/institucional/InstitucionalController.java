package com.ventura.tiempos.web.reporte.institucional;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/institucional")
public class InstitucionalController {
	
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@RequestMapping(value = "/datos", method = RequestMethod.GET)
	public String lanzar(Map<String, Object> model) {
		return "dashboard";
	}

}
