package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.MessageRepository;
import com.samettoprak.springbootexample.Entity.Message;
import org.springframework.stereotype.Service;

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
}
