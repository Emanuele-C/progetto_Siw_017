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
import progetto_siw_EC.run.model.Quadro;
import progetto_siw_EC.run.service.AutoreService;
import progetto_siw_EC.run.service.QuadroService;

@Controller

public class ControllerQuadro {
	

    @Autowired
    private QuadroService 	quadroService; 
    @Autowired
	private AutoreService autoreService;
    
  

	@GetMapping("/inserimentoQuadro")
	public String formOpera(Quadro opera,Model model) {
		Iterable<Autore> autori=this.autoreService.findAll();
		model.addAttribute("autori",autori);
		return "inserimentoQuadro";
	}
	
    @PostMapping("/opera")
    public String checkOperaInfo(@Valid @ModelAttribute Quadro Quadro, 
    									BindingResult bindingResult, Model model,Long id) {
    	
	  if (bindingResult.hasErrors()) {
        	Iterable<Autore> autori=this.autoreService.findAll();
        	model.addAttribute("autori",autori);
            return "inserimentoQuadro";
        }
        else {
        	Autore findbyId = this.autoreService.findbyId(id);
			Quadro.setAutore(findbyId);
        	findbyId.getListaQuadri().add(Quadro);
        	model.addAttribute(Quadro);
            quadroService.add(Quadro); 
        }
        return "infoQuadro";
    }
	
	@GetMapping("/vediQuadri")
    public String tutteOpere(@Valid @ModelAttribute Quadro quadro, 
    									BindingResult bindingResult, Model model) {
		Iterable<Quadro> opere=this.quadroService.findAll();
    	model.addAttribute("opere",opere);
        return "listaOpere";
    }
	
	
	@GetMapping("/listaQuadriCancella")
	public String deleteAutore(Model model) {
		model.addAttribute("opere", this.quadroService.findAll());
		return "listaQuadriCancellaOpera";
	}	
	
	@PostMapping("/rimuoviOpera")
	public String deleteAutore(Long id,Model model) {
		this.quadroService.cancella(id);
		model.addAttribute("quadri", this.quadroService.findAll());
		return "listaQuadriCancella";
	}
}