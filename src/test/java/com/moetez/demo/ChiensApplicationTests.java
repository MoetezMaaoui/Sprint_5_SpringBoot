package com.moetez.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.moetez.demo.entities.Chien;
import com.moetez.demo.service.ChienService;



@SpringBootApplication
public class ChiensApplicationTests implements CommandLineRunner {
    @Autowired
    ChienService chienService;

    public static void main(String[] args) {
        SpringApplication.run(ChiensApplicationTests.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //chienService.saveChien(new Chien("Rex", "Berger Allemand", 4));
        //chienService.saveChien(new Chien("Buddy", "Golden Retriever", 3));
        //chienService.saveChien(new Chien("Luna", "Bulldog", 2));
    }
}

	