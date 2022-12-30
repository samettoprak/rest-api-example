package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.DAO.UserRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    ChannelRepository channelRepository;
    public UserServiceImpl(UserRepository userRepository, ChannelRepository channelRepository){
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
    }
    @Override
    public User getUserByName(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        //update ederken sanki mailini değiştiremez gibi düşündüğümüz için böyle ilerledik.
        User user1 = userRepository.findByMail(user.getMail());
        if(user1 != null){
            user1.setName(user.getName());
            user1.setPassword(user.getPassword());
            user1.setEnabled(user.getEnabled());
            user1.setChannels(user.getChannels());
            user1.setRoles(user.getRoles());
            userRepository.save(user1);
        }
        return user1;
    }

    @Override
    public User removeChannelFromUser(Channel channel, User user) {
        var channels = user.getChannels();
        channels.removeIf(channel1 -> channel1.getName().equals(channel.getName()));
        user.setChannels(channels);
        return userRepository.save(user);

    }

    @Override
    public User addChannelToUser(User user, Channel channel) {
       user.getChannels().add(channel);
       return user;
    }

}
