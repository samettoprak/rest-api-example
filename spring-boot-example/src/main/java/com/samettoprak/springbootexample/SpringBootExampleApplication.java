package com.samettoprak.springbootexample;

import com.samettoprak.springbootexample.DAO.UserRepository;
import com.samettoprak.springbootexample.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLOutput;

@SpringBootApplication
public class SpringBootExampleApplication  implements CommandLineRunner {
	UserRepository userRepository;

	public SpringBootExampleApplication(UserRepository userRepository){
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User newUser = new User(null,"topraksamet41@gmail.com","Samet","123",true,null,null);
		userRepository.save(newUser);

		var deneme = userRepository.findByMail("topraksamet41@gmail.com");
		var results = userRepository.findAll();
		System.out.println(deneme);
		for (var result : results){
			System.out.println(result);
		}

	}
}
