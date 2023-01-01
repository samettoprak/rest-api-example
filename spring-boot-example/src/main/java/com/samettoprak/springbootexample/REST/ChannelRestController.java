package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Response;
import com.samettoprak.springbootexample.Service.ChannelService;
import com.samettoprak.springbootexample.Service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/Channels")
public class ChannelRestController {
    private ChannelService channelService;
    private UserService userService;
    public ChannelRestController(ChannelService channelService, UserService userService) {
        this.channelService = channelService;
        this.userService = userService;
    }

    @GetMapping("/")
    public Response<List<Channel>> getChannels() {
        try {
            var list = channelService.getAllChannels();
            return new Response<>(true, null, list);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }

    @PostMapping("/AddUser/{userId}/ToChannel/{channelId}")
    public Response<Channel> addUserToChannel(String userId, String channelId) {
        try {
            var channel = channelService.findById(channelId);
            var user = userService.findById(userId);
            if (channel != null && user!=null) {
                var result = channelService.addUserToChannel(user,channel);
                return new Response<>(true,null,result);
            } else return new Response<>(false, "Channel Not Found", null);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }
}
