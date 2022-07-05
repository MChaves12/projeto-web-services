package com.chaves.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.chaves.course.entities.Category;
import com.chaves.course.entities.Order;
import com.chaves.course.entities.OrderItem;
import com.chaves.course.entities.Product;
import com.chaves.course.entities.User;
import com.chaves.course.entities.enums.OrderStatus;
import com.chaves.course.repositories.CategoryRepository;
import com.chaves.course.repositories.OrderItemRepository;
import com.chaves.course.repositories.OrderRepository;
import com.chaves.course.repositories.ProductRepository;
import com.chaves.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "839999999", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "8388888888", "123456");
		
		Order o1 = new Order(null, Instant.parse("2022-07-20T22:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2022-08-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2022-08-22T15:21:22Z"), OrderStatus.WAITING_PAYMENT, u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "Senhor dos Aneis", "Lorem ipsum", 90.5, "");
		Product p2 = new Product(null, "Smart Tv", "Lorem ipsum", 2190.0, "");
		Product p3 = new Product(null, "MacBook Pro", "Lorem ipsum", 1550.5, "");
		Product p4 = new Product(null, "Pc Gamer", "Lorem ipsum", 1200.0, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3));


	}
	
	

}
