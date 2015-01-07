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
@RequestMapping(value="/tipousuario")
public class TypeUserController {
	@Autowired
	private TypeUserService typeuserService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String listTypeUsers(Map<String, Object> map) {
		map.put("typeuser", new TypeUser());
		map.put("typeuserList", typeuserService.listTypeUser());
		return "/tipousuario/listatipousuario";
	}
	
	@RequestMapping("/get/{Id}")
	public String getBook(@PathVariable String Id, Map<String, Object> map) {

		TypeUser book = typeuserService.getTypeUser(Id);

		map.put("book", book);

		return "/tipousuario/tuForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute("book") TypeUser tu,
			BindingResult result) {

		typeuserService.saveTypeUser(tu);;

		/*
		 * Note that there is no slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the current path
		 */
		return "redirect:listatipousuario";
	}

	@RequestMapping("/delete/{Id}")
	public String deleteBook(@PathVariable("Id") String id) {

		typeuserService.deleteTypeUser(id);

		/*
		 * redirects to the path relative to the current path
		 */
		// return "redirect:../listBooks";

		/*
		 * Note that there is the slash "/" right after "redirect:" So, it
		 * redirects to the path relative to the project root path
		 */
		return "redirect:/tipousuario/ltipou";
	}
}	
