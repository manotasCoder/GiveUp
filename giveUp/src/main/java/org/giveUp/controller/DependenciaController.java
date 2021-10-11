package org.giveUp.controller;

import java.util.List;

import org.giveUp.domain.Dependencia;
import org.giveUp.repositories.RepositoryDependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/dependencia")
public class DependenciaController {

	@Autowired
	private RepositoryDependencia repoDependencia;
	
	
	@GetMapping("/")
	public String read(ModelMap m) {
		List<Dependencia> dependencias = repoDependencia.findAll();
		m.put("dependencias", dependencias);
		m.put("view", "/view/dependencia/read");
		return "/_t/frame";
	}
	
	@GetMapping("/crear")
	public String crear(ModelMap m) {
		m.put("view", "/view/dependencia/crear");
		return "/_t/frame";
	}
	
	@PostMapping("/crear")
	public String crear(
			@RequestParam("nombre") String nombre,
			@RequestParam("descripcion") String descripcion
			) {
		String route = "/dependencia";
		
		try {
			Dependencia dependencia = new Dependencia(nombre, descripcion);
			repoDependencia.save(dependencia);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/";
		
	}
	
	
}
