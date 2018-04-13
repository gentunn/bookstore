package com.bookstore.store;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.bookstore.store.domain.CategoryRepository;
import com.bookstore.store.domain.Category;


@RunWith(SpringRunner.class)
@DataJpaTest
public class CategoryRepositoryTests {
    @Autowired
    private CategoryRepository repository;

    @Test
    public void findByNameShouldReturnName() {
        List<Category> categories = repository.findByName("Fiction");
        
        assertThat(categories).hasSize(1);
        assertThat(categories.get(0).getName()).isEqualTo("Fiction");;
    }
    
    @Test
    public void createNewCategory() {
    	Category category = new Category("Suspense");
    	repository.save(category);
    	assertThat(category.getCategoryId()).isNotNull();
    }   
    @Test
    public void deleteCategory() {
    	List<Category> categories = repository.findByName("Fiction");
    	repository.delete(categories.get(0));
    	List<Category> categorieTwo = repository.findByName("Fiction");
    	assertThat(categorieTwo).hasSize(0);
    }     
}
