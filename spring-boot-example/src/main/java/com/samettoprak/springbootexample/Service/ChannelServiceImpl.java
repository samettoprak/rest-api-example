package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.DAO.MessageRepository;
import com.samettoprak.springbootexample.DAO.UserRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Message;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository,
                              MessageRepository messageRepository,
                              UserRepository userRepository) {
        this.channelRepository = channelRepository;
        this.messageRepository = messageRepository;
        this.userRepository = userRepository;
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
    public Channel addChannel(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Channel findById(String channelId) {
        return channelRepository.findById(channelId).orElse(null);
    }

    @Override
    public Boolean deleteChannel(String channelId) {
        var result = channelRepository.findById(channelId).orElse(null);
        try {
            if (result != null) {
                channelRepository.delete(result);
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public Channel getChannel(String channelId) {
        return channelRepository.findById(channelId).orElse(null);
    }

    @Override
    public Channel deleteUserFromChannel(String userId, String channelId) {
            var channel = channelRepository.findById(channelId).orElse(null);
            if(channel!=null){
                var list = channel.getUsers();
                if(list!=null){
                    list.removeIf(user -> user.getId().equals(userId));
                    channel.setUsers(list);
                    channelRepository.save(channel);
                    return channel;
                }
                else return null;

            }
            else return null;
    }
}
