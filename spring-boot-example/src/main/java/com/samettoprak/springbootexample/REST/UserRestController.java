package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.Entity.Response;
import com.samettoprak.springbootexample.Entity.User;
import com.samettoprak.springbootexample.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserRestController {

    UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public Response<List<User>> getAllUsers() {
        try {
            var result = userService.getAllUsers();
            if (result == null || result.size() == 0) {
                return new Response<>(false, "Can't Find Any User", null);
            } else return new Response<>(true, null, result);

        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }


    @GetMapping("/{mail}")
    public Response<User> getUserByName(@PathVariable String mail) {
        try {
            var result = userService.getUserByName(mail);
            if (result == null)
                return new Response<>(false, "Mail Not Found", null);
            else
                return new Response<>(true, null, result);

        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    @PostMapping("/")
    public Response<User> saveUser(@RequestBody User user) {
        try {
            var result = userService.saveUser(user);
            return new Response<>(true, null, result);

        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);

        }
    }

    @PutMapping("/{mail}")
    public Response<User> updateUser(@PathVariable String mail, @RequestBody User user) {
        try {
            user.setMail(mail);
            var result = userService.updateUser(user);
            return new Response<>(true, null, result);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    @DeleteMapping("/{mail}")
    public Response<Boolean> removeUser(@PathVariable String mail) {
        try {
            var result = userService.deleteUser(mail);
            if (result.equals("Succsess")) {
                return new Response<>(true, "Deleted Succsessfully", true);
            }
            return new Response<>(false,result,false);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), false);
        }

    }
}

    /*
    User removeChannelFromUser(Channel channel,User user);
    User addChannelToUser(User user, Channel channel);
    * */

