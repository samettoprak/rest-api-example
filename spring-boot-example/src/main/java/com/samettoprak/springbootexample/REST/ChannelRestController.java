package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Response;
import com.samettoprak.springbootexample.Service.ChannelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;





@RestController
@RequestMapping("/Channels")
public class ChannelRestController {
    private ChannelService channelService;
    public ChannelRestController(ChannelService channelService){
        this.channelService=channelService;
    }
    @GetMapping("/")
    public Response<List<Channel>> getChannels(){
        try{
            var list = channelService.getAllChannels();
            return new Response<>(true,null,list);
        }catch (Exception e){
            return new Response<>(false,e.getMessage(),null);
        }
    }
}
