package com.samettoprak.springbootexample;


import com.samettoprak.springbootexample.Entity.Message;
import com.samettoprak.springbootexample.Service.ChannelService;
import com.samettoprak.springbootexample.Service.LoginService;
import com.samettoprak.springbootexample.Service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootExampleApplication  implements CommandLineRunner {
	private final UserService userService;
	private final LoginService loginService;
	private final ChannelService channelService;
	public SpringBootExampleApplication(UserService userService,LoginService loginService, ChannelService channelService){
		this.channelService = channelService;
		this.loginService=loginService;
		this.userService = userService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var user = loginService.CheckLogin("topraksamet41@gmail.com","123");
		var message = new Message(null, LocalDateTime.now(),"merhaba");
		var channel = channelService.getAllChannels().get(0);
		userService.addChannelToUser(user,channel);


		}

	}

