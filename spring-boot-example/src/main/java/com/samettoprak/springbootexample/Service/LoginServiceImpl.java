package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.DAO.UserRepository;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User CheckLogin(String mail, String password) {
        User user = userRepository.findByMail(mail);
        if(user!=null) {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
