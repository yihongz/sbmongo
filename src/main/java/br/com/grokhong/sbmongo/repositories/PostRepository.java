package br.com.grokhong.sbmongo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.grokhong.sbmongo.entities.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
