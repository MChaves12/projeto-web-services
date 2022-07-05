package com.chaves.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.chaves.course.entities.Order;
import com.chaves.course.entities.User;
import com.chaves.course.entities.enums.OrderStatus;
import com.chaves.course.repositories.OrderRepository;
import com.chaves.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "839999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "8388888888", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-07-20T22:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-08-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-08-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);

		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	

}
