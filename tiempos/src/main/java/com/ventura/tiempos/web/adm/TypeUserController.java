package com.ventura.tiempos.web.adm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ventura.tiempos.domain.adm.TypeUser;
import com.ventura.tiempos.service.adm.TypeUserService;

@Controller
@RequestMapping("/typeuser")
public class TypeUserController {
	@Autowired
	private TypeUserService typeuserService;
	
	@RequestMapping(value = { "/", "/listTypeUser" })
	public String listTypeUsers(Map<String, Object> map) {
		map.put("typeuser", new TypeUser());
		map.put("typeuserList", typeuserService.listTypeUser());
		return "/typeuser/listTypeUser";
	}
	
	@RequestMapping("/get/{typeuserId}")
	public String getTypeUser(@PathVariable String typeuserId, Map<String, Object> map) {
		TypeUser typeuser = typeuserService.getTypeUser(typeuserId);
		map.put("typeuser", typeuser);
		return "/typeuser/typeuserForm";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveTypeUser(@ModelAttribute("typeuser") TypeUser typeuser,
			BindingResult result) {
		typeuserService.saveTypeUser(typeuser);
		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:views/listTypeUsers";
	}
	
	@RequestMapping("/delete/{typeuserId}")
	public String deleteTypeUser(@PathVariable("typeuserId") String id) {
		typeuserService.deleteTypeUser(id);
		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listTypeUsers";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/views/typeuser/listTypeUsers";
	}
}	
