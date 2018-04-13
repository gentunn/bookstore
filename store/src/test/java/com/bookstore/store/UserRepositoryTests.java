package com.bookstore.store;

import static org.assertj.core.api.Assertions.assertThat;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import  com.bookstore.store.domain.UserRepository;

import  com.bookstore.store.domain.User;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTests {
	 @Autowired
	    private UserRepository repository;

	    @Test
	    public void findByUsernameShouldReturnHash() {
	        User userTest = repository.findByUsername("admin");
	        
	        assertThat(userTest.getId()).isNotNull();
	        assertThat(userTest.getPasswordHash()).isEqualTo("$2a$04$iC/KuaG5sTRzC.NCT0pvW.Hk7evaWuciOtd.BbJGljzNNwFIO1mnC");;
	    }
	    
	    @Test
	    public void createNewUser() {
	    	User user = new User("tester", "$2a$04$sWqJIitXNxGOChvMcKf0eeNAV5NtmrQn.elUI9fN5tIII5LRsDQDO", "TESTER");
	    	repository.save(user);
	    	assertThat(user.getId()).isNotNull();
	    }    
   /* @Test
	    public void deleteUser() {
	    	User userTest = repository.findByUsername("user");
	    	assertThat(userTest.getId()).isNotNull();
	    	repository.delete(userTest);
	    	assertThat(userTest.getId()).isNull();
	    }   
	    */
}
