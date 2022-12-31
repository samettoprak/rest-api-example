package com.samettoprak.springbootexample.Entity;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@ToString
@Document("channels")
public class Channel {
    @Id
    private String id;
    @Min(2)
    @Max(50)
    private String name;
    private LocalDateTime creationDate;
    private User owner;
    private List<User> users;
    private List<Message> messages;

}
