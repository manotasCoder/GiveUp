package org.giveUp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

	/**
	 * @author ruben.
	 * 
	 * Clase anónima sin login.
	 * <p>
	 * Esta clase se basa en proporcionar las páginas que se puede acceder sin estar logeado.
	 *
	 *</p>
	 *
	 *@version 1.0
	 *
	 */

@Controller
public class AnonymousController {
	
	/**
	 * Este método instancia la pagina principal del proyecto.
	 * 
	 * @param ModelMap este parámetro se rellena en su instanciación con el destino del mismo.
	 * @return String devuelve el nombre del archivo a cargar
	 *
	 */
	
	@GetMapping("/")
	public String home(ModelMap m) {
		m.put("view", "/view/home");
		return "/_t/frame";
	}
}
