package com.ventura.tiempos.web.adm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventura.tiempos.domain.adm.Fecha;
import com.ventura.tiempos.service.adm.FechaService;

@Controller
@RequestMapping(value="/fechas")
public class FechaController {
	
	@Autowired
	private FechaService fechaService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listTypeUsers(Map<String, Object> map) {
		map.put("fecha", new Fecha());
		//map.put("typeuserList", typeuserService.listTypeUser());
		return "/fecha/listafecha";
	}
	
	@RequestMapping(value = "/generar", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("fecha") Fecha fe, BindingResult result) {
		fechaService.generarFecha(fe);
		return "redirect:/fechas";
	}

}
