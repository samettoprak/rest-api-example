package com.samettoprak.springbootexample.Service;

import com.samettoprak.springbootexample.Entity.User;

public interface LoginService {
    User CheckLogin(String mail, String password);


}

