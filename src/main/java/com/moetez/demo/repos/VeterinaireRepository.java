package com.moetez.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.moetez.demo.entities.Chien;
import com.moetez.demo.entities.Veterinaire;

@RepositoryRestResource(path = "vet")
@CrossOrigin(origins ="http://localhost:4200/") 
public interface VeterinaireRepository extends JpaRepository<Veterinaire, Long>{

	
}
