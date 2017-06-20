package progetto_siw_EC.run.controller;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import progetto_siw_EC.run.model.Autore;
import progetto_siw_EC.run.service.AutoreService;

@Controller
public class ControllerAutore {

	@Autowired
	private AutoreService autoreService; 

	@GetMapping("/inserimentoAutore")
	public String formAutore(Autore autore) {
		return "inserimentoAutore";
	}
	
	@GetMapping("/autore")
	public String getAutore(Model model,Long id) {
		model.addAttribute("autore", this.autoreService.findbyId(id));
		return "datiAutore";
	}

	@PostMapping("/autore")
	public String checkAutoreInfo(@Valid @ModelAttribute Autore Autore, 
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "inserimentoAutore";
		}
		else {
			model.addAttribute(Autore);
			autoreService.add(Autore); 
		}
		return "datiAutore";
	}

	
	@PostMapping("/rimuoviAutore")
	public String deleteAutore(Long id,Model model) {
		this.autoreService.cancella(id);
		model.addAttribute("autori", this.autoreService.findAll());
		return "listaAutoriCancella";
	}
	
	@GetMapping("/listaAutoriCancella")
	public String deleteAutore(Model model) {
		model.addAttribute("autori", this.autoreService.findAll());
		return "listaAutoriCancella";
	}
	

}
