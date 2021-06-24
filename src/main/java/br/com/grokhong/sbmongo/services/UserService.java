package br.com.grokhong.sbmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grokhong.sbmongo.entities.User;
import br.com.grokhong.sbmongo.repositories.UserRepository;
import br.com.grokhong.sbmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = Optional.ofNullable(repo.findById(id).orElse(null));
		return user.orElseThrow(() -> new ObjectNotFoundException(id));
	}
}
