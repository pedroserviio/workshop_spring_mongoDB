package com.pedroservio.workshopmongo.config;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.pedroservio.workshopmongo.domain.Post;
import com.pedroservio.workshopmongo.domain.User;
import com.pedroservio.workshopmongo.dto.AuthorDTO;
import com.pedroservio.workshopmongo.repository.PostRepository;
import com.pedroservio.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User pedro = new User(null, "Pedro Servio", "pedroservio@gmail.com");
		User maria = new User(null, "Maria Eduarda", "maria@gmail.com");
		User bob = new User(null, "Bob", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(pedro, maria, bob));
		
		Post post1 = new Post(null, sdf.parse("15/04/2022"), "Viagem", "Vou viajar para o Rio!", new AuthorDTO(pedro));
		Post post2 = new Post(null, sdf.parse("12/04/2022"), "Viagem", "Vou viajar para SP!", new AuthorDTO(pedro));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		pedro.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(pedro);
	}

}
