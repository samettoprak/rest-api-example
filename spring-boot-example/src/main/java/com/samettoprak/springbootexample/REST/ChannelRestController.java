package com.samettoprak.springbootexample.REST;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")

public class ChannelRestController {
    private ChannelRepository channelRepository;

}
