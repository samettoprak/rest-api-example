package com.samettoprak.springbootexample.Entity;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @Email
    private String mail;
    @NotNull
    @Min(2)
    @Max(20)
    private String name;
    @NotNull
    @Min(8)
    @Max(50)
    private String password;
    private Boolean enabled;
    List<Channel> channels;
    List<Role> roles;


}
