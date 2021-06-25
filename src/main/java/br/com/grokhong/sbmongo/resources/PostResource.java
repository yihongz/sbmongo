package br.com.grokhong.sbmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.grokhong.sbmongo.entities.Post;
import br.com.grokhong.sbmongo.resources.util.URL;
import br.com.grokhong.sbmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	// https://docs.spring.io/spring-data/mongodb/docs/current/reference/html/
	// https://docs.spring.io/spring-data/data-document/docs/current/reference/html/
	@GetMapping(value = "/titlesearch")
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="text", defaultValue="") String text) {
		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);
		return ResponseEntity.ok().body(list);
	}
}
