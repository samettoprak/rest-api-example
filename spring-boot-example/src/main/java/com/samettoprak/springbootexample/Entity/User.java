package com.samettoprak.springbootexample.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Document("users")
public class User {
    private String id;
    private String mail;
    private String name;
    private String password;
    private boolean enabled;
    List<Channel> channels;
    List<Role> roles;

    public boolean getEnabled() {
        return enabled;
    }
}
