package com.samettoprak.springbootexample.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@ToString
@Document("roles")
public class Role {
    private String id;
    private String role;

}
