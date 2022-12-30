package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Message;
import com.samettoprak.springbootexample.Entity.User;

import java.util.List;

public interface ChannelService {
    Channel updateChannel(Channel channel);
    Channel sendMessageToChannel(Message message, Channel channel);
    Channel removeMessageFromChannel(Message message, Channel channel);
    Channel addUserToChannel(User user, Channel channel);
    List<Channel> getAllChannels();
    Channel saveChannel(Channel channel);
    }
