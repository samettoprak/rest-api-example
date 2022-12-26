package com.samettoprak.springbootexample.DAO;

import com.samettoprak.springbootexample.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User,String> {
    List<User> findByMail(String mail);
}
