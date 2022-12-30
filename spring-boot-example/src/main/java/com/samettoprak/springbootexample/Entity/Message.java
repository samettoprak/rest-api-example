package com.samettoprak.springbootexample.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@ToString
@Document("messages")
public class Message {
    @Id
    private String id;
    private LocalDateTime postDate;
    private String content;
}
