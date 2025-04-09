package com.moetez.demo.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.moetez.demo.entities.Chien;
import com.moetez.demo.entities.Veterinaire;

@RepositoryRestResource(path = "rest")
public interface ChienRepository extends JpaRepository<Chien, Long> {
    List<Chien> findByNom(String nom);
    List<Chien> findByNomContains(String nom);
   
    @Query("SELECT c FROM Chien c WHERE c.nom LIKE %:nom% AND c.age > :age")
    List<Chien> findByNomAge(String nom,int age);

    @Query("SELECT c FROM Chien c WHERE c.veterinaire = ?1")
    List<Chien> findByVeterinaire(Veterinaire veterinaire);

    List<Chien> findByVeterinaireIdVet(Long id);

    List<Chien> findByOrderByNomAsc();

    @Query("SELECT c FROM Chien c ORDER BY c.nom ASC, c.age DESC")
    List<Chien> trierChiensNomsAge();

}
