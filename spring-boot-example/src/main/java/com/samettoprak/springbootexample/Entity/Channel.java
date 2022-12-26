package com.samettoprak.springbootexample.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Document("channels")
public class Channel {
    private String id;
    private String name;
    private LocalDateTime creationDate;
    private User owner;
    private List<User> users;
    private List<Message> messages;

}
