package com.moetez.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.moetez.demo.dto.ChienDTO;
import com.moetez.demo.entities.Chien;
import com.moetez.demo.entities.Veterinaire;
import com.moetez.demo.service.ChienService;

import jakarta.validation.Valid;

@Controller
public class ChienController {

	@Autowired
	ChienService chienService;

	@GetMapping(value = "/") 
	public String welcome() { 
		return "index"; 
	} 

	


	@RequestMapping("/ListeChiens")
	public String listeChiens(ModelMap modelMap, 
			@RequestParam(name="page", defaultValue = "0") int page, 
			@RequestParam(name="size", defaultValue = "2") int size) {
		// Récupérer la liste des chiens avec pagination
		Page<Chien> chiens = chienService.getChiensParPage(page, size);
		// Ajouter les chiens au modèle
		modelMap.addAttribute("chiens", chiens);	    
		// Ajouter les pages et la page courante pour la pagination
		modelMap.addAttribute("pages", new int[chiens.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);	    
		// Retourner le nom de la vue à afficher
		return "listeChiens";
	}

	@RequestMapping("/showCreate")
	public String showCreateChien(ModelMap modelMap) {
		List<Veterinaire> vets = chienService.getAllVeterinaires();  // Get the list of veterinarians
		modelMap.addAttribute("chien", new Chien());  // Initialize a new Chien
		modelMap.addAttribute("mode", "new");
		modelMap.addAttribute("veterinaires", vets);  // Add veterinaires to the model
		return "formChien";
	}

	@RequestMapping("/saveChien")
	public String saveChien(@Valid ChienDTO chien, BindingResult bindingResult,
			@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "2") int size)
	{
		int currentPage;
		boolean isNew = false;

		if (bindingResult.hasErrors()) {
			return "formChien";
		}

		if (chien.getId() == null) // Check if it's a new dog (no ID)
			isNew = true;

		chienService.saveChien(chien); // Save the dog entity

		if (isNew) { // If it's a new dog
			Page<Chien> chiens = chienService.getChiensParPage(page, size);
			currentPage = chiens.getTotalPages() - 1; // Get the last page
		} else { // If it's an edit
			currentPage = page;
		}

		return "redirect:/ListeChiens?page=" + currentPage + "&size=" + size; // Redirect to the list of dogs with pagination
	}


	@RequestMapping("/supprimerChien")
	public String supprimerChien(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		chienService.deleteChienById(id); // Suppression du chien par son ID

		// Récupération de la page suivante avec la pagination
		Page<Chien> chiens = chienService.getChiensParPage(page, size);
		modelMap.addAttribute("chiens", chiens);
		modelMap.addAttribute("pages", new int[chiens.getTotalPages()]); // Pages à afficher pour la pagination
		modelMap.addAttribute("currentPage", page); // Page actuelle
		modelMap.addAttribute("size", size); // Taille de la page
		return "listeChiens"; // Retourne la vue avec la liste des chiens
	}


	@RequestMapping("/modifierChien")
	public String editerChien(@RequestParam("id") Long id, ModelMap modelMap,@RequestParam(name="page", defaultValue = "0") int page,
			@RequestParam(name="size", defaultValue = "2") int size) {
		ChienDTO chien = chienService.getChien(id);  // Get the Chien object by its ID
		List<Veterinaire> vets = chienService.getAllVeterinaires();  // Get the list of veterinarians
		modelMap.addAttribute("chien", chien);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("veterinaires", vets);  // Add veterinaires to the model
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formChien" ;
	}

	@RequestMapping("/updateChien")
	public String updateChien(@ModelAttribute("chien") ChienDTO chien, ModelMap modelMap) {
		chienService.updateChien(chien);
		List<ChienDTO> chiens = chienService.getAllChiens();
		modelMap.addAttribute("chiens", chiens);
		return "redirect:/listeChiens";
	}
}
