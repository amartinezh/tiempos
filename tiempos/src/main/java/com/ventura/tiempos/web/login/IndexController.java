package com.ventura.tiempos.web.login;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ventura.tiempos.domain.login.User;
import com.ventura.tiempos.domain.reporte.Flash;
import com.ventura.tiempos.service.login.UserManager;
import com.ventura.tiempos.service.reporte.FlashManagerService;
import com.ventura.tiempos.service.reporte.impl.SimpleFlashManagerService;

@Controller
@RequestMapping(value="/index")
public class IndexController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager userManager;
		
	@RequestMapping(value = "/ingreso", method = RequestMethod.GET)
	public String employee(Map<String, Object> model) {
		model.put("user", new User());
		return "key/index";
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	public String addEmployee(@Valid @ModelAttribute("user") User user, BindingResult result, Map<String, Object> model) {
	  if (result.hasErrors()) {
		  return "key/index";
	  } else {
		  model.put("id", user.getId());
	//	  model.put("pass", user.getPass());
		  if (userManager.val(user.getId(), user.getPass())) {
			  return "key/entrar";
		  } else {
			  model.put("msg", "<script type=\"text/javascript\">$( window ).load(function() { adv(); }); </script>");
			  return "key/index";
		  }
	  }
	}

	public void setuserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}
			
}
