package com.bookstore.store.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import  com.bookstore.store.domain.Book;
import  com.bookstore.store.domain.BookRepository;
import  com.bookstore.store.domain.CategoryRepository;




@Controller
///@ResponseBody will only return a string (index)

public class BookController {
	@Autowired
	 private BookRepository repository;
	@Autowired
	private CategoryRepository crepository; 
	
	@RequestMapping(value="/login")
    public String login() {	
        return "login";
    }
	
    @RequestMapping(value="/index")
    public String studentList(Model model) {	
        model.addAttribute("books", repository.findAll());
        return "index";
    }
    
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) repository.findAll();
    }  
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/add")
    public String addStudent(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", crepository.findAll());
        return "add";
    }     
    
   @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Book findBookRest(@PathVariable("id") Long id) {	
    	return repository.findOne(id);      //findOne() undefined
    } 
  
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:index";
    }    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookid, Model model) {
    	repository.delete(bookid); //cant do delete(Long bookid) why?
   	 return "redirect:../index";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookid,  Model model) {
    	model.addAttribute("book", repository.findOne(bookid));
    	model.addAttribute("categories", crepository.findAll());
   	 return "edit";
   	 
    }

}


