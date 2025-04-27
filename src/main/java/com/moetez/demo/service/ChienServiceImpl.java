package com.moetez.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moetez.demo.dto.ChienDTO;
import com.moetez.demo.entities.Chien;
import com.moetez.demo.entities.Veterinaire;
import com.moetez.demo.repos.ChienRepository;
import com.moetez.demo.repos.VeterinaireRepository;

@Service
public class ChienServiceImpl implements ChienService {

	@Autowired
	ModelMapper modelMapper;
	
    @Autowired
    private ChienRepository chienRepository;
    
    @Autowired
    VeterinaireRepository veterinaireRepository;

    @Override
    public ChienDTO saveChien(ChienDTO c) {
        return convertEntityToDto(chienRepository.save(convertDtoToEntity(c)));
    }

    @Override
    public ChienDTO updateChien(ChienDTO c) {
        return convertEntityToDto(chienRepository.save(convertDtoToEntity(c)));
    }

    @Override
    public void deleteChien(Chien c) {
        chienRepository.delete(c);
    }

    @Override
    public void deleteChienById(Long id) {
        chienRepository.deleteById(id);
    }

    @Override
    public ChienDTO getChien( Long id) {
        return convertEntityToDto(chienRepository.findById(id).orElseThrow(() -> new RuntimeException("Chien non trouvé")));
    }

    @Override
    public List<ChienDTO> getAllChiens() {
        return chienRepository.findAll().stream()
        		.map(this::convertEntityToDto)
        		.collect(Collectors.toList());
    }
    
    @Override
    public Page<Chien> getChiensParPage(int page, int size) {
        return chienRepository.findAll(PageRequest.of(page, size));
    }
    
    @Override
    public List<Chien> findByNomChien(String nom) {
        return chienRepository.findByNom(nom);
    }

    @Override
    public List<Chien> findByNomChienContains(String nom) {
        return chienRepository.findByNomContains(nom);
    }

    @Override
    public List<Chien> findByNomAge(String nom, Integer age) {
        return chienRepository.findByNomAge(nom, age);
    }

    @Override
    public List<Chien> findByVeterinaire(Veterinaire veterinaire) {
        return chienRepository.findByVeterinaire(veterinaire);
    }

    @Override
    public List<Chien> findByVeterinaireIdVet(Long id) {
        return chienRepository.findByVeterinaireIdVet(id);
    }

    @Override
    public List<Chien> findByOrderByNomChienAsc() {
        return chienRepository.findByOrderByNomAsc();
    }

    @Override
    public List<Chien> trierChiensNomsAge() {
        return chienRepository.trierChiensNomsAge();
    }
    
    
    @Override
    public List<Veterinaire> getAllVeterinaires() {
    return veterinaireRepository.findAll();
    }

    
    @Override
    public ChienDTO convertEntityToDto(Chien chien) {
    	modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    	ChienDTO chienDTO = modelMapper.map(chien, ChienDTO.class);
    	//chienDTO.setId(chien.getId());
    	//chienDTO.setNom(chien.getNom());
    	//chienDTO.setAge(chien.getAge());
    	//chienDTO.setRace(chien.getRace());
    	//chienDTO.setVeterinaire(chien.getVeterinaire());
    	//chienDTO.setNvet(chien.getVeterinaire().getNomVet());

    	return chienDTO;

     /*return ProduitDTO.builder()
    .idProduit(produit.getIdProduit())
    .nomProduit(produit.getNomProduit())
    .prixProduit(produit.getPrixProduit())
    .dateCreation(p.getDateCreation())
    .categorie(produit.getCategorie())
    .build();*/
    }
    
    @Override
    public Chien convertDtoToEntity(ChienDTO chienDTO) {
    	Chien chien = new Chien();
    	chien = modelMapper.map(chienDTO, Chien.class);
    	
    	//chien.setId(chienDTO.getId());
    	//chien.setNom(chienDTO.getNom());
    	//chien.setAge(chienDTO.getAge());
    	//chien.setRace(chienDTO.getRace());
    	//chien.setVeterinaire(chienDTO.getVeterinaire());

    	return chien;
    }

    
}