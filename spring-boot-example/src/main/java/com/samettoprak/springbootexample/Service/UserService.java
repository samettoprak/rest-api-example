package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.User;

import java.util.List;
public interface UserService {
    User getUserByName(String mail);
    List<User> getAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    User removeChannelFromUser(Channel channel,User user);
    User addChannelToUser(User user, Channel channel);
    String deleteUser(String mail);
    User findById(String userId);

}
