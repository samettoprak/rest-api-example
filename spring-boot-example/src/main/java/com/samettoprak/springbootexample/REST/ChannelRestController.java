package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Response;
import com.samettoprak.springbootexample.Service.ChannelService;
import com.samettoprak.springbootexample.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/Channels")
public class ChannelRestController {
    private final ChannelService channelService;
    private final UserService userService;

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
    @GetMapping("/Channel/{channelId}")
    public Response<Channel> getChannel(@PathVariable String channelId){
        try {
            var result = channelService.getChannel(channelId);
            if(result!=null){
                return new Response<>(true,null,result);
            }
            else return new Response<>(false,"Can't Find Channel",null);
        }catch (Exception e){
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @PostMapping("/")
    public Response<Channel> addChannel(@RequestBody Channel channel) {
        try {
            return new Response<>(true,null,channelService.addChannel(channel));
        } catch (Exception e) {
            return new Response<>(false,e.getMessage(),null);
        }

    }
    @PutMapping("/Channel/{channelId}")
    public Response<Channel> updateChannel(@RequestBody Channel channel,@PathVariable String channelId){
        try {
            return new Response<>(true,null,channelService.updateChannel(channel));
        }catch (Exception e){
            return new Response<>(false,e.getMessage(),null);

        }
    }
    @DeleteMapping("/DeleteChannel/{channelId}")
    public Response<Boolean> deleteChannel(@PathVariable String channelId){
        try {
            return new Response<>(true,null,channelService.deleteChannel(channelId));
        }catch (Exception e){
            return new Response<>(false,e.getMessage(),null);
        }
    }

    @PostMapping("/AddUser/{userId}/ToChannel/{channelId}")
    public Response<Channel> addUserToChannel(@PathVariable String userId,@PathVariable String channelId) {
        try {
            var channel = channelService.findById(channelId);
            var user = userService.findById(userId);
            if (channel != null && user != null) {
                var result = channelService.addUserToChannel(user, channel);
                return new Response<>(true, null, result);
            } else return new Response<>(false, "Channel Not Found", null);
        } catch (Exception e) {
            return new Response<>(false, e.getMessage(), null);
        }
    }
    @DeleteMapping("/DeleteUser/{userId}/FromChannel/{channelId}")
    public Response<Channel> deleteUserFromChannel(@PathVariable String userId,@PathVariable String channelId){
        try {
            var channel = channelService.deleteUserFromChannel(userId,channelId);
            if(channel!=null){
                return new Response<>(true,null,channel);
            }
            else return new Response<>(false,"Channel or user not exist",null);

        }catch (Exception e){
            return new Response<>(false,e.getMessage(),null);
        }
    }
}
