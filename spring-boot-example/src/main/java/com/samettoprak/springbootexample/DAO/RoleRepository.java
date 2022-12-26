package com.samettoprak.springbootexample.DAO;

import com.samettoprak.springbootexample.Entity.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role,String> {
}
