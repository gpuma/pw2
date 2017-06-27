package pw2.controllers;

import pw2.domain.*;
import pw2.model.Store;

import java.util.List;
import java.util.Arrays;
import java.util.Date;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

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
	public String RegistrarConductor(@ModelAttribute Conductor cond){
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

	@RequestMapping("/conductores/{nomusu}/reviews/nuevo")
	public String NuevoReview(@PathVariable String nomusu, @RequestParam String review){
		//TODO: change this shit
		Conductor cond = Store.TraerConductor(nomusu);
		//cond.getReviews().add(new Review(null, review, new Date()));
		Store.AgregarReview(cond, review);
		return "redirect:/conductor/" + cond.getUsuario();
	}

	//en realidad solo necesitamos a reviewId
	@RequestMapping("/conductor/{nomusu}/reviews/{reviewId}/modificar")
	public String ModificarReview(Model model, @PathVariable String nomusu, @PathVariable Long reviewId){
		Review r = Store.TraerReview(reviewId);
		model.addAttribute("review", r);
		model.addAttribute("nomusu", nomusu);
		return "review_editar";
	}

	//en realidad solo necesitamos a reviewId
	@RequestMapping("/conductor/{nomusu}/reviews/{reviewId}/guardar")
	public String GuardarCambiosReview(@PathVariable Long reviewId, @RequestParam String comentario){
		//TODO: completar
		Store.ModificarReview(reviewId, comentario);
		return "redirect:/conductor/{nomusu}";
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
