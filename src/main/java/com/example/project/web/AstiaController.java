package com.example.project.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.project.domain.Astia;
import com.example.project.domain.AstiaRepository;
import com.example.project.domain.CategoryRepository;


@Controller
public class AstiaController {
	
	@Autowired
	private AstiaRepository repository;
	
	@Autowired
	private CategoryRepository crepository;
	
	//Tämä endpoint listaa astiat
	@RequestMapping(value = "/astialista")
	public String astiaLista(Model model) {
		model.addAttribute("astiat", repository.findByOrderByKuosiAsc());
		return "astialista";
	}
	//Tällä endpointilla voidaan lisätä uusia astioita
	@RequestMapping(value = "/lisaaastia")
	public String lisaaAstia(Model model){
		model.addAttribute("astia", new Astia());
		model.addAttribute("categorys", crepository.findAll());
		return "lisaaastia";
	}
	//Tämä endpoint on painettaessa tallenna-painiketta, se tallentaa uuden astian, ja sen jälkeen ohjautuu astialista-endpointiin
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Astia astia){
		repository.save(astia);
		return "redirect:astialista";
	}
	//Tästä endpointista voidaan kirjautua sivustolle
	@RequestMapping(value="/login")
	public String login() {
		return "login";	
	}
	//Tämä endpoint on painettaessa poista-painiketta, se poistaa astian, ja sen jälkeen ohjautuu astialista-endpointiin
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteAstia(@PathVariable("id")Long astiaId, Model model) {
		repository.deleteById(astiaId);
		return "redirect:../astialista";	
	}
	//Tämä endpoint on painettaessa muokkaa-painiketta, se avaa editastia endpointin, jossa astian tietoja voidaan muokata
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editAstia(@PathVariable("id")Long astiaId, Model model) {
		//Optional <Astia> astiat = repository.findById(astiaId);
		model.addAttribute("astia", repository.findById(astiaId));
		model.addAttribute("categorys", crepository.findAll());
		return "editastia";	
	}
	// RESTful, endpoint, josta saadaan kaikki astiat listattuna
    @RequestMapping(value="/astiat", method = RequestMethod.GET)
    public @ResponseBody List<Astia> astiaListaRest() {	
        return (List<Astia>) repository.findAll();
    }    

	// RESTful, endpoint, josta saadaan tietyn astian tiedot listattuna
    @RequestMapping(value="/astia/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Astia> findBookRest(@PathVariable("id") Long astiaId) {	
    	return repository.findById(astiaId);
    }       
}
