package com.moetez.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.moetez.demo.entities.Chien;
import com.moetez.demo.service.ChienService;

@Controller
public class ChienController {

	@Autowired
	ChienService chienService;

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
	public String showCreate() {
		return "createChien";
	}

	@RequestMapping("/saveChien")
	public String saveChien(@ModelAttribute("chien") Chien chien, @RequestParam("age") int age, ModelMap modelMap) {
		chien.setAge(age); // Remplacer la date par l'âge

		Chien saveChien = chienService.saveChien(chien);
		String msg = "Chien enregistré avec Id " + saveChien.getId();
		modelMap.addAttribute("msg", msg);
		return "createChien";
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
	public String editerChien(@RequestParam("id") Long id, ModelMap modelMap) {
		Chien c = chienService.getChien(id);
		modelMap.addAttribute("chien", c);
		return "editerChien";
	}

	@RequestMapping("/updateChien")
	public String updateChien(@ModelAttribute("chien") Chien chien, ModelMap modelMap) {
	    chienService.updateChien(chien);
	    List<Chien> chiens = chienService.getAllChiens();
	    modelMap.addAttribute("chiens", chiens);
	    return "listeChiens";
	}
}
