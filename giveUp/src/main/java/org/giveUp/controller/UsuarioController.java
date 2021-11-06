package org.giveUp.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.giveUp.domain.Dependencia;
import org.giveUp.domain.Usuario;
import org.giveUp.domain.UsuarioDependencia;
import org.giveUp.repositories.RepositoryDependencia;
import org.giveUp.repositories.RepositoryUsuario;
import org.giveUp.repositories.RepositoryUsuarioDependencia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/usuario")
public class UsuarioController {

	@Autowired
	private RepositoryUsuario repoUsuario;
	
	@Autowired
	private RepositoryDependencia repoDependencia;
	
	@Autowired
	private RepositoryUsuarioDependencia repoUsuarioDependencia;
	
	@GetMapping("/crear")
	public String crear(ModelMap m) {
		List<Dependencia> dependencias = repoDependencia.findAll();
		m.put("dependencias", dependencias);
		
		m.put("view", "/view/usuario/crear");
		return "/_t/frame";
	}
	
	@PostMapping("/crear")
	public String crear(
			@RequestParam("nombre") String nombre,
			@RequestParam("nick")String nick,
			@RequestParam("pwd")String pwd,
			@RequestParam("email")String email,
			@RequestParam(value = "dependencias", required=false)List<Long> dependencias,
			ModelMap m
			) {
		String route = "/usuario";
		
		try {
			Usuario usuario = new Usuario(nombre, nick, pwd, email);
			if (dependencias == null) {
				new ArrayList<Long>();
			}
			for (Long idDependencia : dependencias) {
				Dependencia dependencia = repoDependencia.getById(idDependencia);
				System.out.println(dependencia.toString());
				UsuarioDependencia usuDep = new UsuarioDependencia(usuario, dependencia);
				repoUsuarioDependencia.save(usuDep);
//				dependencia.getDependientes().add(usuario);
//				usuario.getDependencias().add(dependencia);
				
//				Date now = new Date();
//				Collection<Date> tiempos = dependencia.getTiempos();
//				tiempos.add(now);
//				dependencia.getTiempos().add(now);
//				Collection<Integer> veces= usuario.getVeces();
//				int empieza = 0;
//				veces.add(empieza);
//				usuario.getVeces().add(veces);
			}
			
		} catch (Exception e) {
			System.out.println("error en crear persona");		}
		return "redirect:/";
		
	}
	
}
