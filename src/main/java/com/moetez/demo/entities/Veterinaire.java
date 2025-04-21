package com.moetez.demo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Veterinaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idVet;

    private String nomVet;
    private String specialite;
    
    @JsonIgnore
    @OneToMany(mappedBy = "veterinaire")
    private List<Chien> chiens;
 
   
}
