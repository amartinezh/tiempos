package com.ventura.tiempos.web.reporte;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.ventura.tiempos.service.reporte.FlashManagerService;
import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.domain.session.session;


@Controller
@RequestMapping(value="/flash")
@SessionAttributes({"user_inicio"})
public class FlashController {
		
	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private FlashManagerService flashManagerService;
	
	@RequestMapping(value = "/info", method = RequestMethod.GET)
	public String lanzar(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("flash", new Flash());
			model.addAttribute("flash1ist", flashManagerService.getFlashList(ses.getPermisos()));
			model.addAttribute("usuarioactuall", ses.getUsuario());
			if(((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).get("nivel").equalsIgnoreCase("exp")) {
				model.addAttribute("mostrar", 1);
			} else {
				model.addAttribute("mostrar", 0);
			}
			return "dashboard";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/canal", method = RequestMethod.GET)
	public String lanzar1(Model model) {		
		if(model.containsAttribute("user_inicio") == true) {			
			model.addAttribute("devolvercanal", "info");
			session ses = (session)(model.asMap().get("user_inicio"));			
			model.addAttribute("flash1ist", flashManagerService.getFlashListCanal(ses.getPermisos()));
			model.addAttribute("usuarioactuall", ses.getUsuario());
			return "reportes/canal";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/distrito", method = RequestMethod.GET)
	public String distrito(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("devolverdistrit", "canal");
			session ses = (session)(model.asMap().get("user_inicio"));			
			model.addAttribute("flash1ist", flashManagerService.getFlashListDistrito(ses.getPermisos()));
			model.addAttribute("usuarioactuall", ses.getUsuario());
			return "reportes/distrito";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/items", method = RequestMethod.GET)
	public String items(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("devolveritems", "info");			
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("flash1ist", flashManagerService.getFlashListItem(ses.getPermisos()));
			model.addAttribute("usuarioactuall", ses.getUsuario());
			return "reportes/items";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public String clientes(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("devolvercliente", "info");
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("flash1ist", flashManagerService.getFlashListCliente(ses.getPermisos()));
			return "reportes/clientes";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/marca", method = RequestMethod.GET)
	public String marcas(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("devolvermarca", "info");
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("flash1ist", flashManagerService.getFlashListTipoMarca(ses.getPermisos()));
			return "reportes/marca";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/categoria", method = RequestMethod.GET)
	public String categorias(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("devolvercategoria", "info");
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("flash1ist", flashManagerService.getFlashListCategoria(ses.getPermisos()));
			return "reportes/categorias";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/vendedor", method = RequestMethod.GET)
	public String vendedores(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("devolvervendedor", "info");
			session ses = (session)(model.asMap().get("user_inicio"));
			model.addAttribute("flash1ist", flashManagerService.getFlashListVendedor(ses.getPermisos()));
			return "reportes/categorias";		
		} else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/d/{cotype}")
	public String getDistrito(@PathVariable int cotype, Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			session ses = (session)(model.asMap().get("user_inicio"));
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicionaldistito", "f.cotype = '"+cotype+"'");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicionaldistitoc", ses.getPermisos().get(7).get("condicioncanal"));
			return "redirect:/flash/distrito";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/c/{cozon}")
	public String getCanal(@PathVariable int cozon, Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicioncanal", "f.cozon = '"+cozon+"'");			
			return "redirect:/flash/canal";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/cd/{cozon}")
	public String getCanalDistrito(@PathVariable int cozon, @PathVariable int cotype, Model model) {
		if(model.containsAttribute("user_inicio") == true) {			
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("canal", "f.cozon = '"+cozon+"'");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("distito", "f.cotype = '"+cotype+"'");
			return "redirect:/flash/canal";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/i/{cozon}")
	public String getItems(@PathVariable int cozon, Model model) {
		if(model.containsAttribute("user_inicio") == true) {			
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicionitem", "f.cozon = '"+cozon+"'");			
			return "redirect:/flash/items";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/cli/{cozon}")
	public String getClientes(@PathVariable int cozon, Model model) {
		if(model.containsAttribute("user_inicio") == true) {			
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicioncliente", "f.cozon = '"+cozon+"'");			
			return "redirect:/flash/cliente";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/m/{cozon}")
	public String getMarca(@PathVariable int cozon, Model model) {
		if(model.containsAttribute("user_inicio") == true) {			
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicionmarca", "f.cozon = '"+cozon+"'");			
			return "redirect:/flash/marca";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/cat/{cozon}")
	public String getCategoria(@PathVariable int cozon, Model model) {
		if(model.containsAttribute("user_inicio") == true) {			
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicioncategorias", "f.cozon = '"+cozon+"'");			
			return "redirect:/flash/categoria";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping("/v/{cozon}")
	public String getVendedor(@PathVariable int cozon, Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(7).put("condicionvendedores", "f.cozon = '"+cozon+"'");			
			return "redirect:/flash/vendedor";
		}else {
			return "redirect:/index/ingreso";
		}
	}
	
	@RequestMapping(value = "/actualizar", method = RequestMethod.GET)
	public String actualizar(Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			model.addAttribute("redireccion", "info");
			model.addAttribute("accion", "generar");
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
	
	@RequestMapping(value = "/generar", method = RequestMethod.POST)
	public String generaar(@ModelAttribute("flash") Flash flash, Model model) {
		if(model.containsAttribute("user_inicio") == true) {
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("messel", flash.getMes()+"");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("anosel", flash.getAno()+"");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("compa", flash.getCocia()+"");
			((session)(model.asMap().get("user_inicio"))).getPermisos().get(8).put("nivel", flash.getCocurr()+"");
			return "redirect:/flash/info";
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
