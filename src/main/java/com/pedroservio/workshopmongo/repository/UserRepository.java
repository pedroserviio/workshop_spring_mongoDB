package com.pedroservio.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.pedroservio.workshopmongo.domain.User.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}
