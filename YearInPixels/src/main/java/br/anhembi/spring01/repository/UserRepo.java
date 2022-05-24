package br.anhembi.spring01.repository;

import br.anhembi.spring01.model.User;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepo extends MongoRepository <User, Integer> {
    
}
