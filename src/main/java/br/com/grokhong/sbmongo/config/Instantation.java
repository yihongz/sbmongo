package br.com.grokhong.sbmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.grokhong.sbmongo.dto.AuthorDTO;
import br.com.grokhong.sbmongo.entities.Post;
import br.com.grokhong.sbmongo.entities.User;
import br.com.grokhong.sbmongo.repositories.PostRepository;
import br.com.grokhong.sbmongo.repositories.UserRepository;

@Configuration
public class Instantation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post p1 = new Post(null, Instant.parse("2018-03-21T19:53:07Z"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post p2 = new Post(null, Instant.parse("2018-03-23T08:24:07Z"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(p1, p2));
	}

}
