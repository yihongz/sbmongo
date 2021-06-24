package br.com.grokhong.sbmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.grokhong.sbmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
