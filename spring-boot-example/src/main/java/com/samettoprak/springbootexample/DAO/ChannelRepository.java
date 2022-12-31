package com.samettoprak.springbootexample.DAO;

import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ChannelRepository extends MongoRepository<Channel,String>{
    List<Channel> findByNameAndOwner(String name, User owner);

}
