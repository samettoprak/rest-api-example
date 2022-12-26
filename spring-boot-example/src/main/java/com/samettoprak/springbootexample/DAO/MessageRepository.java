package com.samettoprak.springbootexample.DAO;

import com.samettoprak.springbootexample.Entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,String> {
}
