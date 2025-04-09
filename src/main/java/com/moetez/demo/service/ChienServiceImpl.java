package com.moetez.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.moetez.demo.entities.Chien;
import com.moetez.demo.entities.Veterinaire;
import com.moetez.demo.repos.ChienRepository;

@Service
public class ChienServiceImpl implements ChienService {

    @Autowired
    private ChienRepository chienRepository;

    @Override
    public Chien saveChien(Chien c) {
        return chienRepository.save(c);
    }

    @Override
    public Chien updateChien(Chien c) {
        return chienRepository.save(c);
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
    public Chien getChien(Long id) {
        return chienRepository.findById(id).orElseThrow(() -> new RuntimeException("Chien non trouvé"));
    }

    @Override
    public List<Chien> getAllChiens() {
        return chienRepository.findAll();
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

    
    
}