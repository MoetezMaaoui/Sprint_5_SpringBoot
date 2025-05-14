package com.moetez.demo.restcontrollers;

import java.util.List; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.web.bind.annotation.CrossOrigin; 
import org.springframework.web.bind.annotation.PathVariable; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.RequestMethod; 
import org.springframework.web.bind.annotation.RestController; 
import com.moetez.demo.entities.Veterinaire; 
import com.moetez.demo.repos.VeterinaireRepository; 
 
@RestController 
@RequestMapping("/api/vet") 
@CrossOrigin("*") 

public class veterinaireRESTContoller {

	@Autowired 
	VeterinaireRepository veterinaireRepository; 
	  
	 @RequestMapping(method=RequestMethod.GET) 
	 public List<Veterinaire> getAllVeterinaires() 
	 { 
	  return veterinaireRepository.findAll(); 
	 } 
	  
	 @RequestMapping(value="/{id}",method = RequestMethod.GET) 
	 public Veterinaire getVeterinaireById(@PathVariable("id") Long id) { 
	  return veterinaireRepository.findById(id).get(); 
	  } 
}
