package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.MessageRepository;
import com.samettoprak.springbootexample.Entity.Message;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public Message findById(String messageId) {
        return messageRepository.findById(messageId).orElse(null);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }
}
