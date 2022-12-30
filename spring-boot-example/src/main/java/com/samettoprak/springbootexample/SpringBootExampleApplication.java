package com.samettoprak.springbootexample;

import com.samettoprak.springbootexample.DAO.ChannelRepository;
import com.samettoprak.springbootexample.DAO.UserRepository;
import com.samettoprak.springbootexample.Entity.Channel;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootExampleApplication  implements CommandLineRunner {
	UserRepository userRepository;
	ChannelRepository channelRepository;



	public SpringBootExampleApplication(UserRepository userRepository,ChannelRepository channelRepository){
		this.userRepository = userRepository;
		this.channelRepository = channelRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User newUser = new User(null,"topraksamet41@gmail.com","Samet","123",true,null,null);
		userRepository.save(newUser);
		User secondUser = new User(null,"burhankose@gmail.com","Burhan","1234",true,null,null);
		userRepository.save(secondUser);
		User owner = userRepository.findByMail("topraksamet41@gmail.com").get(0);
		List<User> liste = userRepository.findAll();
		Channel newChannel = new Channel(null,"Trakya CENG", LocalDateTime.now(),owner,liste,null);
		channelRepository.save(newChannel);*/
		User owner = userRepository.findByMail("topraksamet41@gmail.com").get(0);
		var channels = channelRepository.findByNameAndOwner("Trakya CENG", owner);
		System.out.println(channels);




		}

	}

