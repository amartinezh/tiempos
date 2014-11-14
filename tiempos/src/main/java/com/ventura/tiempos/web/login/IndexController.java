package com.ventura.tiempos.web.login;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
	public ModelAndView login() {
		return new ModelAndView("key/index", "command", new User());
	}
	
	@RequestMapping(value = "/ingreso", method = RequestMethod.POST)
	public ModelAndView addEmployee(@Valid @ModelAttribute("login") User user, BindingResult result, ModelMap model) {
	  model.addAttribute("id", user.getId());
	  model.addAttribute("pass", user.getPass());
	  
	  if (result.hasErrors()) {
		  return new ModelAndView("key/index", "command", new User());
	  }

	  if (userManager.val(user.getId(), user.getPass()))
		  return new ModelAndView("dashboard");
	  else
		  return new ModelAndView("key/login");
	}

	public void setuserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

}
