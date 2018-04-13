package com.bookstore.store;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import  com.bookstore.store.domain.Book;
import  com.bookstore.store.domain.BookRepository;
import  com.bookstore.store.domain.Category;
import  com.bookstore.store.domain.CategoryRepository;
import  com.bookstore.store.domain.User;
import  com.bookstore.store.domain.UserRepository;








@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(StoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner bookInitial(BookRepository brepository, CategoryRepository crepository,UserRepository urepository) {
		return (args) -> {
			crepository.save(new Category("Fiction"));
			crepository.save(new Category("Nonfiction"));
			Book book1= new Book("Harry Potter", "J.K Rowling", 1997, 0001, 19, crepository.findByName("Fiction").get(0));
			Book book2= new Book("The Wealth of Nations", "Adam Smith", 1776, 0002, 15, crepository.findByName("Nonfiction").get(0));
			Book book3= new Book("The Universe in a Nutshell", "Stephen Hawking", 2001,0003, 20, crepository.findByName("Nonfiction").get(0));
			Book book4= new Book("SAP HANA Cookbook", "O'Reilly", 2010 ,0004, 50, crepository.findByName("Nonfiction").get(0));
			brepository.save(book1);
			brepository.save(book2);
			brepository.save(book3);
			brepository.save(book4);
			
			User user1 = new User("user", "$2a$04$wAePWm6hweKgC15E6VhQ1OekmQsF35NAMJO0P6ezyFWX6HBF4HMSK", "USER"); // passwordUser
			User user2 = new User("admin", "$2a$04$iC/KuaG5sTRzC.NCT0pvW.Hk7evaWuciOtd.BbJGljzNNwFIO1mnC", "ADMIN");  //passwordAd
			urepository.save(user1);
			urepository.save(user2);
			
	

		};
	}
	
}
