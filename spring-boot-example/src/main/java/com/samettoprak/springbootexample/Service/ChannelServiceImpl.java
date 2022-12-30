package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Message;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ChannelServiceImpl implements ChannelService {
    ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel updateChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel sendMessageToChannel(Message message, Channel channel) {
        var list = channel.getMessages();
        list.add(message);
        channel.setMessages(list);
        return channelRepository.save(channel);
    }

    @Override
    public Channel removeMessageFromChannel(Message message, Channel channel) {
        var list = channel.getMessages();
        list.removeIf(object -> object.getId().equals(message.getId()));
        channel.setMessages(list);
        return channelRepository.save(channel);
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
