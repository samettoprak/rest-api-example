package com.samettoprak.springbootexample.DAO;

import com.samettoprak.springbootexample.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User,String> {
    User findByMail(String mail);
}
