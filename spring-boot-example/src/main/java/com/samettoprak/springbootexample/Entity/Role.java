package com.samettoprak.springbootexample.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@ToString
@Document("roles")
public class Role {
    @Id
    private String id;
    private String role;

}
