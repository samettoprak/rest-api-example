package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.DAO.MessageRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.Message;
import com.samettoprak.springbootexample.Entity.Response;
import com.samettoprak.springbootexample.Service.ChannelService;
import com.samettoprak.springbootexample.Service.MessageService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Messages")
public class MessageRestController {
    private MessageService messageService;
    private ChannelService channelService;
    public MessageRestController(MessageService messageService,ChannelService channelService){
        this.messageService=messageService;
        this.channelService=channelService;
    }
    @GetMapping("/")
    public Response<List<Message>> getMessages(){
        var result = messageService.getAllMessages();
        return new Response<>(true,null,result);
    }
    @PostMapping("/AddMessageToChannel/{channelId}")
    public Response<Message> addMessageToChannel(@RequestBody Message message, @PathVariable String channelId){
        try{
            var newMessage = messageService.saveMessage(message);
            var result = channelService.sendMessageToChannel(newMessage,channelId);
            return new Response<>(true,null,newMessage);
        }catch (Exception e) {
            return new Response<>(false, e.getMessage(),null);
        }
    }
    @DeleteMapping("/DeleteMessage/{messageId}/FromChannel/{channelId}")
    public Response<Boolean> deleteMessage(@PathVariable String messageId,@PathVariable String channelId){
        try{
            var message = messageService.findById(messageId);
            channelService.removeMessageFromChannel(message,channelId);
            return new Response<>(true,null,true);
        }catch (Exception e){
            return new Response<>(false,e.getMessage(),null);
        }

    }


}
