package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.Entity.Response;
import com.samettoprak.springbootexample.Entity.User;
import com.samettoprak.springbootexample.Service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class LoginRestController {
    private final LoginService loginService;

    public LoginRestController(LoginService loginService){
        this.loginService = loginService;

    }
    @GetMapping("/CheckLogin")
    //@PathVariable olmadan da şuan çalışıyor fakat @GetMapping("/CheckLogin?mail={mail}&...")
    //diye devam etseydi @PathVariable kullanmak zorundaydık.
    public Response<User> checkLogin( String mail, String password){
        try {
            var result = loginService.CheckLogin(mail,password);
            if(result==null){
                return new Response<>(false,"User Not Found",null);
            }
            else return new Response<>(true,null,result);

        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);

        }
    }
}
