package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.Entity.Message;

import java.util.List;

public interface MessageService {
    Message saveMessage(Message message);
    Message findById(String messageId);
    List<Message> getAllMessages();
}
