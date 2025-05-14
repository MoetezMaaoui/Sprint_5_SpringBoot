package com.moetez.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.moetez.demo.dto.ChienDTO;
import com.moetez.demo.entities.Chien;
import com.moetez.demo.service.ChienService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ChienRESTController {

	@Autowired
	ChienService chienService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<ChienDTO> getAllChiens(){
		return chienService.getAllChiens();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public ChienDTO getChienById(@PathVariable("id") Long id) {
		return chienService.getChien(id);
	 }
	
	@RequestMapping(method = RequestMethod.POST)
	public ChienDTO createChien(@RequestBody ChienDTO chien) {
		return chienService.saveChien(chien);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ChienDTO editerChien(@RequestBody ChienDTO chien) {
		return chienService.updateChien(chien);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteChien(@PathVariable("id") Long id){
		chienService.deleteChienById(id);
	}
	
	@RequestMapping(value="/prodscat/{idVet}",method = RequestMethod.GET)
	public List<Chien> getChiensByCatId(@PathVariable("idVet") Long idVet) {
	return chienService.findByVeterinaireIdVet(idVet);
	}

}
