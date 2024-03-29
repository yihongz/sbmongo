package br.com.grokhong.sbmongo.services;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grokhong.sbmongo.entities.Post;
import br.com.grokhong.sbmongo.repositories.PostRepository;
import br.com.grokhong.sbmongo.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repo;
	
	public Post findById(String id) {
		Optional<Post> post = Optional.ofNullable(repo.findById(id).orElse(null));
		return post.orElseThrow(() -> new ObjectNotFoundException(id));
	}
	
	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullSearch(String text, Instant minDate, Instant maxDate) {
		Instant value = maxDate.plus(1, ChronoUnit.DAYS);
		return repo.fullSearch(text, minDate, value);
	}
}
