package com.ventura.tiempos.web.reporte;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventura.tiempos.service.reporte.FlashManager;
import com.ventura.tiempos.service.reporte.SimpleFlashManager;
import com.ventura.tiempos.domain.reporte.Flash;


@Controller
@RequestMapping(value="/flash")
public class FlashController {
		
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private FlashManager flashManager;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String lanzar(Map<String, Object> model) {
		model.put("flash", new SimpleFlashManager().getFlashList());
		return "dashboard";
	}
		
	public void setFlashManager(FlashManager flashManager) {
		this.flashManager = flashManager;
	}
	
}
