package com.moetez.demo.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
public class Chien {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2, max = 20)
    private String nom;

    @NotNull
    @Size(min = 3, max = 30)
    private String race;

    @Min(value = 0)
    @Max(value = 30)
    private int age;
    
    @ManyToOne
    private Veterinaire veterinaire;

    

	public Chien() {
        super();
    }

    public Chien(String nom, String race, int age) {
        super();
        this.nom = nom;
        this.race = race;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Veterinaire getVeterinaire() {
		return veterinaire;
	}

	public void setVeterinaire(Veterinaire veterinaire) {
		this.veterinaire = veterinaire;
	}

	@Override
    public String toString() {
        return "Chien [id=" + id + ", nom=" + nom + ", race=" + race + ", age=" + age + "]";
    }
}
