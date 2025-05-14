package com.test.SpringBootCRUD.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.SpringBootCRUD.entity.Category;
import com.test.SpringBootCRUD.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
    private CategoryService categoryservice;

    public CategoryController(){
        System.out.println("Categorycontroller is created");
    }

    @GetMapping
    public Page<Category> getAllCategories(@RequestParam(defaultValue = "0")int page,
                                           @RequestParam(defaultValue = "10")int size
                                           ){
        return categoryservice.getAllCategory(page, size);

    }
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category){
        return ResponseEntity.ok(categoryservice.createCategory(category));
    }

    @GetMapping("/{id}")
   public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
       Optional<Category> category = categoryservice.getCategoryById(id);
       return category.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
   }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category uc = categoryservice.updateCategory(id, category);
        return uc !=null? ResponseEntity.ok(uc):ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        return categoryservice.deleteCategory(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }
}
