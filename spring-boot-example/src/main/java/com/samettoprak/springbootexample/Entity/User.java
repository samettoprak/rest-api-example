package com.samettoprak.springbootexample.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Document("users")
public class User {
    @Id
    private String id;
    private String mail;
    private String name;
    private String password;
    private Boolean enabled;
    List<Channel> channels;
    List<Role> roles;


}
