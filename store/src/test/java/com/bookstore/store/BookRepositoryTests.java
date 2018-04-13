package com.bookstore.store;
import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import  com.bookstore.store.domain.BookRepository;
import  com.bookstore.store.domain.Book;
import  com.bookstore.store.domain.Category;

@RunWith(SpringRunner.class)
@DataJpaTest

public class BookRepositoryTests {
    @Autowired
    private BookRepository repository;

    @Test
    public void findByTitleShouldReturnAuthor() {
        List<Book> books = repository.findByTitle("Harry Potter");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.K Rowling");;
    }
    
    @Test
    public void createNewBook() {
    	Book book = new Book("And Then There Were None", "Agatha Christie", 1939, 0007, 10, new Category("Fiction"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }    
    
 
    @Test
    public void deleteBook() {
    	List<Book> books = repository.findByTitle("Harry Potter");
    	repository.delete(books.get(0));
    	List<Book> bookTwo = repository.findByTitle("Harry Potter");
    	assertThat(bookTwo).hasSize(0);
    }   
}
