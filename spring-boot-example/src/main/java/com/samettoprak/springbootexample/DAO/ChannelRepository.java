package com.samettoprak.springbootexample.DAO;

import com.samettoprak.springbootexample.Entity.Channel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelRepository extends MongoRepository<Channel,String>{
}
