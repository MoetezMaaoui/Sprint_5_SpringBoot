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
import com.moetez.demo.entities.Role;
import com.moetez.demo.entities.User;
import com.moetez.demo.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class ChiensApplication implements CommandLineRunner {
	
	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ChiensApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		//System.out.println(passwordEncoder.encode("123"));
		/*produitService.saveProduit(new Produit("PC Dell", 2600.0, new Date()));
		produitService.saveProduit(new Produit("PC Asus", 2800.0, new Date()));
		produitService.saveProduit(new Produit("Imp Epson", 900.0, new Date()));
		*/
	}
	
	
	/*
	@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"moetez","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("moetez", "USER");
	userService.addRoleToUser("moetez", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}
	*/
	
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
