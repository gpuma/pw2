package pw2.controllers;

import pw2.domain.*;
import pw2.model.Store;

import java.util.List;
import java.util.Arrays;
import java.util.Date;
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

		//TODO: llenando los reviews falsos
		cond.setReviews(Arrays.asList(
										new Review(1L, "muy amable", new Date()),
										new Review(2L, "lo peor", new Date()),
										new Review(3L, "lo recomiendo a todos", new Date())));
		Store.GuardarConductor(cond);

		return "redirect:/hola";
	}

	@RequestMapping("/")
	public String mostrarInicio(){
		//usa el ViewResolver
		return "inicio";
	}
}
