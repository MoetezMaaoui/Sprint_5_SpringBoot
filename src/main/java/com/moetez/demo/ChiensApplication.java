package com.moetez.demo;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.moetez.demo.entities.Chien;
import com.moetez.demo.entities.Veterinaire;
import com.moetez.demo.service.UserService;

@SpringBootApplication
public class ChiensApplication implements CommandLineRunner {
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserService userService;
    
    @Autowired
    private RepositoryRestConfiguration repositoryRestConfiguration;  // Injection correcte de RepositoryRestConfiguration

    public static void main(String[] args) {
        SpringApplication.run(ChiensApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Maintenant, repositoryRestConfiguration est bien injecté
        repositoryRestConfiguration.exposeIdsFor(Chien.class, Veterinaire.class);
    }

    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
