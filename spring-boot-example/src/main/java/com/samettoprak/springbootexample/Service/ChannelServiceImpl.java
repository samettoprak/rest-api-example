package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.DAO.MessageRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Message;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    ChannelRepository channelRepository;
    private final MessageRepository messageRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository,
                              MessageRepository messageRepository) {
        this.channelRepository = channelRepository;
        this.messageRepository = messageRepository;
    }

    @Override
    public Channel updateChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel sendMessageToChannel(Message message, String channelId) {
        var channel = channelRepository.findById(channelId).orElse(null);
        if (channel != null) {
            var list = channel.getMessages();
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(message);
            channel.setMessages(list);
            return channelRepository.save(channel);
        }
        return null;
    }

    @Override
    public Channel removeMessageFromChannel(Message message, String channelId) {
        var channel = channelRepository.findById(channelId).orElse(null);
        if (channel != null) {
            if (channel.getMessages() != null) {
                channel.getMessages().removeIf(object -> object.getId().equals(message.getId()));

            }
            return channelRepository.save(channel);
        }
        return null;
    }

    @Override
    public Channel addUserToChannel(User user, Channel channel) {
        channel.getUsers().add(user);
        return channelRepository.save(channel);
    }

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public Channel saveChannel(Channel channel) {
        return channelRepository.save(channel);
    }
}
