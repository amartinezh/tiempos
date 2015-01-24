package com.ventura.tiempos.web.reporte.gerente_agencia;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventura.tiempos.repository.reporte.GerenteAgenciaDao;
import com.ventura.tiempos.service.reporte.FlashManagerService;
import com.ventura.tiempos.service.reporte.GerenteAgenciaService;

@Controller
@RequestMapping(value="/vendedor")
public class GerenteAController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private GerenteAgenciaService gerenteAgenciaService;
	
	@RequestMapping(value = "/reporte", method = RequestMethod.GET)
	public String lanzar(Map<String, Object> model) {
		return "dashboard";
	}
	
}
