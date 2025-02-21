package com.demo.SpringBootJPA.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.SpringBootJPA.DTO.PageResponse;
import com.demo.SpringBootJPA.Entity.Category;
import com.demo.SpringBootJPA.repository.CategoryRepository;
import com.demo.SpringBootJPA.service.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
		
		@Autowired
	    private CategoryService categoryService;
		
		@Autowired
		private CategoryRepository categoryRepository;

//	    @GetMapping
//	    public Page<Category> getAllCategories(Pageable pageable) {
//	        return categoryService.getAllCategories(pageable);
//	    }
		
//get categories with pagination (default size - 5)		
		 @GetMapping
		 public PageResponse<Category> getAllCategories(@RequestParam(defaultValue="1")int page) {
			 Page<Category> categoryPage = categoryRepository.findAll(PageRequest.of(page, 5));
			 return new PageResponse<>(categoryPage.getContent(),categoryPage.getNumber());
		 }
		
	    @GetMapping("/{id}")
	    public Optional<Category> getCategoryById(@PathVariable Long id) {
	        return categoryService.getCategoryById(id);
	    }

	    @PostMapping
	    public Category createCategory(@RequestBody Category category) {
	        return categoryService.createCategory(category);
	    }

	    @PutMapping("/{id}")
	    public Category updateCategory(@PathVariable Long id, @RequestBody Category category) {
	        return categoryService.updateCategory(id, category);
	    }

	    @DeleteMapping("/{id}")
	    public void deleteCategory(@PathVariable Long id) {
	    	categoryService.deleteCategory(id);
	    }
}
