package com.ventura.tiempos.web.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ventura.tiempos.domain.login.User;
import com.ventura.tiempos.service.login.UserManager;

@Controller
public class IndexController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private UserManager userManager;

	@RequestMapping(value = "/ingreso", method = RequestMethod.GET)
	public ModelAndView employee() {
		return new ModelAndView("key/index", "command", new User());
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute("SpringWeb")User user, ModelMap model) {
	  model.addAttribute("id", user.getId());
	  model.addAttribute("pass", user.getPass());
	  if (userManager.val(user.getId(), user.getPass()))
		  return "dashboard";
	  else
		  return "key/login";
	}

	public void setuserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

}
