package pw2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HolaController{
	@RequestMapping("/hola")
	public String mostrarHola(){
		//usa el ViewResolver
		return "hola";
	}
	@RequestMapping("/")
	public String mostrarInicio(){
		//usa el ViewResolver
		return "inicio";
	}

	@RequestMapping("/prueba")
	public String mostrarRecurso(){
		//usa el ViewResolver
		return "/WEB-INF/prueba.html";
	}
}