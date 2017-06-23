package pw2.controllers;

import pw2.domain.Conductor;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HolaController{
	@RequestMapping("/hola")
	public String mostrarHola(){
		//usa el ViewResolver
		return "hola";
	}
	@RequestMapping("/nuevo")
	public String IngresarConductor(Model model){
		model.addAttribute("cond", new Conductor());
		return "nuevo";
	}

	@RequestMapping("/registrar")
	public String RegistrarConductor(@ModelAttribute Conductor cond){
		System.out.println(cond.getUsuario());
		System.out.println(cond.getTelefono());
		System.out.println(cond.getFecNac());
		return "hola";
	}

	@RequestMapping("/")
	public String mostrarInicio(){
		//usa el ViewResolver
		return "inicio";
	}
}
