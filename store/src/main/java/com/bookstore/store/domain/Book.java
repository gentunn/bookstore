package com.bookstore.store.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

    private String title, author;
    private int year, isbn, price;
    public String getTitle() {
	return title;
	
}
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "categoryid")
    private Category category;
    
    
    

	public void setCategory(Category category) {
		this.category = category;
	}
	public Category getCategory() {
		return category;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public int getYear() {
	return year;
}
public void setYear(int year) {
	this.year = year;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}

public Book(String title, String author, int year, int isbn, int price, Category category) {
	super();
	this.title = title;
	this.author = author;
	this.year = year;
	this.isbn = isbn;
	this.price = price;
	this.category = category;
}
public Book() {}
 
 
}



