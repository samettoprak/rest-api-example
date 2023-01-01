package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.DAO.UserRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
            if(user.getName()!=null) user1.setName(user.getName());
            if(user.getPassword()!=null)user1.setPassword(user.getPassword());
            if(user.getEnabled()!=null)user1.setEnabled(user.getEnabled());
            if(user.getChannels()!=null)user1.setChannels(user.getChannels());
            if(user.getRoles()!=null)user1.setRoles(user.getRoles());
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
        if (user.getChannels()==null) {
            user.setChannels(new ArrayList<>());
        }
        user.getChannels().add(channel);
        userRepository.save(user);
       return user;
    }

    @Override
    public String deleteUser(String mail) {
        try{
            userRepository.delete(userRepository.findByMail(mail));
            return "Succsess";
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @Override
    public User findById(String userId) {
        return userRepository.findById(userId).orElse(null);
    }

}
