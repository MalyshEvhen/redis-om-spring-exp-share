package com.example.demoredisom2;

import com.example.demoredisom2.entity.User;
import com.example.demoredisom2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoRedisOm2Application {
	private final UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(DemoRedisOm2Application.class, args);
	}

	@Bean
	public CommandLineRunner fakeData() {
		return args1 -> {
			var user = new User();
			user.setEmail("some@email.com");
			user.setName("Johh");

			var user2 = new User();
			user2.setEmail("jane@email.com");
			user2.setName("Jane");

			var user3 = new User();
			user3.setEmail("jack@email.com");
			user3.setName("Jack");

			Stream.of(user, user3, user2).forEach(repository::save);
		};
	}

}
