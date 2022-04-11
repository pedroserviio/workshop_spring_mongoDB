package com.pedroservio.workshopmongo.config;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedroservio.workshopmongo.domain.User.User;
import com.pedroservio.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User pedro = new User(null, "Pedro Servio", "pedroservio@gmail.com");
		User maria = new User(null, "Maria Eduarda", "maria@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(pedro, maria, bob));
		
	}

}
