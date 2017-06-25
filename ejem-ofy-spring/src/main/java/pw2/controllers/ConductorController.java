package pw2.controllers;

import pw2.domain.*;
import pw2.model.Store;

import java.util.List;
import java.util.Arrays;
import java.util.Date;
import java.io.IOException;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

//para subir archivos
import org.springframework.web.multipart.MultipartFile;
//para pasar atributos en un redirect
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ConductorController{

	@RequestMapping("/conductores/nuevo")
	public String IngresarConductor(Model model){
		model.addAttribute("cond", new Conductor());
		return "nuevo";
	}

	@RequestMapping("/conductores/registrar")
	public String RegistrarConductor(@ModelAttribute Conductor cond,
																		@RequestParam("archivo") MultipartFile archivo)
																		throws IOException {

		if(archivo.isEmpty()){
			//TODO: manejar esto
		}
		cond.setFotoPerfil(archivo.getBytes());

		//TODO: llenando los reviews falsos
		cond.setReviews(Arrays.asList(
										//si pasamos null a un Id Long lo  autogenera
										new Review(null, "muy amable", new Date()),
										new Review(null, "lo peor", new Date()),
										new Review(null, "lo recomiendo a todos", new Date())));
		Store.GuardarConductor(cond);
		return "redirect:/conductores";
	}

	//@RequestMapping(value="/eliminar/{nomusu}", method = RequestMethod.POST)
	@RequestMapping("/conductor/{nomusu}/eliminar")
	public String EliminarConductor(@PathVariable String nomusu, RedirectAttributes redAtrib){
		if(!Store.EliminarConductor(nomusu))
		{
			redAtrib.addFlashAttribute("mensaje", "No se encontró al conductor.");
		}
		return "redirect:/conductores";
	}

	@RequestMapping("/conductores")
	public String MostrarConductores(Model model){
		model.addAttribute("conductores", Store.TraerConductores());
		return "conductores";
	}

	@RequestMapping("/conductor/{nomusu}")
	public String MostrarConductor(Model model, @PathVariable String nomusu){
		model.addAttribute("cond", Store.TraerConductor(nomusu));
		return "conductor";
	}

	@RequestMapping("/")
	public String mostrarInicio(){
		return "inicio";
	}
}
