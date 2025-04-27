package com.moetez.demo.dto;

import java.util.Date;

import com.moetez.demo.entities.Veterinaire;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChienDTO {
	private Long id;
	private String nom;
	private int age;
	private String race;
	private Veterinaire veterinaire;
	private String nomvet;
}
